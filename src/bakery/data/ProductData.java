package bakery.data;

import java.sql.Connection;

import bakery.model.Product;
import bakery.model.ProductType;
import bakery.model.Unit;
import mg.jca.gfja.mapping.ClassMap;

public class ProductData implements DataGen{

    @Override
    public void generate(Connection conn) throws Exception {
        Product[] products = new Product().getAll(conn);
        if (products.length > 0) {
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Product Already Exists ... ");
            return;
        }
        // Fetch units and product types
        Unit[] units = new Unit().getAll(conn);
        ProductType[] productTypes = new ProductType().getAll(conn);

        // Assuming units and productTypes are not empty and have the required data
        Unit unit = units[0]; // Default unit
        ProductType pains = productTypes[0]; // Default product type
        ProductType viennoiserie = productTypes[1]; // Default product type
        ProductType patisseries = productTypes[2]; // Default product type
        ProductType gateauxEntremets = productTypes[3]; // Default product type
        ProductType sandwichsSnacks = productTypes[4]; // Default product type
        ProductType biscuitsPetitsFours = productTypes[5]; // Default product type
        ProductType produitsSpeciaux = productTypes[6]; // Default product type

        // Pains
        Product baguette = new Product();
        baguette.setName("Baguette");
        baguette.setDescription("Pain long et croustillant à la croûte dorée, emblématique de la France.");
        baguette.setUnitId(unit.getId());
        baguette.setProductTypeId(pains.getId());

        Product painDeCampagne = new Product();
        painDeCampagne.setName("Pain de campagne");
        painDeCampagne.setDescription("Pain rustique à base de farine de blé et de seigle, souvent avec une croûte épaisse.");
        painDeCampagne.setUnitId(unit.getId());
        painDeCampagne.setProductTypeId(pains.getId());

        Product painComplet = new Product();
        painComplet.setName("Pain complet");
        painComplet.setDescription("Pain riche en fibres, fabriqué à partir de farine complète.");
        painComplet.setUnitId(unit.getId());
        painComplet.setProductTypeId(pains.getId());

        Product painAuxCereales = new Product();
        painAuxCereales.setName("Pain aux céréales");
        painAuxCereales.setDescription("Pain enrichi de diverses graines et céréales, offrant une texture croquante.");
        painAuxCereales.setUnitId(unit.getId());
        painAuxCereales.setProductTypeId(pains.getId());

        Product painDeSeigle = new Product();
        painDeSeigle.setName("Pain de seigle");
        painDeSeigle.setDescription("Pain dense et foncé, fabriqué principalement à partir de farine de seigle.");
        painDeSeigle.setUnitId(unit.getId());
        painDeSeigle.setProductTypeId(pains.getId());

        // Viennoiseries
        Product croissant = new Product();
        croissant.setName("Croissant");
        croissant.setDescription("Pâtisserie feuilletée en forme de croissant, souvent consommée au petit-déjeuner.");
        croissant.setUnitId(unit.getId());
        croissant.setProductTypeId(viennoiserie.getId());

        Product painAuChocolat = new Product();
        painAuChocolat.setName("Pain au chocolat");
        painAuChocolat.setDescription("Viennoiserie feuilletée avec des barres de chocolat à l'intérieur.");
        painAuChocolat.setUnitId(unit.getId());
        painAuChocolat.setProductTypeId(viennoiserie.getId());

        Product brioche = new Product();
        brioche.setName("Brioche");
        brioche.setDescription("Pain doux et moelleux, souvent légèrement sucré.");
        brioche.setUnitId(unit.getId());
        brioche.setProductTypeId(viennoiserie.getId());

        Product chaussonAuxPommes = new Product();
        chaussonAuxPommes.setName("Chausson aux pommes");
        chaussonAuxPommes.setDescription("Pâtisserie feuilletée en forme de demi-lune, garnie de compote de pommes.");
        chaussonAuxPommes.setUnitId(unit.getId());
        chaussonAuxPommes.setProductTypeId(viennoiserie.getId());

        Product painAuxRaisins = new Product();
        painAuxRaisins.setName("Pain aux raisins");
        painAuxRaisins.setDescription("Viennoiserie en spirale avec des raisins secs et de la crème pâtissière.");
        painAuxRaisins.setUnitId(unit.getId());
        painAuxRaisins.setProductTypeId(viennoiserie.getId());

        // Pâtisseries
        Product eclair = new Product();
        eclair.setName("Éclair");
        eclair.setDescription("Pâtisserie allongée remplie de crème pâtissière et glacée au chocolat.");
        eclair.setUnitId(unit.getId());
        eclair.setProductTypeId(patisseries.getId());

        Product tarteAuxFruits = new Product();
        tarteAuxFruits.setName("Tarte aux fruits");
        tarteAuxFruits.setDescription("Pâtisserie composée d'une base de pâte et garnie de fruits frais.");
        tarteAuxFruits.setUnitId(unit.getId());
        tarteAuxFruits.setProductTypeId(patisseries.getId());

        Product milleFeuille = new Product();
        milleFeuille.setName("Mille-feuille");
        milleFeuille.setDescription("Pâtisserie composée de couches de pâte feuilletée et de crème pâtissière.");
        milleFeuille.setUnitId(unit.getId());
        milleFeuille.setProductTypeId(patisseries.getId());

        Product opera = new Product();
        opera.setName("Opéra");
        opera.setDescription("Gâteau en couches avec du biscuit Joconde, de la ganache au chocolat et du café.");
        opera.setUnitId(unit.getId());
        opera.setProductTypeId(patisseries.getId());

        Product macaron = new Product();
        macaron.setName("Macaron");
        macaron.setDescription("Petit gâteau rond à base de poudre d'amandes, souvent coloré et fourré de ganache.");
        macaron.setUnitId(unit.getId());
        macaron.setProductTypeId(patisseries.getId());

        // Gâteaux et entremets
        Product gateauAuChocolat = new Product();
        gateauAuChocolat.setName("Gâteau au chocolat");
        gateauAuChocolat.setDescription("Gâteau riche et moelleux à base de chocolat.");
        gateauAuChocolat.setUnitId(unit.getId());
        gateauAuChocolat.setProductTypeId(gateauxEntremets.getId());

        Product fraisier = new Product();
        fraisier.setName("Fraisier");
        fraisier.setDescription("Gâteau à base de génoise, de crème mousseline et de fraises fraîches.");
        fraisier.setUnitId(unit.getId());
        fraisier.setProductTypeId(gateauxEntremets.getId());

        Product tiramisu = new Product();
        tiramisu.setName("Tiramisu");
        tiramisu.setDescription("Dessert italien à base de mascarpone, de café et de biscuits imbibés.");
        tiramisu.setUnitId(unit.getId());
        tiramisu.setProductTypeId(gateauxEntremets.getId());

        Product cheesecake = new Product();
        cheesecake.setName("Cheesecake");
        cheesecake.setDescription("Gâteau à base de fromage frais, souvent avec une croûte de biscuit.");
        cheesecake.setUnitId(unit.getId());
        cheesecake.setProductTypeId(gateauxEntremets.getId());

        Product bavarois = new Product();
        bavarois.setName("Bavarois");
        bavarois.setDescription("Entremets léger à base de crème anglaise, de gélatine et de crème fouettée.");
        bavarois.setUnitId(unit.getId());
        bavarois.setProductTypeId(gateauxEntremets.getId());

        // Sandwichs et snacks
        Product sandwichJambonBeurre = new Product();
        sandwichJambonBeurre.setName("Sandwich jambon-beurre");
        sandwichJambonBeurre.setDescription("Baguette garnie de jambon et de beurre.");
        sandwichJambonBeurre.setUnitId(unit.getId());
        sandwichJambonBeurre.setProductTypeId(sandwichsSnacks.getId());

        Product quiche = new Product();
        quiche.setName("Quiche");
        quiche.setDescription("Tarte salée à base d'œufs, de crème et de divers ingrédients comme le fromage et les légumes.");
        quiche.setUnitId(unit.getId());
        quiche.setProductTypeId(sandwichsSnacks.getId());

        Product pizza = new Product();
        pizza.setName("Pizza");
        pizza.setDescription("Pâte garnie de sauce tomate, de fromage et de divers ingrédients.");
        pizza.setUnitId(unit.getId());
        pizza.setProductTypeId(sandwichsSnacks.getId());

        Product panini = new Product();
        panini.setName("Panini");
        panini.setDescription("Sandwich italien grillé, souvent garni de fromage, de jambon et de légumes.");
        panini.setUnitId(unit.getId());
        panini.setProductTypeId(sandwichsSnacks.getId());

        Product salades = new Product();
        salades.setName("Salades");
        salades.setDescription("Mélange de légumes frais, parfois accompagné de viande, de fromage ou de poisson.");
        salades.setUnitId(unit.getId());
        salades.setProductTypeId(sandwichsSnacks.getId());

        // Biscuits et petits fours
        Product madeleines = new Product();
        madeleines.setName("Madeleines");
        madeleines.setDescription("Petits gâteaux moelleux en forme de coquillage.");
        madeleines.setUnitId(unit.getId());
        madeleines.setProductTypeId(biscuitsPetitsFours.getId());

        Product sables = new Product();
        sables.setName("Sablés");
        sables.setDescription("Biscuits croquants et friables, souvent au beurre.");
        sables.setUnitId(unit.getId());
        sables.setProductTypeId(biscuitsPetitsFours.getId());

        Product financiers = new Product();
        financiers.setName("Financiers");
        financiers.setDescription("Petits gâteaux aux amandes, souvent en forme de lingot.");
        financiers.setUnitId(unit.getId());
        financiers.setProductTypeId(biscuitsPetitsFours.getId());

        Product cookies = new Product();
        cookies.setName("Cookies");
        cookies.setDescription("Biscuits moelleux ou croquants, souvent avec des pépites de chocolat.");
        cookies.setUnitId(unit.getId());
        cookies.setProductTypeId(biscuitsPetitsFours.getId());

        Product meringues = new Product();
        meringues.setName("Meringues");
        meringues.setDescription("Petits gâteaux légers et croquants à base de blancs d'œufs et de sucre.");
        meringues.setUnitId(unit.getId());
        meringues.setProductTypeId(biscuitsPetitsFours.getId());

        // Produits spéciaux
        Product painSansGluten = new Product();
        painSansGluten.setName("Pain sans gluten");
        painSansGluten.setDescription("Pain fabriqué sans farine de blé, adapté aux personnes intolérantes au gluten.");
        painSansGluten.setUnitId(unit.getId());
        painSansGluten.setProductTypeId(produitsSpeciaux.getId());

        Product patisseriesVeganes = new Product();
        patisseriesVeganes.setName("Pâtisseries véganes");
        patisseriesVeganes.setDescription("Pâtisseries sans produits d'origine animale, adaptées aux régimes végétaliens.");
        patisseriesVeganes.setUnitId(unit.getId());
        patisseriesVeganes.setProductTypeId(produitsSpeciaux.getId());

        Product produitsBio = new Product();
        produitsBio.setName("Produits bio");
        produitsBio.setDescription("Produits fabriqués à partir d'ingrédients issus de l'agriculture biologique.");
        produitsBio.setUnitId(unit.getId());
        produitsBio.setProductTypeId(produitsSpeciaux.getId());

        Product painsSpeciaux = new Product();
        painsSpeciaux.setName("Pains spéciaux");
        painsSpeciaux.setDescription("Pains fabriqués avec des ingrédients ou des techniques spécifiques, comme le pain au levain.");
        painsSpeciaux.setUnitId(unit.getId());
        painsSpeciaux.setProductTypeId(produitsSpeciaux.getId());

        // Save products
        baguette.save(conn);
        painDeCampagne.save(conn);
        painComplet.save(conn);
        painAuxCereales.save(conn);
        painDeSeigle.save(conn);
        croissant.save(conn);
        painAuChocolat.save(conn);
        brioche.save(conn);
        chaussonAuxPommes.save(conn);
        painAuxRaisins.save(conn);
        eclair.save(conn);
        tarteAuxFruits.save(conn);
        milleFeuille.save(conn);
        opera.save(conn);
        macaron.save(conn);
        gateauAuChocolat.save(conn);
        fraisier.save(conn);
        tiramisu.save(conn);
        cheesecake.save(conn);
        bavarois.save(conn);
        sandwichJambonBeurre.save(conn);
        quiche.save(conn);
        pizza.save(conn);
        panini.save(conn);
        salades.save(conn);
        madeleines.save(conn);
        sables.save(conn);
        financiers.save(conn);
        cookies.save(conn);
        meringues.save(conn);
        painSansGluten.save(conn);
        patisseriesVeganes.save(conn);
        produitsBio.save(conn);
        painsSpeciaux.save(conn);
    }
    
}
