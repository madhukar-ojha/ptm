SELECT m.menuKey, m.menuName, m.menuUrl, mc.actionKey, mc.actionType, mc.subMenuKey, mc.subMenuName, mc.subMenuUrl, 
mc.commandKey, mc.commandName FROM submenu_command mc INNER JOIN designation_submenu_command dmc 
ON mc.id = dmc.submenu_command_id INNER JOIN menu m ON m.id = mc.menu_id 
WHERE dmc.designation_id =30 ORDER BY m.sequence;