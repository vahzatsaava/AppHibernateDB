package company.service;

import company.model.Label;
import company.model.Post;
import company.model.Writer;
import company.repository.LabelRepository;
import company.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.Serializable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
class LabelServiceTest {

    @Mock
    private LabelRepository labelRepository;

    @InjectMocks
    private LabelService labelService;

    @Test
    void create() {

        Mockito.when(labelRepository.save(any(Label.class))).thenReturn(new Label("abc"));
        Assertions.assertEquals("abc",labelRepository.save(new Label("vvv")).getName());
        //Assertions.assertEquals("abc", labelRepository.save(new Label("asd")).toString());

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