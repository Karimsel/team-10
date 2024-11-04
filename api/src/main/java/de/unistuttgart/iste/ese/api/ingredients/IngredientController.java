package de.unistuttgart.iste.ese.api.ingredients;

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
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    // executed after start-up and dependency injection
    @PostConstruct
    public void init() {

        // check if DB is empty
        long numberOfIngredients = ingredientRepository.count();
        if (numberOfIngredients == 0) {
            // adding sample data for demonstration purposes
           // Recipe octocat = new Recipe("Octocat", 42, "https://avatars1.githubusercontent.com/u/583231");
           // recipeRepository.save(octocat);

            
        }
    }

    // get all Ingredient
    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients() {
        List<Ingredient> allIngredients = (List<Ingredient>) ingredientRepository.findAll();
        return allIngredients;
    }

    // get a single Ingredient
    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredient(@PathVariable("id") long id) {

        Ingredient searchedIngredient = ingredientRepository.findById(id);
        if (searchedIngredient != null) {
            return searchedIngredient;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Ingredient with ID %s not found!", id));
    }

    // create an Ingredient
    @PostMapping("/ingredients")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@Valid @RequestBody Ingredient requestBody) {
        Ingredient ingredient = new Ingredient(requestBody.getName(), requestBody.getQuantity());
                Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return savedIngredient;
    }

    // update a Ingredient
    @PutMapping("/ingredient/{id}")
    public Ingredient updateRecipe(@PathVariable("id") long id, @Valid @RequestBody Ingredient requestBody) {
        requestBody.setId(id);
        Ingredient ingredientToUpdate = ingredientRepository.findById(id);
        if (ingredientToUpdate != null) {
            Ingredient savedIngredient = ingredientRepository.save(requestBody);
            return savedIngredient;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Ingredient with ID %s not found!", id));
    }

    // delete a Ingredient
    @DeleteMapping("/ingredient/{id}")
    public Ingredient deleteIngredient(@PathVariable("id") long id) {

        Ingredient ingredientToDelete = ingredientRepository.findById(id);
        if (ingredientToDelete != null) {
            ingredientRepository.deleteById(id);
            return ingredientToDelete;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Ingredient with ID %s not found!", id));
    }
}
