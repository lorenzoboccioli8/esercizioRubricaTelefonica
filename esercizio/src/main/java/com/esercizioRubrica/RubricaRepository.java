package com.esercizioRubrica;

import org.springframework.data.jpa.repository.JpaRepository;

//interfaccia che mi permette di fare le operazioni di CRUD al database
public interface RubricaRepository extends JpaRepository<ContattoRubrica, Integer> {

}
