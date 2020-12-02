SELECT m.id AS menuid , m.menuName AS menuname, m.menuKey AS menukey, m.menuUrl as menuUrl, 
c.id AS cmmandid , c.commandName AS commandname, c.commandKey AS commandkey,
mc.actionKey, mc.menu_id AS menucommand_id , mc.menukey AS menucommand_Key, mc.menuUrl AS menu_command_url, mc.menuName,
mc.command_id AS menucommand_commandid, mc.commandKey AS menucommand_cmdkey 
FROM  menu_command mc JOIN designation_menu_command dmc
ON dmc.menu_command_id = mc.id
JOIN menu m
ON mc.menu_id = m.id
JOIN command c
ON c.id = mc.command_id
WHERE dmc.designation_id = 23