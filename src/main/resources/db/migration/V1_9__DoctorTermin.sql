DROP TABLE IF EXISTS `doctor_termin`;

CREATE TABLE `doctor_termin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `deleted` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
  `free` bit(1) NOT NULL,
  `doctor_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_termin_type` (`type_id`),
  KEY `FK_doctor_type` (`doctor_id`)
  );

INSERT INTO `doctor_termin` (`id`, `date`, `time`,  `free`, `doctor_id`, `type_id`, `deleted`, `price`, `date_created`, `date_deleted`, `date_updated`) values
('1', '2020-03-03 17:00:00', '17:00', 1, 3, 1, 0, 105,'2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', '2020-03-03 18:00:00', '18:00', 1, 3, 2, 0, 95, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', '2020-03-03 19:00:00', '19:00',1, 4,  3, 0, 98, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');