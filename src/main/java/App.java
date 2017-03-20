import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//JPQL
//CriteriaApi
//Native Query(SQL)

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("file.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        session.beginTransaction();


        Book b1 = new Book();
        b1.setName("b1");
        Book b2 = new Book();
        b2.setName("b2");
        Book b3 = new Book();
        b3.setName("b3");

        Author misha = new Author();
        misha.setName("Misha");
        Author petya = new Author();
        petya.setName("Petya");

        b1.addAuthor(misha);
        b2.addAuthor(misha);
        b3.addAuthor(misha);
        b3.addAuthor(petya);

        session.persist(b1);
        session.persist(b2);
        session.persist(b3);
        session.persist(misha);
        session.persist(petya);


        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }
}
