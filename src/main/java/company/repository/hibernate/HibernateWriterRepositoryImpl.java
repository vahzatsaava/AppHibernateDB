package company.repository.hibernate;

import company.model.Writer;
import company.utils.HibernateUtils;
import company.repository.WriterRepository;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer findByID(int id) {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createQuery(" FROM Writer as u left JOIN FETCH u.posts where u.id = :id");
            query.setParameter("id",id);
            return (Writer) query.getSingleResult();
        }
    }

    @Override
    public Writer save(Writer writer) {
        try (Session session = HibernateUtils.getSession()) {
            session.save(writer);
            return writer;
        }
    }

    @Override
    public Writer update(Writer writer) {
        try (Session session = HibernateUtils.getSession()) {
            session.beginTransaction();
            session.merge(writer);
            session.getTransaction().commit();
            return writer;
        }
    }

    @Override
    public List<Writer> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createQuery("from Writer ");
            return (List<Writer>) query.getResultList();
        }

    }

    @Override
    public void delete(int id) {
        try (Session session = HibernateUtils.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Writer where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();

        }
    }
}
