/*
package com.skysoft.easyschool.web;

import com.skysoft.easyschool.domain.Stage;
import com.skysoft.easyschool.dto.StageDTO;
import com.skysoft.easyschool.service.StageService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StageResource {


    private final StageService stageService;

    public StageResource(StageService stageService) {
        this.stageService = stageService;
    }

    @GetMapping("/stage/all")
    public ResponseEntity<List<Stage>> getAllEtablissement(){
        List<Stage> Etablissement=stageService.getAllStage();
        return new ResponseEntity<>(Etablissement, HttpStatus.OK);
    }
    @GetMapping("/stage/find/{id}")
    public ResponseEntity<List<Stage>> getAllStage(@PathVariable("id") Long id){
        Stage stage=stageService.getStage(id);
        return new ResponseEntity(stage, HttpStatus.OK);
    }
    @PostMapping("/stage/add")
    public ResponseEntity<Stage> saveStage(@RequestBody StageDTO stageDTO) throws NotFoundException {
        Stage newstage = stageService.saveStage(stageDTO);
        return new ResponseEntity<>(newstage, HttpStatus.CREATED);
    }
    @PutMapping("/stage/update")
    public ResponseEntity<Stage> updateStage(@RequestBody StageDTO stageDTO) throws NotFoundException {
        Stage updateStage= stageService.updateStage(stageDTO);
        return new ResponseEntity<>(updateStage, HttpStatus.OK);
    }
    @DeleteMapping("/stage/delete/{id_stage}")
    public ResponseEntity<?> deleteStageById(@PathVariable("id_stage") Long id_stage){
        stageService.deleteStageById(id_stage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
*/
