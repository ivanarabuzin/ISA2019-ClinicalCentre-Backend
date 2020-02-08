DROP TABLE IF EXISTS `appointment_type`;

CREATE TABLE `appointment_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
  );

INSERT INTO `appointment_type` (`id`, `name`, `deleted`, `date_created`, `date_deleted`, `date_updated`) values
('1', 'Opšti pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', 'Kardiološki pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', 'Ultrazvuk abdomena', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('4', 'Pulmološki pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('5', 'Pedijatrijski pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('6', 'Dermatološki pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('7', 'Ultrazvuk zglobova', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('8', 'Hirurški pregled', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');

DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
    `price` double NOT NULL,
    `description` varchar(255) NOT NULL,
    `is_taken` bit(1) NOT NULL,
    `admin_accepted` bit(1) DEFAULT 1,
    `patient_accepted` bit(1) DEFAULT 1,
    `patient_id` bigint(20) DEFAULT NULL,
    `hall_id` bigint(20),
    `doctor_id` bigint(20) NOT NULL,
    `clinic_id` bigint(20) NOT NULL,
    `type_id` bigint(20) NOT NULL,
    `termin_id` bigint(20) DEFAULT NULL,
    `hall_termin_id` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_app_patient` (`patient_id`),
    KEY `FK_app_type` (`type_id`),
    KEY `FK_app_hall` (`hall_id`),
    KEY `FK_doctor_patient` (`doctor_id`),
    KEY `FK_clinic_patient` (`clinic_id`),
    KEY `FK_termin_appointment` (`termin_id`),
    KEY `FK_hall_termin_appointment` (`hall_termin_id`)
);

INSERT INTO `appointment` (`id`, `date`, `type_id`, `description`, `price`, `is_taken`, `deleted`, `date_created`, `date_deleted`, `date_updated`, `clinic_id`, `patient_id`, `hall_id`, `doctor_id`) VALUES
('1', '2020-03-01 12:20:00', 1, 'Sepsa uzrokovana salmonelom', 150, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, NULL, 1, 3),
('2', '2020-03-08 13:40:00', 2, 'Zapaljenje tankog creva', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, NULL, 2, 3),
('3', '2020-03-10 15:00:00', 3, 'Amebijaza kože', 200, 1, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 2, 1, 3, 8),
('4', '2020-03-10 11:15:00', 4, 'Zapaljenje pluća', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 3, 2, 4, 14),
('5', '2020-03-15 15:40:00', 5, 'Katarakta', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 5, 6, 5, 17),
('6', '2020-03-22 07:40:00', 6, 'Šarlah', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 4, 7, 6, 15),
('7', '2020-03-15 09:15:00', 7, 'Bolest kože', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 6, NULL, 7, 18),
('8', '2020-03-06 17:30:00', 8, 'Velike boginje', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 7, NULL, 8, 19),
('9', '2020-03-13 17:50:00', 8, 'Latentna frambezija', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 8, 11, 9, 9),
('10', '2020-03-13 10:40:00', 7, 'Psorijaza', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 9, 12, 10, 4),
('11', '2020-03-13 13:00:00', 7, 'Karcinom', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 10, 13, 11, 10);