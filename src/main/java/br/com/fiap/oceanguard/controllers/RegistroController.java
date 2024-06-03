package br.com.fiap.oceanguard.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.oceanguard.model.Registro;
import br.com.fiap.oceanguard.repository.RegistroRepository;
import jakarta.validation.Valid;

@RestController
public class RegistroController {

    Logger log = LoggerFactory.getLogger(getClass());

    List <Registro> registro = new ArrayList<>();

    @Autowired
    RegistroRepository repository;

    @GetMapping("/registro")
    public List<Registro> index(){
        return repository.findAll();
    }

    @PostMapping("/registro")
    public ResponseEntity<Object> create(@RequestBody @Valid Registro registro) {
        log.info("Cadastrando registro - " + registro);
        repository.save(registro);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @GetMapping("/registro/{id}")
    public ResponseEntity<Registro> show(@PathVariable Long id){
        log.info("mostrar registro com id " + id);
        return ResponseEntity.ok(getRegistroById(id));
    }

    @DeleteMapping("/registro/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){
        log.info("Apagando registro com id " + id);
        repository.delete(getRegistroById(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/registro/{id}")
    public ResponseEntity<Registro> update(@PathVariable Long id, @RequestBody Registro registro){
        log.info("Atualizando dados do registro com id " + id);
        getRegistroById(id);
        registro.setId(id);
        repository.save(registro);

        return ResponseEntity.ok(registro);
    }

    private Registro getRegistroById(Long id){
        return repository.findById(id).orElseThrow(() -> { 
                return new RuntimeException();
            });
        }
    
}
