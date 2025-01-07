-- Table: TypeProduct (TypeProduct)
CREATE TABLE ProductType(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id)
);

-- Table: Unite (Unit)
CREATE TABLE Unit(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(255),
   PRIMARY KEY(id)
);

-- Table: Fournisseur (Supplier)
CREATE TABLE Supplier(
   id VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   location VARCHAR(255),
   PRIMARY KEY(id)
);

-- Table: BonPreCommande (PreOrder)
CREATE TABLE PreOrder(
   id VARCHAR(255),
   pre_order_date DATE NOT NULL,
   PRIMARY KEY(id)
);

-- Table: TypeMvt (MovementType)
CREATE TABLE MovementType(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id)
);

-- Table: FactureFournisseur (SupplierInvoice)
CREATE TABLE SupplierInvoice(
   id VARCHAR(255),
   payment_due_date DATE NOT NULL,
   amount NUMERIC(15,2) NOT NULL,
   supplier_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(supplier_id) REFERENCES Supplier(id)
);

-- Table: Client (Customer)
CREATE TABLE Customer(
   id VARCHAR(255),
   name VARCHAR(50),
   phone VARCHAR(50) NOT NULL,
   address VARCHAR(50) NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(phone)
);

-- Table: Vente (Sale)
CREATE TABLE Sale(
   id VARCHAR(255),
   sale_date DATE NOT NULL,
   amount NUMERIC(15,2) NOT NULL,
   customer_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(customer_id) REFERENCES Customer(id)
);

-- Table: Livraison (Delivery)
CREATE TABLE Delivery(
   id VARCHAR(255),
   delivery_date DATE NOT NULL,
   sale_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(sale_id) REFERENCES Sale(id)
);

-- Table: Achat (Purchase)
CREATE TABLE Purchase(
   id VARCHAR(255),
   purchase_date DATE NOT NULL,
   invoice_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(invoice_id) REFERENCES SupplierInvoice(id)
);

-- Table: Etat (Status)
CREATE TABLE Status(
   id VARCHAR(255),
   value INTEGER NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id),
   UNIQUE(value)
);

-- Table: Product (Product)
CREATE TABLE Product(
   id VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   purchase_price NUMERIC(15,2),
   sale_price NUMERIC(15,2),
   is_purchase BOOLEAN,
   is_sale BOOLEAN,
   unit_id VARCHAR(255) NOT NULL,
   product_type_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(unit_id) REFERENCES Unit(id),
   FOREIGN KEY(product_type_id) REFERENCES ProductType(id)
);

-- Table: Recette (Recipe)
CREATE TABLE Recipe(
   id VARCHAR(255),
   product_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id)
);

-- Table: IngredientRecette (RecipeIngredient)
CREATE TABLE RecipeIngredient(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   ingredient_id VARCHAR(255) NOT NULL,
   recipe_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(ingredient_id) REFERENCES Product(id),
   FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
);

-- Table: DetailsPreCommande (PreOrderDetails)
CREATE TABLE PreOrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   pre_order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(pre_order_id) REFERENCES PreOrder(id)
);

-- Table: Commande (Order)
CREATE TABLE Order(
   id VARCHAR(255),
   order_date DATE NOT NULL,
   supplier_id VARCHAR(255) NOT NULL,
   pre_order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(supplier_id) REFERENCES Supplier(id),
   FOREIGN KEY(pre_order_id) REFERENCES PreOrder(id)
);

-- Table: DetailsCommande (OrderDetails)
CREATE TABLE OrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(order_id) REFERENCES Order(id)
);

-- Table: Reception (Reception)
CREATE TABLE Reception(
   id VARCHAR(255),
   reception_date DATE NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   supplier_invoice_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(order_id) REFERENCES Order(id),
   FOREIGN KEY(supplier_invoice_id) REFERENCES SupplierInvoice(id)
);

-- Table: MouvementStock (StockMovement)
CREATE TABLE StockMovement(
   id VARCHAR(255),
   entry NUMERIC(15,2) NOT NULL,
   exit NUMERIC(15,2) NOT NULL,
   movement_date DATE NOT NULL,
   source_id VARCHAR(255),
   product_id VARCHAR(255) NOT NULL,
   movement_type_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(movement_type_id) REFERENCES MovementType(id)
);

-- Table: Inventaire (Inventory)
CREATE TABLE Inventory(
   id VARCHAR(255),
   inventory_date DATE NOT NULL,
   theoretical_quantity NUMERIC(15,2),
   actual_quantity NUMERIC(15,2),
   product_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id)
);

-- Table: Production (Production)
CREATE TABLE Production(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   production_date DATE NOT NULL,
   recipe_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
);

-- Table: DetailsReception (ReceptionDetails)
CREATE TABLE ReceptionDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   delivery_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(delivery_id) REFERENCES Reception(id)
);

-- Table: CommandeClient (CustomerOrder)
CREATE TABLE CustomerOrder(
   id VARCHAR(255),
   order_date DATE NOT NULL,
   amount NUMERIC(15,2) NOT NULL,
   status_id VARCHAR(255) NOT NULL,
   customer_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(status_id) REFERENCES Status(id),
   FOREIGN KEY(customer_id) REFERENCES Customer(id)
);

-- Table: DetailsCommandeClient (OrderDetails)
CREATE TABLE OrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(order_id) REFERENCES CustomerOrder(id)
);

-- Table: DetailsVente (SaleDetails)
CREATE TABLE SaleDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   sale_id VARCHAR(255) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(sale_id) REFERENCES Sale(id),
   FOREIGN KEY(product_id) REFERENCES Product(id)
);

-- Table: DetailsLivraison (DeliveryDetails)
CREATE TABLE DeliveryDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   delivery_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(delivery_id) REFERENCES Delivery(id)
);
