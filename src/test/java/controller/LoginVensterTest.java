package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginVensterTest {
    @Test
    public void testGeslaagdeLogin(){
        Account test = new Account("a", "a", 1);
        Account actual = new Account("a", "a", 1);
        assertEquals(test.getUsername(), actual.getUsername());
        assertEquals(test.getPassword(), actual.getPassword());
        assertEquals(test.getUserNumber(), actual.getUserNumber());
    }

    @Test
    public void testFailedLogin1(){
        Account test = new Account("b", "a", 1);
        Account actual = new Account("a", "a", 1);
        assertNotEquals(test.getUsername(), actual.getUsername());
        assertEquals(test.getPassword(), actual.getPassword());
        assertEquals(test.getUserNumber(), actual.getUserNumber());
    }

    @Test
    public void testFailedLogin2(){
        Account test = new Account("a", "b", 1);
        Account actual = new Account("a", "a", 1);
        assertEquals(test.getUsername(), actual.getUsername());
        assertNotEquals(test.getPassword(), actual.getPassword());
        assertEquals(test.getUserNumber(), actual.getUserNumber());
    }

    @Test
    public void testFailedLogin3(){
        Account test = new Account("a", "a", 2);
        Account actual = new Account("a", "a", 1);
        assertEquals(test.getUsername(), actual.getUsername());
        assertEquals(test.getPassword(), actual.getPassword());
        assertNotEquals(test.getUserNumber(), actual.getUserNumber());
    }
}