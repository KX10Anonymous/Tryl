/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  J-ANONIMO
 * Created: Dec 2, 2022
 */

CREATE TABLE `tryldb`.`style` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `style_name` VARCHAR(50) NOT NULL,
  `average_price` DOUBLE NOT NULL,
  `description` VARCHAR(225) NOT NULL,
  `created` DATETIME GENERATED ALWAYS AS () VIRTUAL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `style_name_UNIQUE` (`style_name` ASC) VISIBLE);
