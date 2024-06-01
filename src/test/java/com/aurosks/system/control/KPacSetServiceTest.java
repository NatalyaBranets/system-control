package com.aurosks.system.control;

import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.repository.KPacSetDAO;
import com.aurosks.system.control.service.KPacSetService;
import com.aurosks.system.control.service.KPacSetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {
        com.aurosks.system.control.config.WebAppInitializer.class,
        com.aurosks.system.control.config.ApplicationConfiguration.class
})
@WebAppConfiguration
public class KPacSetServiceTest {
    @Mock
    KPacSetDAO kPacSetDAO;
    @InjectMocks
    KPacSetService kPacSetService = new KPacSetServiceImpl();

    @Test
    public void getAllTest() {
        // prepare
        List<KPacSet> testData = new ArrayList<>();
        KPacSet kPacSet = new KPacSet();
        kPacSet.setKPacs(new HashSet<>());
        kPacSet.setId(1);
        kPacSet.setTitle("Title1");

        testData.add(kPacSet);

        when(this.kPacSetDAO.getAll()).thenReturn(testData);

        // act
        List<KPacSet> actual = this.kPacSetService.getAll();

        // assert
        assertEquals(testData.size(), actual.size());
    }
}
