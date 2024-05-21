package com.plc.digitalschoolproject.trainings;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainingServiceImpl implements TrainingService{

    private TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public TrainingEntity findById(Long id) {
       
        return trainingRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Training with id " +id+ " is not found."));
        
    }

    @Override
    public List<TrainingEntity> findAll() {
       
        return  trainingRepository.findAll();
    }

    @Override
    public TrainingEntity save(TrainingEntity trainingEntity) {
      
        return trainingRepository.save(trainingEntity);
    }

    
    
}
