package company.controller;

import company.model.Label;
import company.service.LabelService;

import java.util.List;

public class LabelController {
    private LabelService labelService = new LabelService();

    public Label save(Label label) {
        return labelService.create(label);
    }

    public Label update(Label label) {
        return labelService.update(label);
    }

    public List<Label> getAll() {
        return labelService.getAll();
    }

    public Label findById(Integer id) {
        return labelService.findById(id);
    }

    public void delete(Integer id) {
        labelService.delete(id);
    }
}
