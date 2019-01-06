-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`people`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`people` (
  `person_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `about` VARCHAR(45) NULL DEFAULT NULL,
  `photo` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `zip_code` CHAR(5) NOT NULL,
  `playdate_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`dogs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`dogs` (
  `dog_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `size` ENUM('SMALL', 'MEDIUM', 'LARGE') NULL DEFAULT NULL,
  `vaccinated` TINYINT(4) NULL DEFAULT NULL,
  `about` TEXT NULL DEFAULT NULL,
  `photo` VARCHAR(255) NULL DEFAULT NULL,
  `breed` VARCHAR(45) NULL DEFAULT NULL,
  `preferred_play_buddy` TEXT NULL DEFAULT NULL,
  `person_id` INT(11) NOT NULL,
  PRIMARY KEY (`dog_id`),
  INDEX `fk_Dog_person1_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_Dog_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `mydb`.`people` (`person_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`playdates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`playdates` (
  `playdate_id` INT(11) NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip_code` CHAR(5) NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  `details` TEXT NOT NULL,
  `status` ENUM('PENDING', 'APPROVED', 'DENIED') NOT NULL DEFAULT 'PENDING',
  `requestor_id` INT(11) NOT NULL,
  `reciever_id` INT(11) NOT NULL,
  PRIMARY KEY (`playdate_id`),
  INDEX `fk_Playdate_person1_idx` (`requestor_id` ASC) VISIBLE,
  INDEX `fk_Playdate_person2_idx` (`reciever_id` ASC) VISIBLE,
  CONSTRAINT `fk_Playdate_person1`
    FOREIGN KEY (`requestor_id`)
    REFERENCES `mydb`.`people` (`person_id`),
  CONSTRAINT `fk_Playdate_person2`
    FOREIGN KEY (`reciever_id`)
    REFERENCES `mydb`.`people` (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
