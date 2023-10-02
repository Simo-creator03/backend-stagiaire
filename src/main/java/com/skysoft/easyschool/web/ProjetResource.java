package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Projet;
import com.skysoft.easyschool.dto.ProjetDTO;
import com.skysoft.easyschool.service.ProjetService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjetResource {

    private final ProjetService projetService;

    public ProjetResource(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping("/projet/all")
    public ResponseEntity<List<Projet>> getAllProjet(){
        List<Projet> Projet=projetService.getAllProjet();
        return new ResponseEntity<>(Projet, HttpStatus.OK);
    }

    @GetMapping("/projet/find/{id}")
    public ResponseEntity<List<Projet>> getStagiaire(@PathVariable("id") Long id){
        Projet projet=projetService.getProjet(id);
        return new ResponseEntity(projet,HttpStatus.OK);
    }

    @GetMapping("/projet/recherche")
    public ResponseEntity<List<Projet>> getProjet(@RequestParam(name = "nom_projet", required = false) String nom_projet, @RequestParam(name="date_creation", required = false) String date_creation) throws NotFoundException {
        List<Projet> projet=projetService.getProjet(nom_projet, date_creation);
        return new ResponseEntity(projet,HttpStatus.OK);
    }

    @PostMapping("/projet/add")
    public ResponseEntity<Projet> saveProjet(@RequestBody ProjetDTO projetDTO) throws NotFoundException {
        Projet newprojet = projetService.saveProjet(projetDTO);
        return new ResponseEntity<>(newprojet, HttpStatus.CREATED);
    }

    @PutMapping("/projet/update")
    public ResponseEntity<Projet> updateProjet(@RequestBody ProjetDTO projetDTO) throws NotFoundException {
        Projet updateProjet = projetService.updateProjet(projetDTO);
        return new ResponseEntity<>(updateProjet, HttpStatus.OK);
    }

    @DeleteMapping("/projet/delete/{id}")
    public ResponseEntity<?> deleteProjetById(@PathVariable("id") Long id){
        projetService.deleteProjetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
