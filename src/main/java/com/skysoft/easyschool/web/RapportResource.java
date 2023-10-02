package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Rapport;
import com.skysoft.easyschool.dto.RapportDTO;
import com.skysoft.easyschool.service.RapportService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RapportResource {

    private final RapportService rapportService;

    public RapportResource(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    @GetMapping("/rapport/all")
    public ResponseEntity<List<Rapport>> getAllRapport(){
        List<Rapport> Rapport =rapportService.getAllRapport();
        return new ResponseEntity<>(Rapport, HttpStatus.OK);
    }
    @GetMapping("/rapport/find/{id}")
    public ResponseEntity<List<Rapport>> getStagiaire(@PathVariable("id") Long id){
        Rapport rapport=rapportService.getRapport(id);
        return new ResponseEntity(rapport,HttpStatus.OK);
    }
    @GetMapping("/rapport/recherche")
    public ResponseEntity<List<Rapport>> getStagiaire(@RequestParam(name = "titre_rapport", required = false) String titre_rapport, @RequestParam(name="date_envoi", required = false) String date_envoi) throws NotFoundException {
        List<Rapport> stagiaire=rapportService.getRapport(titre_rapport, date_envoi);
        return new ResponseEntity(stagiaire,HttpStatus.OK);
    }
    @PostMapping("/rapport/add")
    public ResponseEntity<Rapport> saveRapport(@RequestBody RapportDTO rapportDTO) throws NotFoundException {
        Rapport newstagiaire = rapportService.saveRapport(rapportDTO);
        return new ResponseEntity<>(newstagiaire, HttpStatus.CREATED);
    }
    @PutMapping("/rapport/update")
    public ResponseEntity<Rapport> updateRapport(@RequestBody RapportDTO rapportDTO) throws NotFoundException {
        Rapport updateRapport = rapportService.updateRapport(rapportDTO);
        return new ResponseEntity<>(updateRapport, HttpStatus.OK);
    }
    @DeleteMapping("/rapport/delete/{id}")
    public ResponseEntity<?> deleteRapportById(@PathVariable("id") Long id){
        rapportService.deleteRapportById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
