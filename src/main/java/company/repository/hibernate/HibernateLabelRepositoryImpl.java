package company.repository.hibernate;

import company.model.Label;
import company.repository.LabelRepository;
import company.utils.HibernateUtils;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class HibernateLabelRepositoryImpl implements LabelRepository {
    @Override
    public Label findByID(int id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(Label.class, id);
        }
    }

    @Override
    public Label save(Label label) {
        try (Session session = HibernateUtils.getSession()){
            session.save(label);
            return label;
        }
    }

    @Override
    public Label update(Label label) {
        try (Session session = HibernateUtils.getSession()){
            session.beginTransaction();
            session.merge(label);
            session.getTransaction().commit();
            return label;
        }
    }

    @Override
    public List<Label> getAll() {
        try (Session session = HibernateUtils.getSession()){
            Query query = session.createQuery("FROM Label ");
            return (List<Label>) query.getResultList();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = HibernateUtils.getSession()){
            session.beginTransaction();
            Query query = session.createQuery("delete from Label where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

}
