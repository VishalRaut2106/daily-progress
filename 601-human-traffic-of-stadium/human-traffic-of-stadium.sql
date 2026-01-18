# Write your MySQL query statement below
with cte as
(select *, 
    lead(people, 1) over(order by id) as le1,
    lead(people, 2) over(order by id) as le2,
    lag(people, 1) over(order by id) as la1,
    lag(people, 2) over(order by id) as la2
from Stadium)

select id, visit_date, people
from cte
where people >= 100 and ((le1 >= 100 and le2 >= 100) or
                        (la1 >= 100 and la2 >= 100) or
                        (le1 >= 100 and la1 >= 100))