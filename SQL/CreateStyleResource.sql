/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  J-ANONIMO
 * Created: Dec 2, 2022
 */

CREATE TABLE `tryldb`.`styleresource` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `appointment_id` VARCHAR(45) NOT NULL,
  `url` VARCHAR(260) NOT NULL,
  `created` TIMESTAMP GENERATED ALWAYS AS (),
  `style_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `StyleFK_idx` (`style_id` ASC) VISIBLE,
  CONSTRAINT `StyleFK`
    FOREIGN KEY (`style_id`)
    REFERENCES `tryldb`.`styles` (`style_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
