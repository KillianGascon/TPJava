import banque.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

public class Banque {

    static void main() {
        try (EntityManagerFactory emf =
                     Persistence.createEntityManagerFactory("banque");
             EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();

            Adresse adresse = new Adresse(15, "rue de la paix", 75000, "Paris");
            em.persist(adresse);

            Client client = new Client("Killian", "Gascon",  LocalDate.of(2005, 12, 17));
            em.persist(client);

            BanqueClass banque = new BanqueClass("Crédit Agricole");
            em.persist(banque);

            Compte compte = new Compte(19200.0);
            em.persist(compte);

            Operation operation = new Operation(LocalDate.of(2022, 12, 17), 150.0, "Retrait");
            em.persist(operation);

            em.getTransaction().commit();

        }
    }

}
