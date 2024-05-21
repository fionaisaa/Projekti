package com.plc.digitalschoolproject.trainings.subjects;

import java.util.Set;

public interface SubjectService {

    SubjectDto addSubjectToTraining(Long trainingId, SubjectDto subject);
    Set<SubjectDto> getSubjectByTrainingId(Long trainingId);
    SubjectDto update(Long subjectId, SubjectDto subject);
    void delete(Long subjectId);
}
