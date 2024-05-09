package com.plc.digitalschoolproject.trainings;

import com.plc.digitalschoolproject.commons.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainings")
public class TrainingEntity extends BaseEntity {

 
    private String title;
    private String description;
    private String cover;



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

    



}
