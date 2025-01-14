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
