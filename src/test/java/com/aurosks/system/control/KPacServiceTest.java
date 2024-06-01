package com.aurosks.system.control;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;
import com.aurosks.system.control.repository.KPacDAO;
import com.aurosks.system.control.service.KPacService;
import com.aurosks.system.control.service.KPacServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {
        com.aurosks.system.control.config.WebAppInitializer.class,
        com.aurosks.system.control.config.ApplicationConfiguration.class
})
@WebAppConfiguration
public class KPacServiceTest {
    @Mock
    KPacDAO kPacDAO;
    @InjectMocks
    KPacService kPacService = new KPacServiceImpl();

    @Test
    public void getAllTest() {
        // prepare
        List<KPac> testData = new ArrayList<>();
        KPac kPac1 = new KPac();
        kPac1.setId(1);
        kPac1.setTitle("Title1");
        kPac1.setDescription("Description1");

        KPac kPac2 = new KPac();
        kPac2.setId(2);
        kPac2.setTitle("Title2");
        kPac2.setDescription("Description2");

        testData.add(kPac1);
        testData.add(kPac2);

        when(this.kPacDAO.getAll()).thenReturn(testData);

        // act
        List<KPac> actual = this.kPacService.getAll();

        // assert
        assertEquals(testData.size(), actual.size());
    }

    @Test
    public void saveTest() {
        // prepare
        KPacSaveRequest request = new KPacSaveRequest();
        request.setTitle("Title1");
        request.setDescription("Description1");
        doNothing().when(this.kPacDAO).save(request);

        // act
        this.kPacService.save(request);

        // assert
        verify(this.kPacDAO, times(1)).save(request);
    }

    @Test
    public void deleteByIdTest() {
        // prepare
        int id = 1;
        doNothing().when(this.kPacDAO).deleteById(id);

        // act
        this.kPacService.deleteById(id);

        // assert
        verify(this.kPacDAO, times(1)).deleteById(id);
    }

}
