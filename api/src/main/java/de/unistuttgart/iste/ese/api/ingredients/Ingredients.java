package de.unistuttgart.iste.ese.api.ingredients;

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
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    private String category;

    @NotNull
    private String unitOfMeasurement;

    public Ingredients(){}

    public Ingredients(String name, String category, String unit){
        this.name = name;
        this.category = category;
        this.unitOfMeasurement = unit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void unitOfMeasurement(String unit){
        this.unitOfMeasurement = unit;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getUnitOfMeasurement(){
        return unitOfMeasurement;
    }
}
