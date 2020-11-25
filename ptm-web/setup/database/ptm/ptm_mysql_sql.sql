SELECT  m.id, m.menuName, m.menuKey FROM menu m
INNER JOIN menu_command mc
ON m.id = mc.menu_id
JOIN role_menu_command rmc
ON mc.id = rmc.menucommand_id AND role_id = 14

SELECT rmc.menucommand_id, c.id, c.commandName, c.commandKey FROM command c
INNER JOIN menu_command mc
ON c.id = mc.command_id
JOIN role_menu_command rmc
ON mc.id = rmc.menucommand_id AND role_id = 14 ORDER BY menucommand_id

SELECT mc.id, mc.menuKey, mc.id, mc.commandKey, mc.urlKey, mc.urlValue
FROM menu_command mc
INNER JOIN role_menu_command rmc
ON mc.id = rmc.menucommand_id AND role_id = 14

SELECT menu_id, command_id FROM menu_command mc
INNER JOIN role_menu_command rmc
ON mc.id = rmc.menucommand_id 
WHERE role_id = 13