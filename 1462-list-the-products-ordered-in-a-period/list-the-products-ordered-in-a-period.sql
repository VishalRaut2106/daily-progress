# Write your MySQL query statement below

select p.product_name, sum(unit) as unit
from Orders o
left join Products p
on o.product_id = p.product_id
where o.order_date like '2020-02%'
group by o.product_id
having sum(unit) >= 100