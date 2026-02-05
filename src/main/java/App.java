import fr.epsi.b32526.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

            Book book = em.find(Book.class, 1);

            if (book != null) {
                System.out.println(book.getTitre());
                System.out.println(book.getAuteur());
            }
        }
    }
}

