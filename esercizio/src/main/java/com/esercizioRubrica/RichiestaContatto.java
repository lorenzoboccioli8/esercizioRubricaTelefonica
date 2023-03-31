package com.esercizioRubrica;

import java.util.Objects;

public class RichiestaContatto {
    private final String nome;

    private final String numero;
    private final String cognome;
    private final String societa;
    private final String email;

    public RichiestaContatto(String nome, String numero, String cognome, String societa, String email) {
        this.nome = nome;
        this.numero = numero;
        this.cognome = cognome;
        this.societa = societa;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getCognome() {
        return cognome;
    }

    public String getSocieta() {
        return societa;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RichiestaContatto that = (RichiestaContatto) o;
        return Objects.equals(nome, that.nome) && Objects.equals(numero, that.numero) && Objects.equals(cognome, that.cognome) && Objects.equals(societa, that.societa) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero, cognome, societa, email);
    }

    @Override
    public String toString() {
        return "RichiestaContatto{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", cognome='" + cognome + '\'' +
                ", societa='" + societa + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
