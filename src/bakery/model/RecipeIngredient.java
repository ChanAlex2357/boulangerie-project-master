package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;
import mg.jca.gfja.utils.GenUtils;

@Entity
public class RecipeIngredient extends ClassMap {

    @Id(procedure = "GET_RECIPE_INGREDIENT_SEQ", seq = "RCI")
    String id;
    double quantity;
    @Attribute(name = "recipe_id")
    String recipeId;
    @Attribute(name = "ingredient_id")
    String ingredientId;

    Ingredient ingredient;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public RecipeIngredient() {}

    public RecipeIngredient(String quantity, String recipeId, String ingredientId) {
        setQuantity(quantity);
        setRecipeId(recipeId);
        setIngredientId(ingredientId);
    }

    public void setQuantity(String value) {
        double doubleValue = Double.valueOf(value);
        setQuantity(doubleValue);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public Ingredient getIngredient(Connection conn)throws Exception {
        if (this.ingredient == null) {
            Ingredient ref = new Ingredient();
            ref.setId(this.getIngredientId());
            Ingredient[] ingredients= new GenUtils().searchEntities(ref,"", conn);
            if (ingredients.length > 0) {
                setIngredient( ingredients[0]);
            }
        }
        return ingredient;
    }
    
}
