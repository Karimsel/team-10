package de.unistuttgart.iste.ese.api.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import de.unistuttgart.iste.ese.api.ApiVersion1;
import jakarta.annotation.PostConstruct;

@RestController
@ApiVersion1
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {

        // check if DB is empty
        long entries = recipeRepository.count();
        if (entries == 0) {
            // adding sample data for demonstration purposes
            Recipe friedEgg = new Recipe("Fried Eggs and Toast", 10, 
            "Prepare Pan by preheating and adding oil. Crack eggs and put them into the pan. Meanwhile toast bread. When happy with the egg, turn off heat and serve. Add some salt to the finished eggs.", 
            "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Fried_Egg_2.jpg/1280px-Fried_Egg_2.jpg");
            recipeRepository.save(friedEgg);
        }
    }
    
}
