package company.controller;

import company.model.Writer;
import company.service.WriterService;

import java.util.List;

public class WriterController {
    private WriterService writerService = new WriterService();

    public Writer save(Writer writer) {
        return writerService.save(writer);
    }

    public Writer update(Writer writer) {
        return writerService.update(writer);
    }

    public List<Writer> getAll() {
        return writerService.getAll();
    }

    public Writer findByID(Integer id) {
        return writerService.findByID(id);
    }

    public void delete(Integer id) {
        writerService.delete(id);
    }
}
