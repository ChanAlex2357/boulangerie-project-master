package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class RecipeTypes extends ClassMap {

    @Id(procedure = "GET_RECIPETYPES_SEQ", seq = "RECIPETYPES")
    String id;
    @Attribute(name = "recipe_id")
    String recipeId;
    @Attribute(name = "type_id")
    String typeId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    // Getters and Setters
    // ...existing code...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
