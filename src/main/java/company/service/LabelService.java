package company.service;

import company.model.Label;
import company.repository.LabelRepository;
import company.repository.hibernate.HibernateLabelRepositoryImpl;

import java.util.List;

public class LabelService {
    private final LabelRepository labelRepository;

    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public LabelService() {
        labelRepository = new HibernateLabelRepositoryImpl();
    }


    public Label create(Label label) {
        return labelRepository.save(label);
    }

    public Label update(Label label) {
        return labelRepository.update(label);
    }

    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    public Label findById(Integer id) {
        return labelRepository.findByID(id);
    }

    public void delete(Integer id) {
        labelRepository.delete(id);
    }
}
