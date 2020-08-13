-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema online_blood_bank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_blood_bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_blood_bank` DEFAULT CHARACTER SET utf8 ;
USE `online_blood_bank` ;

-- -----------------------------------------------------
-- Table `online_blood_bank`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`address` (
  `addr_id` INT NOT NULL AUTO_INCREMENT,
  `addr_state` VARCHAR(45) NOT NULL,
  `addr_area` VARCHAR(45) NOT NULL,
  `addr_pincode` INT NOT NULL,
  PRIMARY KEY (`addr_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`blood_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`blood_request` (
  `req_id` INT NOT NULL AUTO_INCREMENT,
  `req_bloodgroup` VARCHAR(5) NOT NULL,
  `req_state` VARCHAR(45) NOT NULL,
  `req_name` VARCHAR(45) NOT NULL,
  `req_contactnumber` VARCHAR(11) NOT NULL,
  `req_area` VARCHAR(45) NOT NULL,
  `req_pincode` INT NOT NULL,
  PRIMARY KEY (`req_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`hospital` (
  `hp_id` INT NOT NULL AUTO_INCREMENT,
  `hp_state` VARCHAR(45) NOT NULL,
  `hp_area` VARCHAR(45) NOT NULL,
  `hp_pincode` INT NOT NULL,
  `hp_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`hp_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_firstname` VARCHAR(50) NOT NULL,
  `us_lastname` VARCHAR(50) NOT NULL,
  `us_age` INT NOT NULL,
  `us_gender` VARCHAR(10) NOT NULL,
  `us_contactnumber` VARCHAR(10) NOT NULL,
  `us_email` VARCHAR(45) NOT NULL,
  `us_password` VARCHAR(250) NOT NULL,
  `us_weight` INT NOT NULL,
  `us_bloodgroup` VARCHAR(5) NOT NULL,
  `us_state` VARCHAR(45) NOT NULL,
  `us_area` VARCHAR(45) NOT NULL,
  `us_pincode` INT NOT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `online_blood_bank`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_blood_bank`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT,
  `ur_us_id_fk` INT NOT NULL,
  `ur_ro_id_fk` INT NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `ur_us_id_fk_idx` (`ur_us_id_fk` ASC) VISIBLE,
  INDEX `ur_ro_id_fk_idx` (`ur_ro_id_fk` ASC) VISIBLE,
  CONSTRAINT `ur_ro_id_fk`
    FOREIGN KEY (`ur_ro_id_fk`)
    REFERENCES `online_blood_bank`.`role` (`ro_id`),
  CONSTRAINT `ur_us_id_fk`
    FOREIGN KEY (`ur_us_id_fk`)
    REFERENCES `online_blood_bank`.`user` (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
