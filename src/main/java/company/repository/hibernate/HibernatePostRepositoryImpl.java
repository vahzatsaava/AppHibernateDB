package company.repository.hibernate;
import company.model.Post;
import company.utils.HibernateUtils;
import company.repository.PostRepository;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository {
    @Override
    public Post findByID(int id) {
        try (Session session = HibernateUtils.getSession()){
            Query query = session.createQuery("from Post as p left join fetch p.labels left join fetch p.writer where p.id = :id");
            query.setParameter("id",id);
            return (Post) query.getSingleResult();
        }
    }

    @Override
    public Post save(Post post) {
        try (Session session = HibernateUtils.getSession()){
            session.save(post);
            return post;
        }
    }

    @Override
    public Post update(Post post) {
        try (Session session = HibernateUtils.getSession()){
            session.beginTransaction();
            session.merge(post);
            session.getTransaction().commit();
            return post;
        }
    }

    @Override
    public List<Post> getAll() {
        try (Session session = HibernateUtils.getSession()){
            Query query = session.createQuery("from Post AS p join fetch p.writer ");
            return query.getResultList();
        }
    }

    @Override
    public void delete(int id) {
        try(Session session = HibernateUtils.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Post where id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
