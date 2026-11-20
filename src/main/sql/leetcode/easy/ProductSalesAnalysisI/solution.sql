SELECT product_name, year, price
FROM Sales 
	LEFT OUTER JOIN Product 
		ON Sales.product_id = Product.product_id;
