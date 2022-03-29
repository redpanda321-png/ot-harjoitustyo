package com.mycompany.unicafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void saldonLataaminenToimiiOikein() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }

    @Test
    public void saldonOttaminenToimiiOikein() {
        Maksukortti kortti = new Maksukortti(10000);
        kortti.otaRahaa(5000);
        assertEquals("saldo: 50.0", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void trueJosRahatRiittivat() {
        assertTrue(kortti.otaRahaa(10));
    }

    @Test
    public void falseJosRahatEiRiitä() {
        assertTrue(!kortti.otaRahaa(20));
    }
}
