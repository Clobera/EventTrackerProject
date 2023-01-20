-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema austineventsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `austineventsdb` ;

-- -----------------------------------------------------
-- Schema austineventsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `austineventsdb` DEFAULT CHARACTER SET utf8 ;
USE `austineventsdb` ;

-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `date` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `link` VARCHAR(2048) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event_type` ;

CREATE TABLE IF NOT EXISTS `event_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS austinevents@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'austinevents'@'localhost' IDENTIFIED BY 'austinevents';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'austinevents'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `event` (`id`, `name`, `date`, `address`, `time`, `description`, `link`) VALUES (1, 'Test', NULL, NULL, NULL, NULL, NULL);

COMMIT;

