import fr.epsi.b32526.Emprunt;
import fr.epsi.b32526.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class TestBibliotheque {

    public static void main() {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

//        Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés

            Emprunt emprunt = em.find(Emprunt.class, 1);

            if (emprunt != null) {
                Date DateDebut = emprunt.getDate_debut();
                Date DateFin = emprunt.getDate_fin();
                for (Livre livre : emprunt.getLivres()) {
                    System.out.println(livre.getTitre());
                }
                System.out.println(DateDebut);
                System.out.println(DateFin);
            }

//            Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné

            Emprunt GetClientEmprunt = em.find(Emprunt.class, 1);

            if (emprunt != null) {
                System.out.println(emprunt.getDate_debut());
                System.out.println(emprunt.getDate_fin());
                System.out.println(emprunt.getClient().getNom());
                System.out.println(emprunt.getClient().getPrenom());
            }

        }
    }
}
