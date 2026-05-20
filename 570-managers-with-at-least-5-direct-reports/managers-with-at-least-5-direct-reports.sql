# Write your MySQL query statement below
WITH RECURSIVE cte AS (
    SELECT id,name,managerId
    FROM Employee
)
SELECT e2.name
FROM Employee e1
JOIN Employee e2
ON e1.managerId = e2.id
GROUP BY e2.id, e2.name
HAVING COUNT(e1.id) >= 5;