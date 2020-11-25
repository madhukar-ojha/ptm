CREATE TRIGGER employee_BeforeInsert BEFORE INSERT ON `employee`
FOR EACH ROW SET NEW.createdOn = CURDATE();

CREATE TRIGGER employee_BeforeUpdate BEFORE UPDATE ON `employee`
FOR EACH ROW SET NEW.updatedOn = CURDATE();