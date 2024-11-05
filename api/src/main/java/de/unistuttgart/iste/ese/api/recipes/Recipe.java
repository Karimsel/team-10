package de.unistuttgart.iste.ese.api.recipes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String title;

    @Positive
    private int timeRequirement;

    private String preperation;
    private String picUrl;

    public Recipe(){}

    public Recipe(String title, int timeRequirement, String preperation, String picUrl){
        this.title = title;
        this.timeRequirement = timeRequirement;
        this.preperation = preperation;
        this.picUrl = picUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setTimeRequirement(int timeRequirement){
        this.timeRequirement = timeRequirement;
    }

    public String getTitle(){
        return title;
    }

    public int getTimeRequirement(){
        return timeRequirement;
    }

    public String getPreperation(){
        return preperation;
    }

    public void setPreperation(String preperation){
        this.preperation = preperation;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
