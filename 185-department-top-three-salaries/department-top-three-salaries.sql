WITH EmpCTE AS (
    SELECT 
        e.id,
        e.name,
        e.salary,
        e.departmentId
    FROM Employee e
)
SELECT 
    d.name AS Department,
    e1.name AS Employee,
    e1.salary AS Salary
FROM EmpCTE e1
JOIN Department d
    ON e1.departmentId = d.id
WHERE (
    SELECT COUNT(DISTINCT e2.salary)
    FROM EmpCTE e2
    WHERE e2.departmentId = e1.departmentId
      AND e2.salary > e1.salary
) < 3;