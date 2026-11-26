WITH managers AS (
  SELECT reports_to AS manager_id,
    COUNT(*) AS reports_count,
    ROUND(AVG(age)) AS average_age
  FROM Employees
  WHERE reports_to IS NOT NULL
  GROUP BY reports_to
)
SELECT e.employee_id,
  e.name,
  m.reports_count,
  m.average_age
FROM managers m
  INNER JOIN Employees e ON m.manager_id = e.employee_id
ORDER BY e.employee_id