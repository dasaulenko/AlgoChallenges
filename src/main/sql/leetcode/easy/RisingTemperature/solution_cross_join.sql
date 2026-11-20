-- O(N²)
SELECT t.id as id
FROM Weather t
	CROSS JOIN Weather y
WHERE t.recordDate - y.recordDate = 1
	AND t.temperature > y.temperature;