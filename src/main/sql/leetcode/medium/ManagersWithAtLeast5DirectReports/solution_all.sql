SELECT e2.name AS name
FROM Employee e2
	LEFT OUTER JOIN (SELECT e1.managerId AS managerId, COUNT(e1.managerId) AS count
										FROM Employee e1
										GROUP BY e1.managerId) s1
		ON s1.managerId = e2.id
WHERE s1.count >= 5;