package company.service;

import company.model.Writer;
import company.repository.WriterRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class WriterServiceTest {
    @Mock
    private WriterRepository writerRepository;

    @InjectMocks
    private WriterService writerService;

    @Test
    public void saveTest_Successful(){
        Mockito.when(writerRepository.save(any(Writer.class))).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertEquals("Alex",writerService.save(new Writer()).getFirstName());
    }
    @Test
    public void saveTest_unSuccessful(){
        Mockito.when(writerRepository.save(any(Writer.class))).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertNotEquals("Pushkin",writerService.save(new Writer()).getFirstName());
    }
    @Test
    public void updateTest_Successful(){
        Mockito.when(writerRepository.save(any(Writer.class))).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertEquals("Pushkin",writerService.save(new Writer()).getLastName());
    }
    @Test
    public void updateTest_unSuccessful(){
        Mockito.when(writerRepository.save(any(Writer.class))).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertNotEquals("Alex",writerService.save(new Writer()).getLastName());
    }
    @Test
    public void findByIDTest_Successful(){
        Mockito.when(writerRepository.findByID(anyInt())).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertEquals("Alex",writerService.findByID(anyInt()).getFirstName());
    }
    @Test
    public void findByIDTest_unSuccessful(){
        Mockito.when(writerRepository.findByID(anyInt())).thenReturn(new Writer("Alex","Pushkin"));
        Assertions.assertNotEquals("Al",writerService.findByID(anyInt()).getFirstName());
    }
    @Test
    public void getAllTest_Successful(){
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("Alex","Pushkin"));
        writers.add(new Writer("Lev","Tolstoy"));
        Mockito.when(writerRepository.getAll()).thenReturn(writers);
        Assertions.assertEquals("Alex",writerService.getAll().get(0).getFirstName());
    }

    @Test
    public void getAllTest_unSuccessful(){
        List<Writer> writers = new ArrayList<>();
        writers.add(new Writer("Alex","Pushkin"));
        writers.add(new Writer("Lev","Tolstoy"));
        Mockito.when(writerRepository.getAll()).thenReturn(writers);
        Assertions.assertNotEquals("Pushkin",writerService.getAll().get(0).getFirstName());
    }

}
