package de.unistuttgart.iste.ese.api.recipe_ingredient_connection;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Connection_key {
    
    @Column(name = "recipe_id")
    Long recipeId;

    @Column(name = "ingredient_id")
    Long ingredientId;

    public Connection_key(){}

    public Connection_key(Long recipeId, Long ingredientId){
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public Long getRecipeId(){
        return recipeId;
    }

    public void getRecipeId(Long recipeId){
        this.recipeId = recipeId;
    }

    public Long getIngredientId(){
        return ingredientId;
    }

    public void getIngredientId(Long ingredientId){
        this.ingredientId = ingredientId;
    }
}
