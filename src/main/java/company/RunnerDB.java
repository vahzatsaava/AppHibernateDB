package company;

import company.controller.PostController;
import company.controller.WriterController;
import company.model.Label;
import company.model.Post;
import company.model.Writer;
import company.repository.WriterRepository;
import company.repository.hibernate.HibernateLabelRepositoryImpl;
import company.repository.hibernate.HibernatePostRepositoryImpl;
import company.repository.hibernate.HibernateWriterRepositoryImpl;
import company.service.LabelService;
import company.service.PostService;
import company.view.MainView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RunnerDB {
    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.getMenu();
    }
}
