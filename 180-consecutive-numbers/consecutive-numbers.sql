# Write your MySQL query statement below
select distinct num as ConsecutiveNums
from
(
    select *, lag(num, 1) over(order by id) lag_num1, lag(num, 2) over(order by id) lag_num2
    from Logs
) temp1
where num = lag_num1 and lag_num1 = lag_num2