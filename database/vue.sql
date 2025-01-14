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

CREATE VIEW ProductRecommendationCpl AS
SELECT 
    pr.id AS recommendation_id,
    pr.date_min AS recommendation_date_min,
    pr.date_max AS recommendation_date_max,
    pc.product_id,
    pc.product_name,
    pc.product_description,
    pc.product_sale_price,
    pc.product_type_id,
    pc.product_type_value,
    pc.product_type_description,
    pc.unit_id,
    pc.unit_value,
    pc.unit_description
FROM 
    ProductRecommendation pr
JOIN 
    ProductCpl pc ON pr.product_id = pc.product_id;
