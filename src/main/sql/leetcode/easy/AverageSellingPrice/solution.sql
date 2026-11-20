SELECT 
	p.product_id product_id, 
	COALESCE(ROUND(SUM(u.units * p.price)::NUMERIC / SUM(u.units), 2), 0) average_price
FROM Prices p
	LEFT OUTER JOIN UnitsSold u
		ON p.product_id = u.product_id 
			AND u.purchase_date >= p.start_date 
			AND u.purchase_date <= p.end_date 
			AND u.units > 0
GROUP BY p.product_id