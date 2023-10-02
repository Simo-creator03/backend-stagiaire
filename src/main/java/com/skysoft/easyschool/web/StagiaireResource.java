package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Stagiaire;
import com.skysoft.easyschool.dto.StagiaireDTO;
import com.skysoft.easyschool.service.StagiaireService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class StagiaireResource {

    private final StagiaireService stagiaireService;

    public StagiaireResource(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping("/stagiaire/all")
    public ResponseEntity<List<Stagiaire>> getAllstagiaire(){
        List<Stagiaire> Stagiaire =stagiaireService.getAllStagiaire();
        return new ResponseEntity<>(Stagiaire, HttpStatus.OK);
    }

    @GetMapping("/stagiaire/find/{id_stage}")
    public ResponseEntity<List<Stagiaire>> getStagiaire(@PathVariable("id_stage") Long id_stage) throws NotFoundException {
        Stagiaire stagiaire=stagiaireService.getStagiaire(id_stage);
        return new ResponseEntity(stagiaire,HttpStatus.OK);
    }

    @GetMapping("/stagiaire/recherche")
    public ResponseEntity<List<Stagiaire>> getStagiaire(@RequestParam(name = "nom", required = false) String nom, @RequestParam(name="prenom", required = false) String prenom, @RequestParam(name = "domaine", required = false) String domaine) throws NotFoundException {
        List<Stagiaire> stagiaire=stagiaireService.getStagiaire(nom, prenom,domaine);
        return new ResponseEntity(stagiaire,HttpStatus.OK);
    }
    /*@PostMapping("/stagiaire/add")
    public ResponseEntity<Stagiaire> createStagiaire(@RequestBody StagiaireDTO stagiaireDTO) throws NotFoundException {
        return ResponseEntity.ok().body(stagiaireService.createStagiaire(stagiaireDTO));
    }*/
    @PostMapping("/stagiaire/add")
    public ResponseEntity<Stagiaire> saveStagiaire(@RequestBody StagiaireDTO stagiaireDTO) throws NotFoundException {
        Stagiaire newstagiaire = stagiaireService.createStagiaire(stagiaireDTO);
        return new ResponseEntity<>(newstagiaire, HttpStatus.CREATED);
    }

    /*@PutMapping("/stagiaire/update")
    public ResponseEntity<Stagiaire> updateStagiaire(@RequestBody StagiaireDTO stagiaireDTO) throws NotFoundException {
        return ResponseEntity.ok().body(stagiaireService.updateStagiaire(stagiaireDTO));
    }*/
    @PutMapping("/stagiaire/update")
    public ResponseEntity<Stagiaire> updateStagiaire(@RequestBody StagiaireDTO stagiaireDTO) throws NotFoundException {
        Stagiaire updateStagiaire= stagiaireService.updateStagiaire(stagiaireDTO);
        return new ResponseEntity<>(updateStagiaire, HttpStatus.OK);
    }

    @DeleteMapping("/stagiaire/delete/{id}")
    public ResponseEntity<?> deleteStagiaireById(@PathVariable("id") Long id){
        stagiaireService.deleteStagiaireById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
