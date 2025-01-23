CREATE VIEW ProductCpl AS
SELECT 
    p.id AS product_id,
    p.name AS product_name,
    p.description AS product_description,
    p.sale_price AS product_sale_price,
    pt.id AS product_type_id,
    pt.value AS product_type_value,
    pt.description AS product_type_description,
    u.id AS unit_id,
    u.value AS unit_value,
    u.description AS unit_description
FROM 
    Product p
JOIN 
    ProductType pt ON p.product_type_id = pt.id
JOIN 
    Unit u ON p.unit_id = u.id;

DROP VIEW ProductRecommendationCpl;
CREATE VIEW ProductRecommendationCpl AS
SELECT 
    pr.id AS recommendationid,
    pr.date_min AS recommendationdatemin,
    pr.date_max AS recommendationdatemax,
    pc.product_id as productid ,
    pc.product_name as productname,
    pc.product_description as productdescription,
    pc.product_sale_price as productsaleprice,
    pc.product_type_id as producttypeid,
    pc.product_type_value as producttypevalue,
    pc.product_type_description as producttypedescription,
    pc.unit_id as unitid,
    pc.unit_value as unitvalue,
    pc.unit_description as unitdescription
FROM 
    ProductRecommendation pr
JOIN 
    ProductCpl pc ON pr.product_id = pc.product_id;

CREATE VIEW CustomersSale AS
SELECT 
    s.id AS sale_id,
    s.sale_date AS sale_date,
    s.amount AS sale_amount,
    c.id AS customer_id,
    c.name AS customer_name,
    c.phone AS customer_phone,
    c.address AS customer_address
FROM 
    Sale s
JOIN 
    Customer c ON s.customer_id = c.id;

CREATE VIEW BakerCommissionLib as
SELECT 
    bc.id_baker as id_baker,
    bc.montant as montant,
    bc.date_commission as date_commission,
    b.name as name
    b.name as name
    g.value as genre 
FROM
    Baker b
JOIN 
    BakerCommission bc ON b.id=bc.id_baker
JOIN 
    Genre g ON b.genre_id=bc.g.id;

CREATE OR REPLACE VIEW