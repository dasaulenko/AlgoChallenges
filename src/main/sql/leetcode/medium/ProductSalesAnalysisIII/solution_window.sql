SELECT product_id,
	year AS first_year,
	quantity,
	price
FROM (
		SELECT product_id,
			year,
			quantity,
			price,
			MIN(year) OVER (PARTITION BY product_id) AS first_year
		FROM Sales
	) s
WHERE year = first_year;