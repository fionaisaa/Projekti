package com.plc.digitalschoolproject.trainings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plc.digitalschoolproject.commons.BaseEntity;
import com.plc.digitalschoolproject.trainings.subjects.SubjectEntity;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainings")
public class TrainingEntity extends BaseEntity {

 
    private String title;
    private String description;
    private String cover;
    private Double price;

    @OneToMany(mappedBy = "training" , cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("training")
    private Set<SubjectEntity> subjects = new HashSet<>();



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
    
    

    



}
