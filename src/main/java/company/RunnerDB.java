package company;

import company.model.Label;
import company.model.Post;
import company.model.Writer;
import company.repository.WriterRepository;
import company.repository.postgres.PostgresLabelRepositoryImpl;
import company.repository.postgres.PostgresPostRepositoryImpl;
import company.repository.postgres.PostgresWriterRepositoryImpl;

import java.sql.Date;
import java.sql.Timestamp;

public class RunnerDB {
    public static void main(String[] args) {
        PostgresLabelRepositoryImpl postgresLabelRepository = new PostgresLabelRepositoryImpl();
        PostgresPostRepositoryImpl postgresPostRepository = new PostgresPostRepositoryImpl();
        WriterRepository repository = new PostgresWriterRepositoryImpl();
        Writer writer = new Writer("Garry","Gudini");
        Post post = new Post("tv",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));
        Label label = new Label("TV");
        System.out.println(writer);

       Label newLabel = new Label("fetch");
       postgresLabelRepository.save(newLabel);




        //postgresPostRepository.save(new Post("tv",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis())));
        //postgresLabelRepository.update(2,new Label("Felix"));
        //postgresLabelRepository.delete(1);
        //System.out.println(postgresLabelRepository.findByID(2));
        //System.out.println(postgresLabelRepository.getAll());
    }
}
