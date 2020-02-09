DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `description` varchar(255) NOT NULL,
  `patient_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_record_patient` (`patient_id`)
);

INSERT INTO `record` (`id`, `description`, `deleted`, `date_created`, `date_deleted`, `date_updated`, `patient_id`) VALUES
('1', 'Amebijaza kože', 0, '2020-01-11 00:00:00','2020-01-11 00:00:00', '2011-11-11 00:00:00', 1),
('2', 'Zapaljenje pluća', 0, '2020-01-15 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 2),
('3', 'Katarakta', 0, '2020-02-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 6),
('4', 'Šarlah', 0, '2020-01-25 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 7),
('5', 'Latentna frambezija', 0, '2020-01-19 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 11),
('6', 'Psorijaza', 0, '2020-01-07 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 12),
('7', 'Karcinom', 0, '2020-02-05 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 13),
('8', 'Bolest kože', 0, '2020-01-12 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 2),
('9', 'Velike boginje', 0, '2020-01-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1);