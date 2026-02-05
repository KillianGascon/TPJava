import fr.epsi.b32526.Book;
import fr.epsi.b32526.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestBibliotheque {

    public static void main() {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

//        Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés

            Emprunt GetEmprunt = em.find(Emprunt.class, 1);

            if (GetEmprunt != null) {
                System.out.println(GetEmprunt.getDate_debut());
                System.out.println(GetEmprunt.getDate_fin());
                System.out.println(GetEmprunt.getClient());
            }

//            Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné

        }
    }
}
