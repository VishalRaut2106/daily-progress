# Write your MySQL query statement below
select distinct visited_on, amount, round(amount/7, 2) as average_amount
from
    (select visited_on, sum(amount) over(order by visited_on range between interval 6 day preceding and current row) as amount, 
    min(visited_on) over() as first_day
    from Customer
    ) temp
where visited_on >= first_day + 6
order by 1