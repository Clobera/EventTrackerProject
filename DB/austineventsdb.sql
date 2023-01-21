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
-- Table `type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `type` ;

CREATE TABLE IF NOT EXISTS `type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `time` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `link` VARCHAR(2048) NULL,
  `type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_type1_idx` (`type_id` ASC),
  CONSTRAINT `fk_event_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `content` TEXT NOT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_comment_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `picture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `picture` ;

CREATE TABLE IF NOT EXISTS `picture` (
  `id` INT NOT NULL,
  `url` VARCHAR(2048) NOT NULL,
  `picture_description` VARCHAR(45) NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pictures_event1_idx` (`event_id` ASC),
  CONSTRAINT `fk_pictures_event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `type`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `type` (`id`, `name`) VALUES (1, 'Music');
INSERT INTO `type` (`id`, `name`) VALUES (2, 'Art');
INSERT INTO `type` (`id`, `name`) VALUES (3, 'Sports');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `event` (`id`, `name`, `start_date`, `end_date`, `address`, `time`, `description`, `link`, `type_id`) VALUES (1, 'Test', '2023-01-01', '2023-01-01', '14307 hunters pass', NULL, NULL, NULL, 1);

COMMIT;

