package com.ipi.jva350.model;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SalarieAideADomicileTest {
    // Attendu qu'on ait un False
    @Test
    public void testALegalementDroitADesCongesPayesNON() {
        //given
        SalarieAideADomicile s = new SalarieAideADomicile();

        //When
        s.setJoursTravaillesAnneeNMoins1(0);
        //then
        assertFalse(s.aLegalementDroitADesCongesPayes());
        // assertTrue(s.aLegalementDroitADesCongesPayes());
    }
    // Attendu qu'on ait un true
    @Test
    public void testALegalementDroitADesCongesPayesOUI() {
        //given
        SalarieAideADomicile s = new SalarieAideADomicile();

        //When
        s.setJoursTravaillesAnneeNMoins1(11);
        //then
        assertTrue(s.aLegalementDroitADesCongesPayes());
        // assertFalse(s.aLegalementDroitADesCongesPayes());
    }

    // SalarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage().








}
