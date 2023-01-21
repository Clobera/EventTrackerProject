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
  `address` VARCHAR(150) NOT NULL,
  `time` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `link` VARCHAR(2048) NULL,
  `event_picture` VARCHAR(2048) NULL,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
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
INSERT INTO `type` (`id`, `name`) VALUES (1, 'Live Music');
INSERT INTO `type` (`id`, `name`) VALUES (2, 'Festivals');
INSERT INTO `type` (`id`, `name`) VALUES (3, 'Film & Video');
INSERT INTO `type` (`id`, `name`) VALUES (4, 'Visual Arts');
INSERT INTO `type` (`id`, `name`) VALUES (5, 'Comedy & Improv');
INSERT INTO `type` (`id`, `name`) VALUES (6, 'Museums & Exhibits');
INSERT INTO `type` (`id`, `name`) VALUES (7, 'Performing Arts');
INSERT INTO `type` (`id`, `name`) VALUES (8, 'Interactive/Media Arts');
INSERT INTO `type` (`id`, `name`) VALUES (9, 'Food & Drink');
INSERT INTO `type` (`id`, `name`) VALUES (10, 'Sports & Fitness');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `event` (`id`, `name`, `start_date`, `end_date`, `address`, `time`, `description`, `link`, `event_picture`, `type_id`) VALUES (1, 'Buddy Guy', '2023-03-04', '2023-03-04', 'ACL Live 310 W Willie Nelson Blvd, Austin, TX', '5:30 PM', 'Buddy Guy plays 150 shows a year …and his take on the blues, expressed through his plaintive voice and virtuosic guitar, is still scorching.\" - Billboard \"searing… masterful…. Buddy Guy…shows no signs of decreasing productivity.\" - Rolling Stone \"While it\'s almost a given that Buddy wins when he releases something, next year it will be because it\'s truly well deserved. This is a superb album and it is well worth adding to any blues lover\'s collection.\" - Blues Blast Magazine Today, Multi-Grammy Award winning blues icon Buddy Guy celebrates his seventh #1 album THE BLUES DON\'T LIE, released via Silvertone/RCA Records. Along with it, he bids adieu to extensive touring, with the upcoming 2023 Damn Right Farewell Tour, kicking off February 17, 2023, in Rockford, IL. Local presales begin Wed Oct 19 at 10AM local time. Tickets go on sale this Friday, October 21, at 10AM local time.', 'https://tixel.com/music-tickets/2023/03/04/buddy-guy-damn-right-farewell', 'https://event-images.tixel.com/cdn-cgi/image/width=600,format=auto/media/images/d54aae78b605369d4f7ed0d052e7935d_1667283632_206_l.jpg', 1);
INSERT INTO `event` (`id`, `name`, `start_date`, `end_date`, `address`, `time`, `description`, `link`, `event_picture`, `type_id`) VALUES (2, 'Jam & Toast', '2023-01-22', '2023-01-22', 'Pershing\n2415 E 5th St., Austin, TX', '12 PM', 'The blues, funk, soul and rock inspired SHADOW BAND hails from Austin, Texas with Robert Parker Jr. on guitar/vocals, Jennifer Foster on bass/vocals and Anthony Corsaro on drums. Robert began as a blues inspired self-taught guitarist from Southern California, gigging up and down the coast. Jennifer picked up the bass one year ago. She moonlights as an actress and vocal arranger with original albums, Broadway shows, films, commercials, and TV shows under her belt. Anthony started in bands, drumlines, churches; studied at University of North Texas and continues to push his creative boundaries in areas like engineering, producing live podcasts, mixing/recording and beyond. The trio met in the summer of 2021 at Mozart\'s Coffee in Austin and the rest is history.\n\nWith collective inspirations like The Meters, Bonnie Raitt, Jimi Hendrix, The Grateful Dead, and Stevie Ray Vaughan, this trio has played at hundreds of venues in and around Austin.', 'https://www.eventbrite.com/e/jam-toast-sunday-brunch-and-live-music-featuring-shadow-band-tickets-465217156037', 'https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F391887449%2F318286210865%2F1%2Foriginal.20221111-194210?h=2000&w=720&auto=format%2Ccompress&q=75&sharp=10&rect=541%2C0%2C1088%2C1080&s=1f5a4dbe0d7b8c4e4817b44b62a92deb', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `comment` (`id`, `name`, `content`, `event_id`) VALUES (1, 'Carlos', 'this is a test comment', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `picture`
-- -----------------------------------------------------
START TRANSACTION;
USE `austineventsdb`;
INSERT INTO `picture` (`id`, `url`, `picture_description`, `event_id`) VALUES (1, 'https://media.istockphoto.com/id/825383494/photo/business-man-pushing-large-stone-up-to-hill-business-heavy-tasks-and-problems-concept.jpg?s=612x612&w=0&k=20&c=wtqvbQ6OIHitRVDPTtoT_1HKUAOgyqa7YzzTMXqGRaQ=', 'test picture description', 1);

COMMIT;

