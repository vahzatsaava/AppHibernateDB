package company.utils;

import company.model.Label;
import company.model.Post;
import company.model.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private HibernateUtils() {

    }

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Label.class);
                configuration.addAnnotatedClass(Post.class);
                configuration.addAnnotatedClass(Writer.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception with session " + e);
            }
        }
        return sessionFactory;
    }
    public static Session getSession(){
        return getSessionFactory().openSession();
    }
}
