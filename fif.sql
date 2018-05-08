SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `FIFA` DEFAULT CHARACTER SET utf8 ;
USE `FIFA` ;

-- -----------------------------------------------------
-- Table `FIFA`.`liga`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `FIFA`.`liga` (
  `id_liga` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `pais` VARCHAR(20) NULL DEFAULT NULL ,
  `temporada` VARCHAR(20) NULL DEFAULT NULL ,
  `logo` LONGBLOB NULL ,
  PRIMARY KEY (`id_liga`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FIFA`.`equipo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `FIFA`.`equipo` (
  `id_equipo` INT NOT NULL AUTO_INCREMENT ,
  `id_liga` INT NOT NULL ,
  `nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `fecha_fundacion` DATE NULL DEFAULT NULL ,
  `puntos` INT NULL DEFAULT NULL ,
  `escudo` LONGBLOB NULL ,
  PRIMARY KEY (`id_equipo`) ,
  INDEX `fk_equipo_liga_idx` (`id_liga` ASC) ,
  CONSTRAINT `fk_equipo_liga`
    FOREIGN KEY (`id_liga` )
    REFERENCES `FIFA`.`liga` (`id_liga` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FIFA`.`miembros`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `FIFA`.`miembros` (
  `id_miembro` INT NOT NULL AUTO_INCREMENT ,
  `id_equipo` INT NOT NULL ,
  `nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `apellido` VARCHAR(20) NULL DEFAULT NULL ,
  `puesto` VARCHAR(20) NULL DEFAULT NULL ,
  `foto` LONGBLOB NULL ,
  PRIMARY KEY (`id_miembro`) ,
  INDEX `fk_miembros_equipo1_idx` (`id_equipo` ASC) ,
  CONSTRAINT `fk_miembros_equipo1`
    FOREIGN KEY (`id_equipo` )
    REFERENCES `FIFA`.`equipo` (`id_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FIFA`.`partido`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `FIFA`.`partido` (
  `id_partido` INT NOT NULL AUTO_INCREMENT ,
  `jornada` INT NULL DEFAULT NULL ,
  `fecha` DATE NULL DEFAULT NULL ,
  `estadio` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_partido`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FIFA`.`detalle_partido`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `FIFA`.`detalle_partido` (
  `id_partido` INT NOT NULL ,
  `id_equipo` INT NOT NULL ,
  `goles` INT NULL DEFAULT NULL ,
  `amarillas` INT NULL DEFAULT NULL ,
  `rojas` INT NULL DEFAULT NULL ,
  INDEX `fk_partido_has_equipo_equipo1_idx` (`id_equipo` ASC) ,
  INDEX `fk_partido_has_equipo_partido1_idx` (`id_partido` ASC) ,
  CONSTRAINT `fk_partido_has_equipo_partido1`
    FOREIGN KEY (`id_partido` )
    REFERENCES `FIFA`.`partido` (`id_partido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partido_has_equipo_equipo1`
    FOREIGN KEY (`id_equipo` )
    REFERENCES `FIFA`.`equipo` (`id_equipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `FIFA` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
