package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Etablissement;
import com.skysoft.easyschool.dto.EtablissementDTO;
import com.skysoft.easyschool.service.EtablissementService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EtablissementResource {

    private final EtablissementService etablissementService;


    public EtablissementResource(EtablissementService etablissementService) {
        this.etablissementService = etablissementService;
    }
    @GetMapping("/etablissement/all")
    public ResponseEntity<List<Etablissement>> getAllEtablissement(){
        List<Etablissement> Etablissement=etablissementService.getAllEtablissement();
        return new ResponseEntity<>(Etablissement, HttpStatus.OK);
    }
    @GetMapping("/etablissement/find/{id}")
    public ResponseEntity<List<Etablissement>>getAllEtablissement(@PathVariable("id") Long id){
        Etablissement etablissement=etablissementService.getEtablissement(id);
        return new ResponseEntity(etablissement, HttpStatus.OK);
    }

    @GetMapping("/etablissement/recherche")
    public ResponseEntity<List<Etablissement>> getEtablissement(@RequestParam(name = "nom", required = false) String nom) throws NotFoundException {
        List<Etablissement> etablissement=etablissementService.getEtablissement(nom);
        return new ResponseEntity(etablissement,HttpStatus.OK);
    }
    @PostMapping("/etablissement/add")
    public ResponseEntity<Etablissement> saveEtablissement(@RequestBody EtablissementDTO etablissementDTO){
        Etablissement newetablissement = etablissementService.saveEtablissement(etablissementDTO);
        return new ResponseEntity<>(newetablissement, HttpStatus.CREATED);
    }
    @PutMapping("/etablissement/update")
    public ResponseEntity<Etablissement> updateEtablissement(@RequestBody EtablissementDTO etablissementDTO){
        Etablissement updateEtablissement= etablissementService.updateEtablissement(etablissementDTO);
        return new ResponseEntity<>(updateEtablissement, HttpStatus.OK);
    }
    @DeleteMapping("/etablissement/delete/{id}")
    public ResponseEntity<?> deleteEtablissementById(@PathVariable("id") Long id){
        etablissementService.deleteEtablissementById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
