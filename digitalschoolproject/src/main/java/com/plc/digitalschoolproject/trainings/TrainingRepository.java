package com.plc.digitalschoolproject.trainings;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
    
}
