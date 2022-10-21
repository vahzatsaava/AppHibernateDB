package company.repository.postgres;

import company.model.Label;
import company.model.Post;
import company.postgres_db_utils.HibernateSessionFactory;
import company.repository.PostRepository;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class PostgresPostRepositoryImpl implements PostRepository {
    @Override
    public Post findByID(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Post.class, id);
    }

    @Override
    public Post save(Post post) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(post);
        closeSessionAndCommitTransaction(session, transaction);
        return post;
    }

    @Override
    public Post update(int id, Post post) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Post set content = :content, created = :created, updated=:updated where id = :id");
        query.setParameter("content", post.getContent());
        query.setParameter("created", post.getCreated());
        query.setParameter("updated", post.getUpdated());
        query.setParameter("id", post.getId());
        query.executeUpdate();
        closeSessionAndCommitTransaction(session, transaction);

        return post;
    }

    @Override
    public List<Post> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Post ");
        List<Post> posts = query.getResultList();
        closeSessionAndCommitTransaction(session, transaction);
        return posts;
    }

    @Override
    public void delete(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Post where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();

        closeSessionAndCommitTransaction(session, transaction);
    }

    @Override
    public List<Label> getLabels(int postID) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Post as P left join fetch P.labels where P.id =:id");
        query.setParameter("id",postID);
        List<Label> labels = query.getResultList();
        closeSessionAndCommitTransaction(session, transaction);
        return labels;
    }

    private void closeSessionAndCommitTransaction(Session session, Transaction transaction) {
        transaction.commit();
        session.close();
    }
}
