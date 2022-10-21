package company.repository.postgres;

import company.model.Label;
import company.model.Post;
import company.repository.LabelRepository;
import company.postgres_db_utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class PostgresLabelRepositoryImpl implements LabelRepository {
    @Override
    public Label findByID(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Label d WHERE d.id = id");
        List<Label> labels = query.getResultList();
        transaction.commit();
        session.close();
        return labels.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Label save(Label label) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(label);
        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public Label update(int id, Label label) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Label newLabel = session.get(Label.class, id);
        newLabel.setName(label.getName());
        session.update(newLabel);
        transaction.commit();
        session.close();
        return newLabel;
    }

    @Override
    public List<Label> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Label ");
        List<Label> labels = query.getResultList();
        transaction.commit();
        session.close();
        return labels;
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Label where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public Label saveLabelAndAddPost(int postID, Label label)  {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(label);
        Post existPost = session.get(Post.class, postID);
        session.saveOrUpdate(existPost);
        label.setPost(existPost);
        transaction.commit();
        session.close();
        return label;
    }
}
