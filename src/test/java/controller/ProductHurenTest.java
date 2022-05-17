package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductHurenTest {

    ProductHuren p = new ProductHuren(true, 1, 1, true);

    @Test
    public void ProductHurenTest1(){
        assertEquals(p.keuzeKlant(true, 1, 1, true), true);
        assertEquals(p.keuzeKlant(false, 5, 1, false), true);
    }

    @Test
    public void ProductHurenTest2(){
        assertEquals(p.keuzeKlant(true, 1, 4, false), true);
        assertEquals(p.keuzeKlant(false, 5, 4, true), true);
    }

    @Test
    public void ProductHurenTest3(){
        assertEquals(p.keuzeKlant(true, 1, 24, true), true);
        assertEquals(p.keuzeKlant(false, 5, 24, false), true);
    }

}