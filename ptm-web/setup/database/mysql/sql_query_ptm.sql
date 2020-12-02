SELECT m.id, m.menuName, m.menuKey FROM menu m
INNER JOIN menu_action ma
ON m.id = ma.menu_id
JOIN role_menu_action rma
ON ma.id = rma.menuaction_id AND role_id = 13

SELECT a.id, a.actionName, a.actionKey FROM action a
INNER JOIN menu_action ma
ON a.id = ma.action_id
INNER JOIN role_menu_action rma
ON a.id = rma.menuaction_id AND role_id = 12

ALTER TABLE designation
ADD COLUMN designationName VARCHAR(50) 
GENERATED ALWAYS AS (CONCAT(role_name, ' ', department_name)) VIRTUAL AFTER department_name;


SELECT menu_id, action_id FROM menu_action WHERE id IN
(SELECT menuaction_id FROM role_menu_action WHERE role_id = 13)

Select id, menuName, menuKey, menuType from menu where id BETWEEN 10 AND 11