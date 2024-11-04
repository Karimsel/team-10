package de.unistuttgart.iste.ese.api.recipes;

import de.unistuttgart.iste.ese.api.ApiVersion1;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@ApiVersion1
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {

        // check if DB is empty
        long numberOfCats = recipeRepository.count();
        if (numberOfCats == 0) {
            // adding sample data for demonstration purposes
           // Recipe octocat = new Recipe("Octocat", 42, "https://avatars1.githubusercontent.com/u/583231");
           // recipeRepository.save(octocat);

            
        }
    }

    // get all recipes
    @GetMapping("/recipes")
    public List<Recipe> getRecipes() {
        List<Recipe> allRecipes = (List<Recipe>) recipeRepository.findAll();
        return allRecipes;
    }

    // get a single recipe
    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable("id") long id) {

        Recipe searchedRecipe = recipeRepository.findById(id);
        if (searchedRecipe != null) {
            return searchedRecipe;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Recipe with ID %s not found!", id));
    }

    // create a recipe
    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe createRecipe(@Valid @RequestBody Recipe requestBody) {
        Recipe recipe = new Recipe(requestBody.getTitle(), requestBody.getWorkTime(),
                requestBody.getPicUrl(), requestBody.getInstructions());
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe;
    }

    // update a Recipe
    @PutMapping("/recipe/{id}")
    public Recipe updateRecipe(@PathVariable("id") long id, @Valid @RequestBody Recipe requestBody) {
        requestBody.setId(id);
        Recipe recipeToUpdate = recipeRepository.findById(id);
        if (recipeToUpdate != null) {
            Recipe savedRecipe = recipeRepository.save(requestBody);
            return savedRecipe;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Recipe with ID %s not found!", id));
    }

    // delete a Recipe
    @DeleteMapping("/recipe/{id}")
    public Recipe deleteRecipe(@PathVariable("id") long id) {

        Recipe recipeToDelete = recipeRepository.findById(id);
        if (recipeToDelete != null) {
            recipeRepository.deleteById(id);
            return recipeToDelete;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Recipe with ID %s not found!", id));
    }
}
