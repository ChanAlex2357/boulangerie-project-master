package bakery.data;

import java.sql.Connection;
import bakery.model.ProductType;


public class ProductTypeData implements DataGen {
    @Override
    public void generate(Connection conn) throws Exception {
        ProductType[] productTypes = new ProductType().getAll(conn);
        if (productTypes.length > 0) {
            for (ProductType productType : productTypes) {
                System.out.println(productType);
            }
            System.out.println("ProductType Already Exists ... ");
            return;
        }
        ProductType pains = new ProductType();
        pains.setValue("Pains");
        pains.setDescription("Type de produit : Pains");

        ProductType viennoiserie = new ProductType();
        viennoiserie.setValue("Viennoiserie");
        viennoiserie.setDescription("Type de produit : Viennoiserie");

        ProductType patisseries = new ProductType();
        patisseries.setValue("Pâtisseries");
        patisseries.setDescription("Type de produit : Pâtisseries");

        ProductType gateauxEntremets = new ProductType();
        gateauxEntremets.setValue("Gâteaux et entremets");
        gateauxEntremets.setDescription("Type de produit : Gâteaux et entremets");

        ProductType sandwichsSnacks = new ProductType();
        sandwichsSnacks.setValue("Sandwichs et snacks");
        sandwichsSnacks.setDescription("Type de produit : Sandwichs et snacks");

        ProductType biscuitsPetitsFours = new ProductType();
        biscuitsPetitsFours.setValue("Biscuits et petits fours");
        biscuitsPetitsFours.setDescription("Type de produit : Biscuits et petits fours");

        ProductType produitsSpeciaux = new ProductType();
        produitsSpeciaux.setValue("Produits spéciaux");
        produitsSpeciaux.setDescription("Type de produit : Produits spéciaux");

        pains.save(conn);
        viennoiserie.save(conn);
        patisseries.save(conn);
        gateauxEntremets.save(conn);
        sandwichsSnacks.save(conn);
        biscuitsPetitsFours.save(conn);
        produitsSpeciaux.save(conn);
    }
}
