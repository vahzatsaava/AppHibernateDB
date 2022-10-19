package company;

import company.model.Label;
import company.repository.postgres.PostgresLabelRepositoryImpl;

public class RunnerDB {
    public static void main(String[] args) {
        PostgresLabelRepositoryImpl postgresLabelRepository = new PostgresLabelRepositoryImpl();
        //postgresLabelRepository.save(new Label("Tomas"));

        //postgresLabelRepository.update(2,new Label("Felix"));
        postgresLabelRepository.delete(1);
        System.out.println(postgresLabelRepository.findByID(2));
        System.out.println(postgresLabelRepository.getAll());
    }
}
