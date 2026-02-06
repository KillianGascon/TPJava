package fr.epsi.b32526;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Emprunt")
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Column(name = "delai")
    private Integer delai;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "compo",
            joinColumns = @JoinColumn(name = "id_emp"),
            inverseJoinColumns = @JoinColumn(name = "id_liv")
    )
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(LocalDate dateDebut, LocalDate dateFin, Integer delai, Client client, Set<Livre> livres) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }


    public Integer getId() {
        return id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate date_debut) {
        this.dateDebut = date_debut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate date_fin) {
        this.dateFin = date_fin;
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
        if (this.client != null) {
            this.client.getEmprunts().remove(this);
        }

        this.client = client;

        if (this.client != null) {
            this.client.getEmprunts().add(this);
        }
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }


}
