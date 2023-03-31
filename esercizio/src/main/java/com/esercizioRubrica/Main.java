package com.esercizioRubrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    public void aggiungiContatto(@RequestBody RichiestaContatto richiestaContatto) {
        ContattoRubrica contattoRubrica = new ContattoRubrica();
        contattoRubrica.setNumero(richiestaContatto.getNumero());
        contattoRubrica.setNome(richiestaContatto.getNome());
        contattoRubrica.setCognome(richiestaContatto.getCognome());
        contattoRubrica.setEmail(richiestaContatto.getEmail());
        contattoRubrica.setSocieta(richiestaContatto.getSocieta());
        rubricaRepository.save(contattoRubrica);
    }

    @DeleteMapping("{contattoId}")
    public void cancellaContatto(@PathVariable("contattoId") Integer id) {
        rubricaRepository.deleteById(id);
    }

    //da implementare!!!
    @PutMapping("{contattoId}")
    public void aggiornaContatto (@RequestBody RichiestaContatto updContatto, @PathVariable("contattoId") Integer id) {
        ContattoRubrica contattoRubrica = rubricaRepository.findById(id).orElseThrow();
        contattoRubrica.setNumero(updContatto.getNumero());
        contattoRubrica.setNome(updContatto.getNome());
        contattoRubrica.setCognome(updContatto.getCognome());
        contattoRubrica.setEmail(updContatto.getEmail());
        contattoRubrica.setSocieta(updContatto.getSocieta());
        rubricaRepository.save(contattoRubrica);
    }
}
