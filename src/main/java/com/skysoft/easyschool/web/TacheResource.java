package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Tache;
import com.skysoft.easyschool.dto.TacheDTO;
import com.skysoft.easyschool.service.TacheService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TacheResource {

    private final TacheService tacheService;

    public TacheResource(TacheService tacheService) {
        this.tacheService = tacheService;
    }

    @GetMapping("/tache/all")
    public ResponseEntity<List<Tache>> getAllTache() {
        List<Tache> Tache = tacheService.getAllTache();
        return new ResponseEntity<>(Tache, HttpStatus.OK);
    }
    @GetMapping("/tache/find/{id}")
    public ResponseEntity<List<Tache>> getTache(@PathVariable("id") Long Id_tache){
        Tache tache=tacheService.getTache(Id_tache);
        return new ResponseEntity(tache,HttpStatus.OK);
    }
    @GetMapping("/tache/recherche")
    public ResponseEntity<List<Tache>> getTache(@RequestParam(name = "objectif_tache", required = false) String objectif_tache, @RequestParam(name = "statut", required = false) String statut) throws NotFoundException {
        List<Tache> tache=tacheService.getTache(objectif_tache,statut);
        return new ResponseEntity(tache,HttpStatus.OK);
    }
    @PostMapping("/tache/add")
    public ResponseEntity<Tache> saveTache(@RequestBody TacheDTO tacheDTO) throws NotFoundException {
        Tache newtache = tacheService.saveTache(tacheDTO);
        return new ResponseEntity<>(newtache, HttpStatus.CREATED);
    }
    @PutMapping("/tache/update")
    public ResponseEntity<Tache> updateTache(@RequestBody TacheDTO tacheDTO) throws NotFoundException {
        Tache updateTache = tacheService.updateTache(tacheDTO);
        return new ResponseEntity<>(updateTache, HttpStatus.OK);
    }
    @DeleteMapping("/tache/delete/{id}")
    public ResponseEntity<?> deleteTacheById(@PathVariable("id") Long id){
        tacheService.deleteTacheById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
