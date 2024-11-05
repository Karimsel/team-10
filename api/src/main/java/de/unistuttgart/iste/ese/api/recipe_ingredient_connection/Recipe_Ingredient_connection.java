package de.unistuttgart.iste.ese.api.recipe_ingredient_connection;

import de.unistuttgart.iste.ese.api.recipes.Recipe;
import de.unistuttgart.iste.ese.api.ingredients.Ingredients;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipe_ingredient")
public class Recipe_Ingredient_connection {

    @EmbeddedId
    Connection_key id;
    
    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    Ingredients ingredient;

    int quantity;

    public Recipe_Ingredient_connection(){}

    public Recipe_Ingredient_connection(Recipe recipe, Ingredients ingredient, int quantity){
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Recipe getRecipe(){
        return recipe;
    }

    public void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }

    public Ingredients getIngredient(){
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient){
        this.ingredient = ingredient;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
