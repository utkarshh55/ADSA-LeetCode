# Write your MySQL query statement below
WITH child_nodes AS (
    SELECT DISTINCT p_id
    FROM Tree
    WHERE p_id IS NOT NULL
)
SELECT 
    t.id,
    CASE
        WHEN t.p_id IS NULL THEN 'Root'
        WHEN t.id IN (SELECT p_id FROM child_nodes) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree t;