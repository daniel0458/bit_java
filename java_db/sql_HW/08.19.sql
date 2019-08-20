1.
select e.employee_id 사번, e.first_name 이름, department_name 부서명, m.first_name 매니저이름
from employees e,employees m,departments d
where e.department_id = d.department_id and e.manager_id = m.employee_id;

2.
select e.last_name LAST_NAME, e.salary SALARY
from employees e
    join employees m
    on e.manager_id = m.employee_id
where e.salary > m.salary;

3.
select FIRST_NAME,LAST_NAME,SALARY
from employees e 
    join jobs j
    on e.job_id = j.job_id
where lower(job_title) = lower('Sales Representative') and salary BETWEEN 9000 and 10000;

4.
select e.employee_id , e.last_name, e.hire_date
from employees e
    join employees m
    on e.manager_id = m.employee_id
where e.hire_date < m.hire_date;

5.
--select DISTINCT j.job_title, d.department_name
--from employees e
--    join jobs j
--    on e.job_id = j.job_id 
--    join departments d
--    on e.department_id = d.department_id
--order by j.job_title;

select DISTINCT j.job_title, d.department_name
from jobs j
    join employees e
    on e.job_id = j.job_id 
    join departments d
    on e.department_id = d.department_id;


6.
select to_char(hire_date, 'mm') 월, count(to_char(hire_date, 'mm')) 입사자수
from employees
group by to_char(hire_date, 'mm')
order by 월;

7.
select e.first_name,e.hire_date,m.employee_id,m.first_name
from employees e
    left OUTER JOIN employees m
    on e.manager_id = m.employee_id
where to_char(e.hire_date,'yy') ='08'; 

8.
select first_name,salary,department_name
from employees e
    join departments d
    on e.department_id = d.department_id
where lower(d.department_name) = lower('Sales');

9.
select employee_id,first_name,last_name,nvl(department_name,'<NOT ASSIGNED>') department_name
from employees e
    left outer join departments d
    on e.department_id = d.department_id
where to_char(hire_date,'yy') ='04'
order by employee_id;

10.
select e.first_name,e.hire_date,m.employee_id,nvl(m.first_name,'(null)')
from employees e
    left outer join employees m
    on e.manager_id = m.employee_id
where to_char(e.hire_date,'yy') = '03';

#############################
page처리
#############################

select * from (
select rownum row#, ename,sal,hiredate
from (select * from emp order by sal desc)
)
where row# between 5 and 9;
					start			end
1page 1~5			5*(page-1)+1	5*page
2page 6~10
3page 11~15