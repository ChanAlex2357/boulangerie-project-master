-- Table: ProductType (ProductType)
CREATE TABLE ProductType(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Genre (
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(255) ,
   PRIMARY KEY(id)
);

CREATE TABLE Baker(
   id VARCHAR(255) ,
   name VARCHAR(255) ,
   hire_date DATE NOT NULL ,
   commission NUMERIC(15,2)   NOT NULL,
   genre_id,
   PRIMARY KEY(id),
   FOREIGN KEY(genre_id) REFERENCES Genre(id)
);

CREATE TABLE ConfigCommission(
   id VARCHAR(255) ,
   daty DATE,
   commission NUMERIC(15,2)   NOT NULL,
   seil NUMERIC(15,2)   NOT NULL,
   PRIMARY KEY(id)
);

-- Table: NatureType (NatureType)
CREATE TABLE NatureType(
   id VARCHAR(255),
   value VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   PRIMARY KEY(id)
);


-- Table: Unit (Unit)
CREATE TABLE Unit(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(255),
   PRIMARY KEY(id)
);

-- Table: Supplier (Supplier)
CREATE TABLE Supplier(
   id VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   location VARCHAR(255),
   PRIMARY KEY(id)
);

-- Table: PreOrder (PreOrder)
CREATE TABLE PreOrder(
   id VARCHAR(255),
   pre_order_date DATE NOT NULL,
   PRIMARY KEY(id)
);

-- Table: MovementType (MovementType)
CREATE TABLE MovementType(
   id VARCHAR(255),
   value VARCHAR(50) NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id)
);

-- Table: SupplierInvoice (SupplierInvoice)
CREATE TABLE SupplierInvoice(
   id VARCHAR(255),
   payment_due_date DATE NOT NULL,
   amount NUMERIC(15,2) NOT NULL,
   supplier_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(supplier_id) REFERENCES Supplier(id)
);

-- Table: Customer (Customer)
CREATE TABLE Customer(
   id VARCHAR(255),
   name VARCHAR(50),
   phone VARCHAR(50) NOT NULL,
   address VARCHAR(50) NOT NULL,
   PRIMARY KEY(id),
   UNIQUE(phone)
);

-- Table: Sale (Sale)
CREATE TABLE Sale(
   id VARCHAR(255),
   sale_date DATE NOT NULL,
   amount NUMERIC(15,2) NOT NULL,
   baker_id VARCHAR(255)  NOT NULL,
   customer_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(baker_id) REFERENCES Baker(id),
   FOREIGN KEY(customer_id) REFERENCES Customer(id)
);

CREATE TABLE BakerCommission(
   id VARCHAR(255) ,
   amount NUMERIC(15,2)  ,
   date_commission DATE NOT NULL,
   sale_id VARCHAR(255)  NOT NULL,
   baker_id VARCHAR(255)  NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(sale_id) REFERENCES Sale(id),
   FOREIGN KEY(baker_id) REFERENCES Baker(id)
);
-- Table: Delivery (Delivery)
CREATE TABLE Delivery(
   id VARCHAR(255),
   delivery_date DATE NOT NULL,
   sale_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(sale_id) REFERENCES Sale(id)
);

-- Table: Purchase (Purchase)
CREATE TABLE Purchase(
   id VARCHAR(255),
   purchase_date DATE NOT NULL,
   invoice_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(invoice_id) REFERENCES SupplierInvoice(id)
);

-- Table: Status (Status)
CREATE TABLE Status(
   id VARCHAR(255),
   value INTEGER NOT NULL,
   description VARCHAR(50),
   PRIMARY KEY(id),
   UNIQUE(value)
);

-- Table: IngredientType (IngredientType)
CREATE TABLE IngredientType(
   id VARCHAR(255),
   value VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   PRIMARY KEY(id)
);


-- Table: Ingredient (Ingredient)
CREATE TABLE Ingredient(
   id VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   purchase_price NUMERIC(15,2),
   unit_id VARCHAR(255) NOT NULL,
   nature_type_id VARCHAR(255) NOT NULL,
   ingredient_type_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(unit_id) REFERENCES Unit(id),
   FOREIGN KEY(ingredient_type_id) REFERENCES IngredientType(id),
   FOREIGN KEY(nature_type_id) REFERENCES NatureType(id)
);

