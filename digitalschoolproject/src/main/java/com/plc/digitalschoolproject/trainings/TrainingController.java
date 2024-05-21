package com.plc.digitalschoolproject.trainings;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(path = "/trainings/{id}" )
    public TrainingEntity findById(@PathVariable(name = "id") Long id){

        return trainingService.findById(id);
    }
    
    @GetMapping(path = "/trainings")
    public List<TrainingEntity> findAll(){

        return trainingService.findAll();
    }

    @PostMapping(path = "/trainings")
    public TrainingEntity save(@RequestBody TrainingEntity trainingEntity){

        return trainingService.save(trainingEntity);
    }



}
