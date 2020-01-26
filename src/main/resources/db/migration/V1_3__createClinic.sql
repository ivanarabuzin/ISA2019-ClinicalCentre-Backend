DROP TABLE IF EXISTS `clinic`;

CREATE TABLE `clinic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `clinic` (`id`, `name`, `address`, `description`, `city`, `phone_number`, `deleted`, `date_created`, `date_deleted`, `date_updated`) VALUES
('1', 'Clinic 1', 'Clinic address 1', 'Description 1', 'City 1', '123456789', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', 'Clinic 2', 'Clinic address 2', 'Description 2', 'City 2', '123456789', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', 'Clinic 3', 'Clinic address 3', 'Description 3', 'City 3', '123456789', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');