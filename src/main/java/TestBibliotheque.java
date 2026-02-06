import fr.epsi.b32526.Client;
import fr.epsi.b32526.Emprunt;
import fr.epsi.b32526.Livre;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Set;

public class TestBibliotheque {

    public static void main() {

        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager()) {

//        Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés

            Emprunt emprunt = em.find(Emprunt.class, 1);

            if (emprunt != null) {
                LocalDate DateDebut = emprunt.getDateDebut();
                LocalDate DateFin = emprunt.getDateFin();
                for (Livre livre : emprunt.getLivres()) {
                    System.out.println(livre.getTitre());
                }
                System.out.println(DateDebut);
                System.out.println(DateFin);
            }

//            Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné

            Emprunt GetClientEmprunt = em.find(Emprunt.class, 1);

            if (emprunt != null) {
                System.out.println(emprunt.getDateDebut());
                System.out.println(emprunt.getDateFin());
                System.out.println(emprunt.getClient().getNom());
                System.out.println(emprunt.getClient().getPrenom());
            }

            em.getTransaction().begin();

            Client ajoutClient = new Client("Dupont", "Jean");


            Livre getLivre2 = em.find(Livre.class, 2);

            if (getLivre2 != null) {

                Emprunt nouvelEmprunt = new Emprunt(
                        LocalDate.now(),
                        LocalDate.now().plusDays(14),
                        14,
                        ajoutClient,
                        Set.of(getLivre2)
                );

                ajoutClient.getEmprunts().add(nouvelEmprunt);

                em.persist(ajoutClient);
                em.getTransaction().commit();
            }



        }
    }
}
