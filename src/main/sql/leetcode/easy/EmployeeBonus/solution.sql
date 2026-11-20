SELECT E1.name AS name, B1.bonus AS bonus
FROM Employee E1
	LEFT OUTER JOIN BONUS B1
		ON E1.empId = B1.empId
WHERE B1.bonus IS NULL OR B1.bonus < 1000