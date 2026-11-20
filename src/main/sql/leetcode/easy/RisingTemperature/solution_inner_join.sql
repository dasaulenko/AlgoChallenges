-- O(N log N)
SELECT t.id as id
FROM Weather t
	INNER JOIN Weather y
		ON y.recordDate = t.recordDate - 1
WHERE t.temperature > y.temperature;