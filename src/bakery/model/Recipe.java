package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;
import mg.jca.gfja.utils.GenUtils;

@Entity
public class Recipe extends ClassMap {

    @Id(procedure = "GET_RECIPE_SEQ", seq = "REC")
    String id;
    @Attribute(name = "recipe_cost")
    double recipeCost;
    String name;
    @Attribute(name = "recipe_type_id")
    String recipeTypeId;
    @Attribute(name = "product_id")
    String productId;

    Product product;

    RecipeIngredient[] recipeIngredients;

    public RecipeIngredient[] getRecipeIngredients(Connection conn) throws Exception {
        if (this.recipeIngredients == null || this.recipeIngredients.length <0) {
            RecipeIngredient ref = new RecipeIngredient();
            ref.setRecipeId(recipeTypeId);
            RecipeIngredient[] details = new GenUtils().searchEntities(ref,"", conn);
            setRecipeIngredients(details);
        }
        return this.recipeIngredients;
    }

    public void setRecipeIngredients(RecipeIngredient[] recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Recipe() {}

    public Recipe(String productId) {
        setProductId(productId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRecipeCost() {
        return recipeCost;
    }

    public void setRecipeCost(double recipeCost) {
        this.recipeCost = recipeCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setRecipeTypeId(String natureTypeId) {
        this.recipeTypeId = natureTypeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public RecipeIngredient[] saveWithIngredients(Connection conn) throws Exception {
        if (this.recipeIngredients == null || this.recipeIngredients.length < 0) {
            throw new Exception("La recette doit posseder au mois un ingredient");            
        }
        initDetailsAttributs(conn);
        this.save(conn);
        RecipeIngredient[] recipeIngredients = getRecipeIngredients(conn);
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            recipeIngredient.setRecipeId(this.getId());
            recipeIngredient.save(conn);
        }
        return recipeIngredients;
    }

    private void initDetailsAttributs(Connection conn)throws Exception{
        RecipeIngredient[] recipeIngredients = getRecipeIngredients(conn);
        double cost = 0;
        String name = "Recette de "+this.getProductId();
        for (RecipeIngredient recipeIngredient : recipeIngredients) {
            cost += recipeIngredient.getIngredient(conn).getPurchasePrice() * recipeIngredient.getQuantity();

        }
    }

    public Product getProduct(Connection conn) throws Exception {
        if (this.product == null) {
            Product ref = new Product();
            ref.setId(this.getProductId());
            this.product = Product.getById( new Product(), this.getProductId(), conn);
        }
        return product;
    }
}
