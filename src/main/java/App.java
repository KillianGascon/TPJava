import fr.epsi.b32526.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App {

    public static void main(String[] args) {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

//            Réaliser un « find » simple permettant d’extraire un livre en fonction de son identifiant et affichez son
//            titre et son auteur

            Livre Getbook = em.find(Livre.class, 1);

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

            Livre bookAModifier = em.find(Livre.class, 5);
            if (bookAModifier != null) {
                bookAModifier.setTitre("Du plaisir dans la cuisine");
            }

            em.getTransaction().commit();


//            Faire une requête JPQL pour extraire de la base un livre en fonction de son titre

            TypedQuery<Livre> query = em.createQuery(
                    "SELECT b FROM Livre b WHERE b.titre = :titre",
                    Livre.class
            );

            query.setParameter("titre", "Divergente");

            Livre bookByTitle = query.getSingleResult();

            System.out.println(bookByTitle.getTitre());
            System.out.println(bookByTitle.getAuteur());

//            Faire une requête JPQL pour extraire de la base un livre en fonction de son auteur

            TypedQuery<Livre> query2 = em.createQuery(
                    "SELECT b FROM Livre b WHERE b.auteur = :auteur",
                    Livre.class
            );

            query2.setParameter("auteur", "Veronica Roth");

            Livre bookByAutor = query2.getSingleResult();

            System.out.println(bookByAutor.getTitre());
            System.out.println(bookByAutor.getAuteur());

//            Supprimer un livre de votre choix en base de données

            em.getTransaction().begin();

            Livre bookASupprimer = em.find(Livre.class, 1);
            if (bookASupprimer != null) {
                em.remove(bookASupprimer);
            }

            em.getTransaction().commit();

//            Afficher la liste de tous les livres présents en base de données (titre et auteur).

            List<Livre> books = em.createQuery("SELECT b FROM Livre b", Livre.class).getResultList();
            System.out.println("__________________________");
            if (books != null) {
                for (Livre book : books) {
                    System.out.println(book.getId());
                    System.out.println(book.getTitre());
                    System.out.println(book.getAuteur());
                    System.out.println("__________________________");
                }
            }

        }
    }
}

