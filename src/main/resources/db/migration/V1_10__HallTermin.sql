DROP TABLE IF EXISTS `hall_termin`;

CREATE TABLE `hall_termin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  `deleted` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
  `free` bit(1) NOT NULL,
  `hall_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_termin_hall` (`hall_id`)
  );

INSERT INTO `hall_termin` (`id`, `date`, `time`,  `free`, `hall_id`, `deleted`, `date_created`, `date_deleted`, `date_updated`) values
('1', '2020-03-03 17:00:00', '17:00', 1, 1, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', '2020-03-03 18:00:00', '18:00', 1, 2, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', '2020-03-03 19:00:00', '19:00',1, 3,  0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');