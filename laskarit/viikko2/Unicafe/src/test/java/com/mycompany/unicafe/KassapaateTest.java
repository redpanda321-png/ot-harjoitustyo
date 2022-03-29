package com.mycompany.unicafe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class KassapaateTest {

    Kassapaate kassapaate;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }

    @Test
    public void luotuKassapaateOlemassa() {
        assertTrue(kassapaate != null);
    }
    @Test
    public void rahaMaaraOikeinAlussa() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void maukkaitaMyytyOikeaMaaraAlussa() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void edullisiaMyytyOikeaMaaraAlussa() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassanRahaKasvaaKunSyoEdullisesti() {
        int maksu = 240;
        assertEquals(maksu - 240, kassapaate.syoEdullisesti(maksu));
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void kassanRahaKasvaaKunSyoMaukkaasti() {
        int maksu = 400;
        assertEquals(maksu - 400, kassapaate.syoMaukkaasti(maksu));
        assertEquals(100400, kassapaate.kassassaRahaa());
    }

    @Test
    public void kassanRahaEiKasvaKunRahatEivatRiita() {
        kassapaate.syoEdullisesti(10);
        kassapaate.syoMaukkaasti(10);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiToimiiKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassapaate.syoEdullisesti((kortti)));
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiToimiiKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttiOstosRahaaEiRiita() {
        Maksukortti kortti = new Maksukortti(150);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertEquals(150, kortti.saldo());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kortinLatausNostaaSaldoa() {
        Maksukortti kortti = new Maksukortti(150);
        kassapaate.lataaRahaaKortille(kortti, 850);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void kortinLatausNostaaKassaa() {
        Maksukortti kortti = new Maksukortti(150);
        kassapaate.lataaRahaaKortille(kortti, 850);
        assertEquals(100850, kassapaate.kassassaRahaa());
    }

    @Test
    public void kortinLatausNegatiivisellaLuvullaEiSallittu() {
        Maksukortti kortti = new Maksukortti(150);
        kassapaate.lataaRahaaKortille(kortti, -200);
        assertEquals(150, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
}
