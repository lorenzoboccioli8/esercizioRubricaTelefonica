package com.esercizioRubrica;

import jakarta.annotation.Nonnull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/contatti")
public class Main {

    private final RubricaRepository rubricaRepository;

    public Main(RubricaRepository rubricaRepository) {
        this.rubricaRepository = rubricaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public List<ContattoRubrica> getContatti() {
        return rubricaRepository.findAll();
    }

    @PostMapping
    public void aggiungiContatto(@RequestBody RichiestaContatto aggiungiContatto) {
        ContattoRubrica contattoRubrica = new ContattoRubrica();
        contattoRubrica.setNumero(aggiungiContatto.getNumero());
        contattoRubrica.setNome(aggiungiContatto.getNome());
        contattoRubrica.setCognome(aggiungiContatto.getCognome());
        contattoRubrica.setEmail(aggiungiContatto.getEmail());
        contattoRubrica.setSocieta(aggiungiContatto.getSocieta());
        rubricaRepository.save(contattoRubrica);
    }

    @DeleteMapping("{contattoId}")
    public void cancellaContatto(@PathVariable("contattoId") Integer id) {
        rubricaRepository.deleteById(id);
    }

    @PutMapping("{contattoId}")
    public void aggiornaContatto (@RequestBody RichiestaContatto aggiornaContatto, @PathVariable("contattoId") Integer id) {
        ContattoRubrica contattoRubrica = rubricaRepository.findById(id).orElseThrow();
        //Inserisco i controlli per far sì che si possa fare l'update anche solo di alcuni attributi
        if (aggiornaContatto.getNumero() != null) {
            contattoRubrica.setNumero(aggiornaContatto.getNumero());
        }
        if (aggiornaContatto.getNome() != null) {
            contattoRubrica.setNome(aggiornaContatto.getNome());
        }
        if (aggiornaContatto.getCognome() != null) {
            contattoRubrica.setCognome(aggiornaContatto.getCognome());
        }
        if (aggiornaContatto.getEmail() != null) {
            contattoRubrica.setEmail(aggiornaContatto.getEmail());
        }
        if (aggiornaContatto.getSocieta() != null) {
            contattoRubrica.setSocieta(aggiornaContatto.getSocieta());
        }
        rubricaRepository.save(contattoRubrica);
    }
}
