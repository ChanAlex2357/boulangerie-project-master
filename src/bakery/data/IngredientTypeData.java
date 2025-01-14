package bakery.data;

import java.sql.Connection;

import bakery.model.IngredientType;
import bakery.model.Ingredient;
import bakery.model.NatureType;
import bakery.model.Unit;

public class IngredientTypeData {
    public void generate(Connection conn) throws Exception {
        IngredientType[] ingredientTypes = new IngredientType().getAll(conn);
        if (ingredientTypes.length > 0) {
            for (IngredientType ingredientType : ingredientTypes) {
                System.out.println(ingredientType);
            }
            System.out.println("IngredientType Already Exists ... ");
            return;
        }

        // Fetch nature types and units
        NatureType[] natureTypes = new NatureType().getAll(conn);
        Unit[] units = new Unit().getAll(conn);

        // Assuming natureTypes and units are not empty and have the required data
        NatureType base = natureTypes[0]; // Default nature type
        NatureType nonBase = natureTypes[1]; // Default nature type
        Unit unit = units[0]; // Default unit

        // Farines et céréales
        IngredientType farinesCereales = new IngredientType("Farines et céréales", "Type d'ingrédient : Farines et céréales");
        farinesCereales.save(conn);

        new Ingredient("Farine de blé", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);
        new Ingredient("Farine de seigle", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);
        new Ingredient("Farine d'épeautre", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);
        new Ingredient("Farine de maïs", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);
        new Ingredient("Avoine", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);
        new Ingredient("Son de blé", "Ingrédient de base", "1500", unit.getId(), farinesCereales.getId(), base.getId()).save(conn);

        // Sucres et édulcorants
        IngredientType sucresEdulcorants = new IngredientType("Sucres et édulcorants", "Type d'ingrédient : Sucres et édulcorants");
        sucresEdulcorants.save(conn);

        new Ingredient("Sucre blanc", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Sucre brun", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Sucre glace", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Miel", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Sirop d'érable", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Sirop d'agave", "Ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), base.getId()).save(conn);
        new Ingredient("Édulcorants artificiels", "Non ingrédient de base", "1500", unit.getId(), sucresEdulcorants.getId(), nonBase.getId()).save(conn);

        // Produits laitiers
        IngredientType produitsLaitiers = new IngredientType("Produits laitiers", "Type d'ingrédient : Produits laitiers");
        produitsLaitiers.save(conn);

        new Ingredient("Lait", "Ingrédient de base", "1500", unit.getId(), produitsLaitiers.getId(), base.getId()).save(conn);
        new Ingredient("Beurre", "Ingrédient de base", "1500", unit.getId(), produitsLaitiers.getId(), base.getId()).save(conn);
        new Ingredient("Crème fraîche", "Ingrédient de base", "1500", unit.getId(), produitsLaitiers.getId(), base.getId()).save(conn);
        new Ingredient("Fromage", "Ingrédient de base", "1500", unit.getId(), produitsLaitiers.getId(), base.getId()).save(conn);
        new Ingredient("Yaourt", "Ingrédient de base", "1500", unit.getId(), produitsLaitiers.getId(), base.getId()).save(conn);

        // Levures et agents levants
        IngredientType levuresAgentsLevants = new IngredientType("Levures et agents levants", "Type d'ingrédient : Levures et agents levants");
        levuresAgentsLevants.save(conn);

        new Ingredient("Levure de boulanger", "Ingrédient de base", "1500", unit.getId(), levuresAgentsLevants.getId(), base.getId()).save(conn);
        new Ingredient("Levure chimique", "Ingrédient de base", "1500", unit.getId(), levuresAgentsLevants.getId(), base.getId()).save(conn);
        new Ingredient("Bicarbonate de soude", "Ingrédient de base", "1500", unit.getId(), levuresAgentsLevants.getId(), base.getId()).save(conn);
        new Ingredient("Poudre à lever", "Ingrédient de base", "1500", unit.getId(), levuresAgentsLevants.getId(), base.getId()).save(conn);

        // Œufs
        IngredientType oeufs = new IngredientType("Œufs", "Type d'ingrédient : Œufs");
        oeufs.save(conn);

        new Ingredient("Œufs entiers", "Ingrédient de base", "1500", unit.getId(), oeufs.getId(), base.getId()).save(conn);
        new Ingredient("Blancs d'œufs", "Ingrédient de base", "1500", unit.getId(), oeufs.getId(), base.getId()).save(conn);
        new Ingredient("Jaunes d'œufs", "Ingrédient de base", "1500", unit.getId(), oeufs.getId(), base.getId()).save(conn);

        // Fruits et légumes
        IngredientType fruitsLegumes = new IngredientType("Fruits et légumes", "Type d'ingrédient : Fruits et légumes");
        fruitsLegumes.save(conn);

        new Ingredient("Pommes", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Bananes", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Carottes", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Citron", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Oranges", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Fruits rouges (fraises, framboises, myrtilles)", "Non ingrédient de base", "1500", unit.getId(), fruitsLegumes.getId(), nonBase.getId()).save(conn);

        // Noix et graines
        IngredientType noixGraines = new IngredientType("Noix et graines", "Type d'ingrédient : Noix et graines");
        noixGraines.save(conn);

        new Ingredient("Amandes", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);
        new Ingredient("Noix de pécan", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);
        new Ingredient("Noix de cajou", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);
        new Ingredient("Noisettes", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);
        new Ingredient("Graines de sésame", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);
        new Ingredient("Graines de tournesol", "Non ingrédient de base", "1500", unit.getId(), noixGraines.getId(), nonBase.getId()).save(conn);

        // Épices et arômes
        IngredientType epicesAromes = new IngredientType("Épices et arômes", "Type d'ingrédient : Épices et arômes");
        epicesAromes.save(conn);

        new Ingredient("Cannelle", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Vanille", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Muscade", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Gingembre", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Cardamome", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Zeste de citron", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);
        new Ingredient("Arômes artificiels", "Non ingrédient de base", "1500", unit.getId(), epicesAromes.getId(), nonBase.getId()).save(conn);

        // Liquides
        IngredientType liquides = new IngredientType("Liquides", "Type d'ingrédient : Liquides");
        liquides.save(conn);

        new Ingredient("Eau", "Ingrédient de base", "1500", unit.getId(), liquides.getId(), base.getId()).save(conn);
        new Ingredient("Jus de fruits", "Non ingrédient de base", "1500", unit.getId(), liquides.getId(), nonBase.getId()).save(conn);
        new Ingredient("Café", "Non ingrédient de base", "1500", unit.getId(), liquides.getId(), nonBase.getId()).save(conn);
        new Ingredient("Alcool (ex: rhum, cognac)", "Non ingrédient de base", "1500", unit.getId(), liquides.getId(), nonBase.getId()).save(conn);

        // Chocolat et dérivés
        IngredientType chocolatDerives = new IngredientType("Chocolat et dérivés", "Type d'ingrédient : Chocolat et dérivés");
        chocolatDerives.save(conn);

        new Ingredient("Chocolat noir", "Non ingrédient de base", "1500", unit.getId(), chocolatDerives.getId(), nonBase.getId()).save(conn);
        new Ingredient("Chocolat au lait", "Non ingrédient de base", "1500", unit.getId(), chocolatDerives.getId(), nonBase.getId()).save(conn);
        new Ingredient("Pépites de chocolat", "Non ingrédient de base", "1500", unit.getId(), chocolatDerives.getId(), nonBase.getId()).save(conn);
        new Ingredient("Cacao en poudre", "Non ingrédient de base", "1500", unit.getId(), chocolatDerives.getId(), nonBase.getId()).save(conn);

        // Additifs et autres ingrédients
        IngredientType additifsAutres = new IngredientType("Additifs et autres ingrédients", "Type d'ingrédient : Additifs et autres ingrédients");
        additifsAutres.save(conn);

        new Ingredient("Sel", "Ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), base.getId()).save(conn);
        new Ingredient("Gélatine", "Non ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), nonBase.getId()).save(conn);
        new Ingredient("Agar-agar", "Non ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), nonBase.getId()).save(conn);
        new Ingredient("Pectine", "Non ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), nonBase.getId()).save(conn);
        new Ingredient("Conservateurs", "Non ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), nonBase.getId()).save(conn);
        new Ingredient("Colorants artificiels", "Non ingrédient de base", "1500", unit.getId(), additifsAutres.getId(), nonBase.getId()).save(conn);
    }
}
