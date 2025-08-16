# Write your MySQL query statement below

SELECT e1.name
FROM Employee e1
INNER JOIN Employee e2
ON e1.id = e2.managerId
GROUP BY e2.managerID
HAVING COUNT(e2.managerID)>= 5