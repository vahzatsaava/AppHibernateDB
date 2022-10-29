package company.service;

import company.model.Writer;
import company.repository.WriterRepository;
import company.repository.hibernate.HibernateWriterRepositoryImpl;

import java.util.List;

public class WriterService {
    private final WriterRepository writerRepository;
    public WriterService (){
        this.writerRepository = new HibernateWriterRepositoryImpl();
    }

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }
    public Writer save(Writer writer){
        return writerRepository.save(writer);
    }
    public Writer update(Writer writer){
        return writerRepository.update(writer);
    }
    public List<Writer> getAll(){
        return writerRepository.getAll();
    }
    public Writer findByID(Integer id){
        return writerRepository.findByID(id);
    }
    public void delete(Integer id){
        writerRepository.delete(id);
    }
}
