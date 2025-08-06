# Write your MySQL query statement below
SELECT today.id
FROM weather AS today
INNER JOIN weather AS yesterday
ON (DATE_SUB(Today.recordDate, INTERVAL 1 DAY) = Yesterday.recordDate)
WHERE Today.temperature > Yesterday.temperature