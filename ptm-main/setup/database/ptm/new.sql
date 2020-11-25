SELECT e.id, e.displayName, e.designation_id, CONCAT(d.role_name, ' ', d.department_name) AS designation from employee e  
inner join designation d ON e.designation_id = d.id 
AND  e.id=102 and PASSWORD='ptmpwd'

SELECT mc.id, mc.menuKey, mc.id, mc.commandKey, mc.urlKey, mc.urlValue 
FROM menu_command mc 
INNER JOIN designation_menu_command rmc 
ON mc.id = rmc.menucommand_id AND rmc.designation_id=14

SELECT id FROM employee LIMIT  3

SELECT e.id, e.displayName, e.designation_id, CONCAT(d.role_name, ' ', d.department_name) AS designation from employee e 
INNER JOIN designation d ON e.designation_id = d.id LIMIT 5;

SELECT r.id, r.name, d.id, d.name FROM department d
OUTER  JOIN role r
ON d.id = r.id 

SELECT id, NAME FROM role WHERE id IN (SELECT id FROM designation WHERE department_id = 11)