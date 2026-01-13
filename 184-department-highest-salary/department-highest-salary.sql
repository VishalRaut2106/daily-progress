# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary
from Department d join Employee e
on d.id = e.departmentId
where (e.departmentId, e.salary) in 
    (select departmentId, max(salary)
    from Employee
    group by departmentId)
