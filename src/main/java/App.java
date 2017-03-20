import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("file.cfg.xml")
                .buildSessionFactory();

        sessionFactory.close();
    }
}
