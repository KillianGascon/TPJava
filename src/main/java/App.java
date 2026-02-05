import fr.epsi.b32526.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class App {

    public static void main(String[] args) {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

//            Réaliser un « find » simple permettant d’extraire un livre en fonction de son identifiant et affichez son
//            titre et son auteur

            Book Getbook = em.find(Book.class, 1);

            if (Getbook != null) {
                System.out.println(Getbook.getTitre());
                System.out.println(Getbook.getAuteur());
            }

            // Insérer un nouveau Livre de votre choix en base de données

//            em.getTransaction().begin();
//
//            Book book = new Book("Divergente", "Veronica Roth");
//            em.persist(book);
//
//            em.getTransaction().commit();
//
//            System.out.println(book.getId());

//            Modifier le titre du livre dont l’identifiant est 5 qui possède une erreur :
//            le nouveau titre doit être « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».

            em.getTransaction().begin();

            Book bookAModifier = em.find(Book.class, 5);
            if (bookAModifier != null) {
                bookAModifier.setTitre("Du plaisir dans la cuisine");
            }

            em.getTransaction().commit();


//            Faire une requête JPQL pour extraire de la base un livre en fonction de son titre

            TypedQuery<Book> query = em.createQuery(
                    "SELECT b FROM Book b WHERE b.titre = :titre",
                    Book.class
            );

            query.setParameter("titre", "Divergente");

            Book bookByTitle = query.getSingleResult();

            System.out.println(bookByTitle.getTitre());
            System.out.println(bookByTitle.getAuteur());

//            Faire une requête JPQL pour extraire de la base un livre en fonction de son auteur

            TypedQuery<Book> query2 = em.createQuery(
                    "SELECT b FROM Book b WHERE b.auteur = :auteur",
                    Book.class
            );

            query2.setParameter("auteur", "Veronica Roth");

            Book bookByAutor = query2.getSingleResult();

            System.out.println(bookByAutor.getTitre());
            System.out.println(bookByAutor.getAuteur());
        }
    }
}

