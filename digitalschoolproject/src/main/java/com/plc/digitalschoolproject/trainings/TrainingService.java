package com.plc.digitalschoolproject.trainings;

import java.util.List;

public interface TrainingService {

    TrainingEntity findById(Long id);

    List<TrainingEntity> findAll();

    TrainingEntity save(TrainingEntity trainingEntity);
    
}
