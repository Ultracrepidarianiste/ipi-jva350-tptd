package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class SalarieAideADomicileServiceTest {

    @Mock
    private SalarieAideADomicileRepository repository;

    @InjectMocks
    private SalarieAideADomicileService service;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(expectedExceptions = SalarieException.class)
    public void testAjouteConge_pasDroitAuxConges() throws SalarieException {
        SalarieAideADomicile s = mock(SalarieAideADomicile.class);
        when(s.aLegalementDroitADesCongesPayes()).thenReturn(false);

        service.ajouteConge(s, LocalDate.now(), LocalDate.now().plusDays(1));
    }
}
