package com.ipi.jva350.repository;

import com.ipi.jva350.model.SalarieAideADomicile;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SalarieAideADomicileRepositoryTest {
    // Test FindByNom Qui doit vérifier qu'on trouve un nom qui existe bien dans mes données.
    @Test
    public void testFindByNomOUI() {
        // GIVEN : démarrer Spring Boot et récupérer le repository
        ApplicationContext context =
                SpringApplication.run(com.ipi.jva350.Jva350Application.class);

        SalarieAideADomicileRepository repository =
                context.getBean(SalarieAideADomicileRepository.class);

        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setNom("Dupont");
        repository.save(s);

        // WHEN
        SalarieAideADomicile result = repository.findByNom("Dupont");

        // THEN
        assertNotNull(result);
        assertEquals(result.getNom(), "Dupont");
    }
    // Test findbynom qui doit vérifier qu'on trouve rien si on met n'importe nawak
    @Test
    public void testFindByNom_NON() {
        // GIVEN
        ApplicationContext context =
                SpringApplication.run(com.ipi.jva350.Jva350Application.class);

        SalarieAideADomicileRepository repository =
                context.getBean(SalarieAideADomicileRepository.class);

        // WHEN
        SalarieAideADomicile result = repository.findByNom("Inconnu");

        // THEN
        assertNull(result);
    }

}
