package company.repository.postgres;

import company.model.Writer;
import company.postgres_db_utils.HibernateSessionFactory;
import company.repository.WriterRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class PostgresWriterRepositoryImpl implements WriterRepository {
    @Override
    public Writer findByID(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Writer.class, id);
    }

    @Override
    public Writer save(Writer writer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(writer);
        closeSessionAndCommitTransaction(session,transaction);
        return writer;
    }

    @Override
    public Writer update(int id, Writer writer) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Writer set firstName = :firstName, lastName = :lastName where id = :id");
        query.setParameter("firstName", writer.getFirstName());
        query.setParameter("lastName", writer.getFirstName());
        query.setParameter("id", writer.getId());
        query.executeUpdate();
        closeSessionAndCommitTransaction(session,transaction);
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Writer ");
        List<Writer> writers = query.getResultList();
        closeSessionAndCommitTransaction(session,transaction);
        return writers;
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Writer where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        closeSessionAndCommitTransaction(session,transaction);
    }
    private void closeSessionAndCommitTransaction(Session session, Transaction transaction) {
        transaction.commit();
        session.close();
    }
}
