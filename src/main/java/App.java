import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("file.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        session.beginTransaction();
        Book book = new Book();
        book.setName("Book 1");
        session.persist(book);
        session.getTransaction().commit();

        session.beginTransaction();
        Book book1 = session.get(Book.class, 1);
        System.out.println(book1.getName());
        session.getTransaction().commit();




        session.clear();

        sessionFactory.close();
    }
}
