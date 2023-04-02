package com.esercizioRubrica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class ContattoRubrica {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String numero;
    @NotNull
    private String nome;
    //@NotNull
    private String cognome;
    //@NotNull
    private String societa;
    //@NotNull
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSocieta() {
        return societa;
    }

    public void setSocieta(String societa) {
        this.societa = societa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContattoRubrica(Integer id, String numero, String nome, String cognome, String societa, String email) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.cognome = cognome;
        this.societa = societa;
        this.email = email;
    }

    public ContattoRubrica() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContattoRubrica that = (ContattoRubrica) o;
        return Objects.equals(id, that.id) && Objects.equals(numero, that.numero) && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(societa, that.societa) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, nome, cognome, societa, email);
    }

    @Override
    public String toString() {
        return "ContattoRubrica{" +
                "id=" + id +
                ", numero=" + numero +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", societa='" + societa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
