package company.service;

import company.model.Label;
import company.repository.LabelRepository;
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
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LabelServiceTest {
    @Mock
    private LabelRepository labelRepository;

    @InjectMocks
    private LabelService labelService;

    private final List<Label> listLabels() {
        List<Label> labels = new ArrayList<>();
        labels.add(new Label("Garry"));
        labels.add(new Label("Charly"));
        return labels;
    }

    @Test
    public void createTest_Successful() {
        Mockito.when(labelRepository.save(any(Label.class))).thenReturn(new Label("Alfa"));
        Assertions.assertEquals("Alfa", labelService.create(new Label(anyString())).getName());
    }

    @Test
    public void createTest_unSuccessful() {
        Mockito.when(labelRepository.save(any(Label.class))).thenReturn(new Label("Alfa"));
        Assertions.assertNotEquals("abc", labelService.create(new Label(anyString())).getName());
    }

    @Test
    public void updateTest_Successful() {
        Mockito.when(labelRepository.update(any(Label.class))).thenReturn(new Label("abc"));
        Assertions.assertEquals("abc",labelService.update(new Label(anyString())).getName());
    }
    @Test
    public void updateTest_unSuccessful() {
        Mockito.when(labelRepository.update(any(Label.class))).thenReturn(new Label("abc"));
        Assertions.assertNotEquals("ccc",labelService.update(new Label(anyString())).getName());
    }

    @Test
    public void getAllTest_Successful() {
        Mockito.when(labelRepository.getAll()).thenReturn(listLabels());
        Assertions.assertEquals(listLabels().toString(), labelService.getAll().toString());
    }
    @Test
    public void getAllTest_unSuccessful() {
        Mockito.when(labelRepository.getAll()).thenReturn(listLabels());
        Assertions.assertNotEquals(null, labelService.getAll());
    }

    @Test
    public void findByIdTest_Successful() {
        Mockito.when(labelRepository.findByID(Mockito.anyInt())).thenReturn(new Label("abc"));
        Assertions.assertEquals("abc",labelService.findById(Mockito.anyInt()).getName());
    }
    @Test
    public void findByIdTest_unSuccessful() {
        Mockito.when(labelRepository.findByID(Mockito.anyInt())).thenReturn(new Label("abc"));
        Assertions.assertNotEquals("aaa",labelService.findById(Mockito.anyInt()).getName());
    }
}