# Write your MySQL query statement below
with CTE as
    (select *,
    dense_rank() over(partition by departmentId order by salary desc) as rnk
    from Employee)

select d.name as Department, e.name as Employee, salary as Salary 
from Department d
left join CTE e
on e.departmentId = d.id
where rnk <= 3