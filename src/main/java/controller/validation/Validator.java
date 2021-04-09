package controller.validation;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isFirstnameValid(String firstname){
        boolean isValid = false;
        //between 2 - 20 characters. (can contain a-z + æøå) upper and lower case + dash and space
        String regex = "^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{1,19}$";
        if(Pattern.matches(regex, firstname)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isLastnameValid(String lastname){
        boolean isValid = false;
        //between 2 - 20 characters. (can contain a-z + æøå) upper and lower case + dash
        String regex = "^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]{1,19}$";
        if(Pattern.matches(regex, lastname)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isAddressValid(String address){
        boolean isValid = false;
        //between 5 - 30 characters. (can contain a-z + æøå) upper and lower case + 0-9 + dash and space
        String regex = "^[A-ZÆØÅ][a-zæøåA-ZÆØÅ0-9 -]{4,29}$";
        if(Pattern.matches(regex, address)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isEmailValid(String email){
        boolean isValid = false;
        //all letters + numbers + "._%+-" before @ all letters + numbers + ".-" then a mandatory . and 6 letters behind the . (example: .com)
        String regex = "^[a-zæøåA-ZÆØÅ0-9._%+-]+@[a-zæøåA-ZÆØÅ0-9.-]+[.][a-zA-Z]{2,6}$";
        if(Pattern.matches(regex, email) && email.length() >= 6 && email.length() <= 40){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isUsernameValid(String username){
        boolean isValid = false;
        //all letters(upper and lower case) and numbers + space + dash + dot + underscore. between 4 and 20 characters
        String regex = "^[a-zæøåA-ZÆØÅ0-9 _.-]{4,20}$";
        if(Pattern.matches(regex, username)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isPhoneValid(String phoneNumber){
        boolean isValid = false;
        // must be 8 numerical digits.
        String regex = "^[0-9]{8}$";
        if(Pattern.matches(regex, phoneNumber)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isPasswordValid(String password){
        boolean isValid = false;
        // between 8-20 letters, atleast 1 capital letter and 1 numerical digits and 1 special character such as (!@#$%^&*.-).
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*._-])[a-zA-Z0-9!@#$%^&*._-]{8,20}$";
        if(Pattern.matches(regex, password)){
            isValid = true;
        }
        return isValid;
    }
    public static boolean isRepeatPasswordValid(String password, String repeatPassword){
        boolean isValid = false;
        if(password.equals(repeatPassword)){
            isValid = true;
        }
        return isValid;
    }
}