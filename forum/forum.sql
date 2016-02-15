SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `forum` DEFAULT CHARACTER SET latin1 ;
USE `forum` ;

-- -----------------------------------------------------
-- Table `forum`.`topico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`topico` (
  `idtopico` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `mensagem` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `data_criacao` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idtopico`),
  UNIQUE INDEX `idtopico_UNIQUE` (`idtopico` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `forum`.`resposta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`resposta` (
  `idresposta` INT(11) NOT NULL AUTO_INCREMENT,
  `autor` VARCHAR(255) NOT NULL,
  `mensagem` VARCHAR(255) NOT NULL,
  `idtopicofk` INT(11) NOT NULL,
  `data_criacao` BIGINT(20) NOT NULL,
  PRIMARY KEY (`idresposta`),
  INDEX `FK_qevjbm6u4a7ix8a458om21tm3` (`idtopicofk` ASC),
  CONSTRAINT `FK_qevjbm6u4a7ix8a458om21tm3`
    FOREIGN KEY (`idtopicofk`)
    REFERENCES `forum`.`topico` (`idtopico`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
