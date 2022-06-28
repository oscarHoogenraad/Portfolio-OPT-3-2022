package controller.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account test = new Medewerker("a", "b", 1, false);

    @Test
    public void test1(){
        assertEquals("a", test.getUsername());
    }

    @Test
    public void test2(){
        assertEquals("b", test.getPassword());
    }

    @Test
    public void test3(){
        assertEquals(1, test.getUserNumber());
    }
}