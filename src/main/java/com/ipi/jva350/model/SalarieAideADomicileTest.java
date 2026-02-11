package com.ipi.jva350.model;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class SalarieAideADomicileTest {

    @Test
    public void testALegalementDroitADesCongesPayes() {
        //given
        SalarieAideADomicile s = new SalarieAideADomicile();

        // TEST 1 : 0 jours travaillés
        //When
        s.setJoursTravaillesAnneeNMoins1(0);
        //then
        assertFalse(s.aLegalementDroitADesCongesPayes());
        // assertTrue(s.aLegalementDroitADesCongesPayes());

        // TEST 2 : 10 jours travaillés
        s.setJoursTravaillesAnneeNMoins1(10);
        assertFalse(s.aLegalementDroitADesCongesPayes());

        // TEST 3 : 11 jours travaillés Donc celui où il a le droit
        s.setJoursTravaillesAnneeNMoins1(11);
        assertTrue(s.aLegalementDroitADesCongesPayes());
    }

    // SalarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage().

    @Test
    public void testALegalementDroitADesCongesPayes() {
        //given
        SalarieAideADomicile s = new SalarieAideADomicile();

        // TEST 1 : 0 jours travaillés
        //When
        s.setJoursTravaillesAnneeNMoins1(0);
        //then
        assertFalse(s.aLegalementDroitADesCongesPayes());
        // assertTrue(s.aLegalementDroitADesCongesPayes());

        // TEST 2 : 10 jours travaillés
        s.setJoursTravaillesAnneeNMoins1(10);
        assertFalse(s.aLegalementDroitADesCongesPayes());

        // TEST 3 : 11 jours travaillés Donc celui où il a le droit
        s.setJoursTravaillesAnneeNMoins1(11);
        assertTrue(s.aLegalementDroitADesCongesPayes());
    }






}
