import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="livre")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="titre")
        private String titre;
    @Column(name="auteur")
    private String auteur;

    public Person() {
    }
}