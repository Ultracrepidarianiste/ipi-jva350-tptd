package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class SalarieAideADomicileServiceIntegrationTest {

    private SalarieAideADomicileService service;
    private SalarieAideADomicileRepository repository;

    @BeforeMethod
    public void setup() {
        ApplicationContext context =
                SpringApplication.run(com.ipi.jva350.Jva350Application.class);

        service = context.getBean(SalarieAideADomicileService.class);
        repository = context.getBean(SalarieAideADomicileRepository.class);

        repository.deleteAll();
    }

    @Test
    public void testAjouteConge_integration() throws SalarieException {

        // GIVEN : salarié dans un état cohérent
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setNom("Dupont");

        // Année de congés : 1 juin 2024 → 31 mai 2025
        s.setMoisEnCours(LocalDate.of(2024, 6, 1));

        // Doit avoir travaillé > 10 jours N-1
        s.setJoursTravaillesAnneeNMoins1(20);

        // Doit avoir des congés acquis N-1
        s.setCongesPayesAcquisAnneeNMoins1(10);

        // Aucun congé pris N-1
        s.setCongesPayesPrisAnneeNMoins1(0);

        // Début de contrat (important pour limite entreprise)
        s.setMoisDebutContrat(LocalDate.of(2023, 1, 1));

        // Sauvegarde en base
        service.creerSalarieAideADomicile(s);

        // WHEN : congé parfaitement dans l'année de congés
        service.ajouteConge(
                s,
                LocalDate.of(2024, 6, 10),
                LocalDate.of(2024, 6, 11)
        );

        // THEN : 2 jours doivent être enregistrés
        SalarieAideADomicile updated = repository.findByNom("Dupont");

        assertNotNull(updated);
        assertEquals(updated.getCongesPayesPris().size(), 2);
    }


    @Test
    public void testFindByNomNON() {
        // GIVEN : démarrer Spring Boot et récupérer le repository
        ApplicationContext context =
                SpringApplication.run(com.ipi.jva350.Jva350Application.class);

        SalarieAideADomicileRepository repository =
                context.getBean(SalarieAideADomicileRepository.class);

        // On s'assure qu'il n'y a rien en base pour ce test précis
        repository.deleteAll();

        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setNom("Dupont");
        repository.save(s);

        // WHEN : on cherche un nom qui n'existe pas
        SalarieAideADomicile result = repository.findByNom("Durand");

        // THEN : on s'attend à ne rien trouver
        assertNull(result);
    }

}
