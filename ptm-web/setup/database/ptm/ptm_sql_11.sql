ALTER TABLE employee
ADD COLUMN displayName VARCHAR(50)  
GENERATED ALWAYS AS (CONCAT(firstName, ' ' , lastName)) VIRTUAL AFTER nickName ;

SELECT displayName from employee

DESC employee

SELECT mc.id, mc.menuKey, mc.commandKey, mc.urlKey, mc.urlValue 
FROM menu_command mc 
INNER JOIN designation_menu_command dmc 
ON mc.id = dmc.menu_command_id AND dmc.designation_id=?

SELECT mc.id, mc.menuKey, mc.menuValue, mc.commandKey, mc.commandValue FROM menu_command mc
INNER JOIN designation_menu_command dmc
ON mc.id = dmc.menu_command_id AND dmc.designation_id=12


SELECT role_id, department_id FROM designation WHERE id =14

UPDATE employee SET nickName = 'motak' WHERE id =101

INSERT into `employee` (id, nickName, lastName)
    VALUES (1, 'apple', 'mango')
    ON DUPLICATE KEY UPDATE id = VALUES(id);