package fr.epsi.b32526;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="emprunt")
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="date_debut")
    private String date_debut;
    @Column(name="date_fin")
    private String date_fin;
    @Column(name="delai")
    private Integer delai;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToMany
    @JoinTable(
            name = "compo",
            joinColumns = @JoinColumn(name = "id_emprunt"),
            inverseJoinColumns = @JoinColumn(name = "id_livre")
    )
    private Set<Book> livres = new HashSet<>();


    public Emprunt() {
    }

    public Emprunt(String date_debut, String date_fin, Integer delai, Client client, Set<Book> livres) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }


    public Integer getId() {
        return id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Book> getLivres() {
        return livres;
    }

    public void setLivres(Set<Book> livres) {
        this.livres = livres;
    }
}
