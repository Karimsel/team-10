package de.unistuttgart.iste.ese.api.ingredients;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredients, Long> {
    Ingredients findByName(String name);

    Ingredients findById(long id);
}
