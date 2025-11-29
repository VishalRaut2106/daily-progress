# Write your MySQL query statement below
Select project_id , round(avg(experience_years),2 ) average_years
from project p 
left join employee e
on p.employee_id = e.employee_id
group by project_id