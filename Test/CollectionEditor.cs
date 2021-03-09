using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEditor;
using System;

[CustomPropertyDrawer(typeof(ICollection), true)]
public class CollectionEditor : PropertyDrawer
{
    private int NumberOfElements = 0;

    public override float GetPropertyHeight(SerializedProperty property, GUIContent label)
    {
        NumberOfElements = 1;
        SerializedObject serializedObject = null;
        SerializedProperty numberOfElements = null;
        try
        {
            serializedObject = new SerializedObject(property.objectReferenceValue);
            numberOfElements = serializedObject.FindProperty("NumberOfElements");
        }
        catch (NullReferenceException) { }
        catch (ArgumentException) { }

        if (numberOfElements != null)
        {
            NumberOfElements = numberOfElements.intValue + 1;
        }

        return EditorGUIUtility.singleLineHeight * NumberOfElements;
    }

    public override void OnGUI(Rect position, SerializedProperty property, GUIContent label)
    {

        position = EditorGUI.PrefixLabel(position, GUIUtility.GetControlID(FocusType.Passive), label);
        label = EditorGUI.BeginProperty(position, label, property);

        EditorGUI.BeginChangeCheck();

        SerializedObject serializedObject = null;

        try
        {
            serializedObject = new SerializedObject(property.objectReferenceValue);
        }
        catch (ArgumentException) { }

        var main = new Rect(position.x, position.y + 2, position.width, 16);
        EditorGUI.PropertyField(main, property, GUIContent.none);

        EditorGUI.indentLevel = 1;

        if (serializedObject != null)
        {
            var prop = serializedObject.GetIterator();
            int pos = 0;

            GUI.enabled = false;
            prop.NextVisible(true); prop.NextVisible(true);

            for (int i = 0; i < NumberOfElements - 1; i++)
            {
                pos += 18;
                var rect = new Rect(position.x, position.y + pos + 2, position.width - 2, 16);
                var LabelRect = new Rect(position.x - 130, position.y + pos, position.width - 55, 16);

                EditorGUI.LabelField(LabelRect, prop.displayName);
                EditorGUI.PropertyField(rect, prop, GUIContent.none);
                prop.NextVisible(true);
            }

            GUI.enabled = true;
        }
        else
        {
            NumberOfElements = 0;
        }

        EditorGUI.indentLevel--;

        if (EditorGUI.EndChangeCheck())
        {
            if (serializedObject != null)
            {
                serializedObject.ApplyModifiedProperties();
            }
        }

        EditorGUI.EndProperty();
    }
}
