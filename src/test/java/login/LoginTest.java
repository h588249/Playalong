package login;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static controller.validation.LoginValidator.*;
import static org.junit.jupiter.api.Assertions.*;



public class LoginTest {

    @Test
    @DisplayName("isFirstnameValid")
    public void testIsFirstnameValid() {
        assertTrue(isFirstnameValid("Abcdeabcdeabcdeabcde"));//20 letters
        assertTrue(isFirstnameValid("Atle"));
        assertTrue(isFirstnameValid("Lars-Martin"));
        assertTrue(isFirstnameValid("Ola Conny"));

        assertFalse(isFirstnameValid("A"));
        assertFalse(isFirstnameValid("Atle2"));
        assertFalse(isFirstnameValid("Abcdefghijklmmopqrstu"));//21 letters
        assertFalse(isFirstnameValid("jerry"));
    }

    @Test
    @DisplayName("isLastnameValid")
    public void testIsLastnameValid() {
        assertTrue(isLastnameValid("Nordmann"));
        assertTrue(isLastnameValid("Ål"));
        assertTrue(isLastnameValid("Abcdefghijklmnopqrst"));//20 letters
        assertTrue(isLastnameValid("Bjørn-Olav"));

        assertFalse(isLastnameValid("Bjørn Olav"));
        assertFalse(isLastnameValid("A"));
        assertFalse(isLastnameValid("Navn2"));
        assertFalse(isLastnameValid("bjørnar"));
        assertFalse(isLastnameValid("Abcdefghijklmnopqrstu"));//21 letters
    }

    @Test
    @DisplayName("isAddressValid")
    public void testIsAddressValid() {
        assertTrue(isAddressValid("Roald-Amundsens Vei 42"));
        assertTrue(isAddressValid("Bjøneveien 72c"));
        assertTrue(isAddressValid("Inndalsveien 28"));
        assertTrue(isAddressValid("Vei 3"));

        assertFalse(isAddressValid("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah")); //41 letters
        assertFalse(isAddressValid("roald-amundsens vei 42"));
        assertFalse(isAddressValid("Vei 3!-."));
        assertFalse(isAddressValid("Vei3"));
    }

    @Test
    @DisplayName("isEmailValid")
    public void testIsEmailValid() {
        assertTrue(isEmailValid("playalong_customerservice@hotmail.com"));
        assertTrue(isEmailValid("musically@gmail.co.uk"));
        assertTrue(isEmailValid("ar@outlook.no"));
        assertTrue(isEmailValid("JonOlavBirgersen%912@gmail.com"));

        assertFalse(isEmailValid("8()@hotmail.com"));
        assertFalse(isEmailValid("Ola-Conny@@Outlook.no"));
        assertFalse(isEmailValid("AaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaa@gmail.com"));
        assertFalse(isEmailValid("Morgan@hotma!l.com"));
    }

    @Test
    @DisplayName("isUsernameValid")
    public void testIsUsernameValid() {
        assertTrue(isUsernameValid("Ørnemann27"));
        assertTrue(isUsernameValid("Morgan Ola-Conny"));
        assertTrue(isUsernameValid("abc_"));
        assertTrue(isUsernameValid("aaaaaaaaaaaaaaaaaaah")); //20 letters

        assertFalse(isUsernameValid("aaaaaaaaaaaaaaaaaaaah")); //21 letters
        assertFalse(isUsernameValid("Ola123!"));
        assertFalse(isUsernameValid("abc"));
        assertFalse(isUsernameValid("Abcd#"));
    }

    @Test
    @DisplayName("isPhoneValid")
    public void testIsPhoneValid() {
        assertTrue(isPhoneValid("12345678"));
        assertTrue(isPhoneValid("22559933"));
        assertTrue(isPhoneValid("19283746"));
        assertTrue(isPhoneValid("10293753"));

        assertFalse(isPhoneValid("1234567"));
        assertFalse(isPhoneValid("123456789"));
        assertFalse(isPhoneValid("123"));
        assertFalse(isPhoneValid("1234567j"));
    }

}
