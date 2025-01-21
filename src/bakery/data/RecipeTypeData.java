package bakery.data;

import java.sql.Connection;

import bakery.model.RecipeType;

public class RecipeTypeData implements DataGen {
    @Override
    public void generate(Connection conn) throws Exception {
        RecipeType[] recipeTypes = new RecipeType().getAll(conn);
        if (recipeTypes.length > 0) {
            for (RecipeType natureType : recipeTypes) {
                System.out.println(natureType);
            }
            System.out.println("NatureType Already Exists ... ");
            return;
        }
        recipeTypes = new RecipeType[2];
        recipeTypes[0] = new RecipeType("Nature", "Type de recette nature");
        recipeTypes[1] = new RecipeType("Non Nature","Type de recette non nature");
        for (RecipeType recipeType : recipeTypes) {
            recipeType.save(conn);
        }
    }
}
