package de.unistuttgart.iste.ese.api.ingredients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import de.unistuttgart.iste.ese.api.ApiVersion1;
import jakarta.annotation.PostConstruct;

@RestController
@ApiVersion1
public class IngredientController {
    
    @Autowired
    private IngredientRepository ingredientRepository;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {

        // check if DB is empty
        long entries = ingredientRepository.count();
        if (entries == 0) {
            // adding sample data for demonstration purposes
            Ingredients bread = new Ingredients("Wheat-Bread", "Bread", "Pieces");
            ingredientRepository.save(bread);

            Ingredients egg = new Ingredients("Egg", "Egg", "Pieces");
            ingredientRepository.save(egg);

            Ingredients salt = new Ingredients("Salt", "Seasoning", "Gramm");
            ingredientRepository.save(salt);

            Ingredients oil = new Ingredients("Sunflower Oil", "Oil", "Mililiter");
            ingredientRepository.save(oil);
        }
    }
}
