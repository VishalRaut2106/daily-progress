# Write your MySQL query statement below
select emp.name   , empu.unique_id
from Employees as emp 
left join EmployeeUNI as empu
on emp.id = empu.id