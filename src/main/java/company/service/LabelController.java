package company.service;

import company.model.Label;
import company.repository.LabelRepository;
import company.repository.postgres.PostgresLabelRepositoryImpl;

import java.util.List;

public class LabelController {
    private final LabelRepository labelRepository;

    public LabelController() {
        this.labelRepository = new PostgresLabelRepositoryImpl();
    }

    public Label save(Label label) {
        return labelRepository.save(label);
    }

    public Label update(int id, Label label) {
        return labelRepository.update(id, label);
    }

    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    public Label findById(int id) {
        return labelRepository.findByID(id);
    }

    public void delete(int id) {
        labelRepository.delete(id);
    }
}
