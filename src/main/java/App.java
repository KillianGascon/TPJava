import fr.epsi.b32526.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
             EntityManager em = emf.createEntityManager();
        ) {
            //CRUD -> C -> Création d'une nouvelle instance

            Book person = new Person("Killian", "Gascon", 20);
            em.persist(person);

            //CRUD -> R -> Récupération d'une instance

            Person personAModifier = em.find(Person.class, 1);
            if(personAModifier != null){
                personAModifier.setName("Fiona");
            }

            //CRUD -> U -> Mise à jour d'une instance
            Person fiona = em.find(Person.class, 1);
            if(fiona != null){
                em.remove(fiona);
            }

            System.out.println(person.getId());
            em.getTransaction().commit();
        }
    }
}
