package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Encadreur;
import com.skysoft.easyschool.dto.EncadreurDTO;
import com.skysoft.easyschool.service.EncadreurService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api")
public class EncadreurResource {

    private final EncadreurService encadreurService;

    public EncadreurResource(EncadreurService encadreurService) {
        this.encadreurService = encadreurService;
    }
    @GetMapping("/encadreur/all")
    public ResponseEntity<List<Encadreur>>getAllEncadreur(){
        List<Encadreur> Encadreur=encadreurService.getAllEncadreur();
        return new ResponseEntity<>(Encadreur, HttpStatus.OK);
    }
    @GetMapping("/encadreur/find/{id}")
    public ResponseEntity<List<Encadreur>>getAllEncadreur(@PathVariable("id") Long id){
        Encadreur encadreur=encadreurService.getEncadreur(id);
        return new ResponseEntity(encadreur, HttpStatus.OK);
    }
    @GetMapping("/encadreur/recherche")
    public ResponseEntity<List<Encadreur>> getEncadreur(@RequestParam(name = "nom", required = false) String nom, @RequestParam(name="prenom", required = false) String prenom_encadreur) throws NotFoundException {
        List<Encadreur> encadreur=encadreurService.getEncadreur(nom, prenom_encadreur);
        return new ResponseEntity(encadreur,HttpStatus.OK);
    }
    @PostMapping("/encadreur/add")
    public ResponseEntity<Encadreur> saveEncadreur(@RequestBody EncadreurDTO encadreurDTO){
        Encadreur newencadreur = encadreurService.saveEncadreur(encadreurDTO);
        return new ResponseEntity<>(newencadreur, HttpStatus.CREATED);
    }
    @PutMapping("/encadreur/update")
    public ResponseEntity<Encadreur> updateStagiaire(@RequestBody EncadreurDTO encadreurDTO){
        Encadreur updateEncadreur= encadreurService.updateEncadreur(encadreurDTO);
        return new ResponseEntity<>(updateEncadreur, HttpStatus.OK);
    }
    @DeleteMapping("/encadreur/delete/{id}")
    public ResponseEntity<?> deleteStagiaireById(@PathVariable("id") Long id){
        encadreurService.deleteEncadreurById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
