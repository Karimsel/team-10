package de.unistuttgart.iste.ese.api.recipes;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Recipe findByName(String title);

    Recipe findById(long id);
}
