package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1 = new Product("BMW", true, 50, 0.01, 0);

    @Test
    public void prijsTest0EuroExtra(){
        assertEquals(p1.Prijs(1250), 0);
    }

    @Test
    public void prijsTest100EuroExtra(){
        assertEquals(p1.Prijs(1251), 100);
    }

    @Test
    public void prijsTest100EuroExtra2(){
        assertEquals(p1.Prijs(2000), 100);
    }

    @Test
    public void prijsTest350EuroExtra(){
        assertEquals(p1.Prijs(2001), 250);
    }

}