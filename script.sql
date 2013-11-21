SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `db` ;
USE `db` ;

-- -----------------------------------------------------
-- Table `db`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`roles` (
  `id` INT NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`users` (
  `user_id` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`user_roles` (
  `USER_ROLE_ID` INT NOT NULL,
  `USER_ID` INT NOT NULL,
  `AUTHORITY` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  UNIQUE INDEX `USER_ID_UNIQUE` (`USER_ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db`.`system`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`system` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `issueTrackerUrl` VARCHAR(45) NULL DEFAULT NULL,
  `programmingLang` VARCHAR(45) NULL DEFAULT NULL,
  `versionControlUrl` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4;


-- -----------------------------------------------------
-- Table `db`.`release`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`release` (
  `releaseid` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `system_id` INT(11) NULL,
  PRIMARY KEY (`releaseid`),
  INDEX `system_id_idx` (`system_id` ASC),
  CONSTRAINT `system_id`
    FOREIGN KEY (`system_id`)
    REFERENCES `db`.`system` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6;


-- -----------------------------------------------------
-- Table `db`.`versions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db`.`versions` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `system_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
