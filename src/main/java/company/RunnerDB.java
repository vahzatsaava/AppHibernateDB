package company;

import company.model.Label;
import company.model.Post;
import company.model.Writer;
import company.repository.WriterRepository;
import company.repository.hibernate.HibernateLabelRepositoryImpl;
import company.repository.hibernate.HibernatePostRepositoryImpl;
import company.repository.hibernate.HibernateWriterRepositoryImpl;
import company.service.LabelService;
import company.service.PostService;

import java.sql.Date;

public class RunnerDB {
    public static void main(String[] args) {
        HibernateLabelRepositoryImpl postgresLabelRepository = new HibernateLabelRepositoryImpl();
        HibernatePostRepositoryImpl postgresPostRepository = new HibernatePostRepositoryImpl();
        WriterRepository repository = new HibernateWriterRepositoryImpl();
        PostService service = new PostService();
        Writer writer = new Writer("Garry","Gudini");
        Label label = new Label("TV");


        Post post1 = new Post("tv",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),writer);
        Post post2 = new Post("radio",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),writer);
        Post post3 = new Post("paper",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),writer);
        Post post4 = new Post("b2b",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()),writer);
        Writer writer1 = new Writer("Garry","Man");
        LabelService service1 = new LabelService();
        service1.create(new Label("Floyd"));

        //postgresPostRepository.save(new Post("tv",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis())));
        //postgresLabelRepository.update(2,new Label("Felix"));
        //postgresLabelRepository.delete(1);
        //System.out.println(postgresLabelRepository.findByID(2));
        //System.out.println(postgresLabelRepository.getAll());
    }
}
