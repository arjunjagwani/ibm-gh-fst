select * from scott.emp;
select * from scott.dept;

select a.empno, a.ename,b.ename manager,b.empno mgrno,c.ename skpmgrname,c.empno skpmgrno
from scott.emp a left join scott.emp b 
on a.mgr=b.empno  
left join  scott.emp c 
on b.mgr=c.empno;


select c.country_name,l.city,d.DEPARTMENT_NAME,e.employee_id,e.first_name,e.last_name,
m.first_name mgr_first,m.last_name mgr_last,m.employee_id mgr_id
from hr.countries c left join hr.locations l 
on c.country_id=l.country_id
left join hr.departments d 
on l.location_id=d.location_id
full join hr.employees e
on d.department_id=e.department_id
left join hr.employees m 
on e.manager_id=m.employee_id 
order by e.employee_id;

select e.employee_id,e.first_name,e.last_name,m.first_name,m.last_name,m.employee_id mgr_id 
from hr.employees e left join hr.employees m on e.manager_id=m.employee_id order by e.employee_id;