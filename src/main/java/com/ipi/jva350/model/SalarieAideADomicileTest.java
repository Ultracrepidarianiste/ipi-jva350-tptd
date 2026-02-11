package com.ipi.jva350.model;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;


import static org.testng.Assert.*;

public class SalarieAideADomicileTest {
    // Attendu qu'on ait un False
    @Test
    public void testALegalementDroitADesCongesPayesNON() {
        //given
        SalarieAideADomicile s = new SalarieAideADomicile();

        //When
        s.setJoursTravaillesAnneeNMoins1(10);
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

    // Attendu que ça soit False pour SalarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage()
    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage_simpleNON() {
        // GIVEN
        SalarieAideADomicile s = new SalarieAideADomicile();
        LocalDate debut = LocalDate.of(2024, 1, 2);
        LocalDate fin   = LocalDate.of(2024, 1, 4);

        // WHEN
        LinkedHashSet<LocalDate> jours = s.calculeJoursDeCongeDecomptesPourPlage(debut, fin);

        // THEN
        assertFalse(jours.contains(LocalDate.of(2024, 1, 1)));
    }

    // Attendu que ça soit True pour SalarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage()
    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage_simpleOUI() {
        // GIVEN
        SalarieAideADomicile s = new SalarieAideADomicile();
        LocalDate debut = LocalDate.of(2024, 1, 2);
        LocalDate fin   = LocalDate.of(2024, 1, 4);

        // WHEN
        LinkedHashSet<LocalDate> jours = s.calculeJoursDeCongeDecomptesPourPlage(debut, fin);

        // THEN
        assertTrue(jours.contains(LocalDate.of(2024, 1, 2)));
        assertTrue(jours.contains(LocalDate.of(2024, 1, 3)));
        assertTrue(jours.contains(LocalDate.of(2024, 1, 4)));
    }

    // Attendu que le equals renvoie True pour SalarieAideADomicile.calculeJoursDeCongeDecomptesPourPlage()
    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlage_simpleSIZE() {
        // GIVEN
        SalarieAideADomicile s = new SalarieAideADomicile();
        LocalDate debut = LocalDate.of(2024, 1, 2);
        LocalDate fin   = LocalDate.of(2024, 1, 4);

        // WHEN
        LinkedHashSet<LocalDate> jours = s.calculeJoursDeCongeDecomptesPourPlage(debut, fin);

        // THEN
        assertEquals(jours.size(), 3);
    }







}
