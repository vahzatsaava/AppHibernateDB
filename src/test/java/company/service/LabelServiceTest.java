package company.service;

import company.model.Label;
import company.repository.LabelRepository;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(MockitoJUnitRunner.class)
class LabelServiceTest extends TestCase{

    @Mock
    private LabelRepository labelRepository;

    @InjectMocks
    private LabelService service;

    @Test
    void testSaveLabelTest_Successful() {
       Mockito.when(labelRepository.save(any(Label.class))).thenReturn(new Label("Alfa"));
       Assertions.assertEquals("Alfa", service.create(new Label(anyString())).getName());
    }

    @Test
    void saveLabelTest_UnSuccessful() {

    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }

    @Test
    void findById() {
    }
}