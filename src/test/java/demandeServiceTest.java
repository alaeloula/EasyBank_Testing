import com.java.easybank_v4.Entities.Client;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.implementation.DemandeDao;
import com.java.easybank_v4.services.DemandeService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class demandeServiceTest {
    @Mock
    DemandeDao demandeDao;
    DemandeService demandeService=new DemandeService(demandeDao);;


    @BeforeEach
    public void setUp(){
        System.out.println("test ùùù");
        MockitoAnnotations.openMocks(this);
        demandeService = new DemandeService(demandeDao);
    }
    @Test
    public void testAdd() {
        Client c = new Client();
        c.setId(1);
        DemanderCredit demandeCredit = new DemanderCredit(0.035, 10000.0, 500.0, 12, "Remarques", c);

        // Mocking the demandeService
        when(demandeService.ajouter(demandeCredit)).thenReturn(Optional.of(demandeCredit));

        // Calling the method under test
        Optional<DemanderCredit> result = demandeService.ajouter(demandeCredit);

        // Assertions
        assertTrue(result.isPresent());
        //assertEquals(demandeCredit, result.get());
        // Uncomment this line if you want to verify that demandeDao.add(demandeCredit) is called
         verify(demandeDao).ajoute(demandeCredit);
    }

//    public void testAdd(){
//        Client c= new Client();
//        c.setId(1);
//        DemanderCredit demandeCredit = new DemanderCredit(0.035, 10000.0, 500.0, 12, "Remarques", c);
//        when(demandeService.ajouter(demandeCredit)).thenReturn(Optional.of(demandeCredit));
//        Optional<DemanderCredit> result = demandeService.ajouter(demandeCredit);
//        assertTrue(result.isPresent());
//        assertEquals(demandeCredit,result.get());
//        //verify(demandeDao).add(demandeCredit);
//    }

    @Test
    public void getall(){
        List<DemanderCredit> listdemande= new ArrayList<>();
        listdemande.add(new DemanderCredit());
        listdemande.add(new DemanderCredit());
        when(demandeService.afficher()).thenReturn(listdemande);
        List<DemanderCredit> result = demandeService.afficher();
        assertEquals(result.size(),2);
        verify(demandeDao).afficher();
    }

}
