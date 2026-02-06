package banque;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="compte")
public class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="numero")
    private String numero;
    @Column(name="solde")
    private Double solde;

    public Compte() {
    }

    public Compte(Double solde) {
        this.solde = solde;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }
}