-- Table: RecipeType (RecipeType)
CREATE TABLE RecipeType(
   id VARCHAR(255),
   value VARCHAR(255),
   description VARCHAR(255),
   PRIMARY KEY(id)
);

-- Table: Product (Product)
CREATE TABLE Product(
   id VARCHAR(255),
   name VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   sale_price NUMERIC(15,2),
   unit_id VARCHAR(255) NOT NULL,
   product_type_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(unit_id) REFERENCES Unit(id),
   FOREIGN KEY(product_type_id) REFERENCES ProductType(id)
);

-- Table: Recipe (Recipe)
CREATE TABLE Recipe(
   id VARCHAR(255),
   recipe_cost NUMERIC(15,2) NOT NULL,
   name VARCHAR(255) NOT NULL,
   recipe_type_id VARCHAR(255) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(recipe_type_id) REFERENCES RecipeType(id),
   FOREIGN KEY(product_id) REFERENCES Product(id)
);

-- Table: RecipeIngredient (RecipeIngredient)
CREATE TABLE RecipeIngredient(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   recipe_id VARCHAR(255) NOT NULL,
   ingredient_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(recipe_id) REFERENCES Recipe(id),
   FOREIGN KEY(ingredient_id) REFERENCES Ingredient(id)
);

-- Table: PreOrderDetails (PreOrderDetails)
CREATE TABLE PreOrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   pre_order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(pre_order_id) REFERENCES PreOrder(id)
);

-- Table: Ordering (Ordering)
CREATE TABLE Ordering(
   id VARCHAR(255),
   order_date DATE NOT NULL,
   supplier_id VARCHAR(255) NOT NULL,
   pre_order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(supplier_id) REFERENCES Supplier(id),
   FOREIGN KEY(pre_order_id) REFERENCES PreOrder(id)
);

-- Table: OrderDetails (OrderDetails)
CREATE TABLE OrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(order_id) REFERENCES Ordering(id)
);

-- Table: Reception (Reception)
CREATE TABLE Reception(
   id VARCHAR(255),
   reception_date DATE NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   supplier_invoice_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(order_id) REFERENCES Ordering(id),
   FOREIGN KEY(supplier_invoice_id) REFERENCES SupplierInvoice(id)
);

-- Table: StockMovement (StockMovement)
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

-- Table: Inventory (Inventory)
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
   production_date DATE NOT NULL,
   production_cost VARCHAR(255),
   product_id VARCHAR(255) NOT NULL,
   recipe_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(recipe_id) REFERENCES Recipe(id)
);

-- Table: ProductionDetails (ProductionDetails)
CREATE TABLE ProductionDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   ingredient_id VARCHAR(255) NOT NULL,
   production_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(ingredient_id) REFERENCES Ingredient(id),
   FOREIGN KEY(production_id) REFERENCES Production(id)
);

-- Table: ReceptionDetails (ReceptionDetails)
CREATE TABLE ReceptionDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   delivery_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(delivery_id) REFERENCES Reception(id)
);

-- Table: CustomerOrder (CustomerOrder)
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

-- Table: CustomerOrderDetails (CustomerOrderDetails)
CREATE TABLE CustomerOrderDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   order_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(order_id) REFERENCES CustomerOrder(id)
);

-- Table: SaleDetails (SaleDetails)
CREATE TABLE SaleDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   unit_price NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   sale_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(sale_id) REFERENCES Sale(id)
);

-- Table: DeliveryDetails (DeliveryDetails)
CREATE TABLE DeliveryDetails(
   id VARCHAR(255),
   quantity NUMERIC(15,2) NOT NULL,
   product_id VARCHAR(255) NOT NULL,
   delivery_id VARCHAR(255) NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id),
   FOREIGN KEY(delivery_id) REFERENCES Delivery(id)
);

-- Table: RecipeTypes (RecipeTypes)
CREATE TABLE RecipeTypes(
   recipe_id VARCHAR(255),
   type_id VARCHAR(255),
   PRIMARY KEY(recipe_id, type_id),
   FOREIGN KEY(recipe_id) REFERENCES Recipe(id),
   FOREIGN KEY(type_id) REFERENCES RecipeType(id)
);

-- Table: ProductRecommendation (ProductRecommendation)
CREATE TABLE ProductRecommendation(
   id VARCHAR(255),
   product_id VARCHAR(255) NOT NULL,
   date_min DATE NOT NULL,
   date_max DATE NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(product_id) REFERENCES Product(id)
);

