package fr.epsi.b32526;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;


@Table(name="compo")
public class Compo implements Serializable {

    @Column(name="id_liv")
    private Integer id_liv;
    @Column(name="id_emp")
    private String id_emp;

    public Compo(Integer id_liv, String id_emp) {
        this.id_liv = id_liv;
        this.id_emp = id_emp;
    }

    public Compo() {
    }

    public Integer getId_liv() {
        return id_liv;
    }

    public void setId_liv(Integer id_liv) {
        this.id_liv = id_liv;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }
}