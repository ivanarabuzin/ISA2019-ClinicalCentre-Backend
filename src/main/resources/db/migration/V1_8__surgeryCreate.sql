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
('1', 'Type 1', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', 'Type 2', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', 'Type 2', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');

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
    `patient_id` bigint(20) DEFAULT NULL,
    `hall_id` bigint(20) NOT NULL,
    `doctor_id` bigint(20) NOT NULL,
    `clinic_id` bigint(20) NOT NULL,
    `type_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_app_patient` (`patient_id`),
    KEY `FK_app_type` (`type_id`),
    KEY `FK_app_hall` (`hall_id`),
    KEY `FK_doctor_patient` (`doctor_id`),
    KEY `FK_clinic_patient` (`clinic_id`)
);

INSERT INTO `appointment` (`id`, `date`, `type_id`, `description`, `price`, `is_taken`, `deleted`, `date_created`, `date_deleted`, `date_updated`, `clinic_id`, `patient_id`, `hall_id`, `doctor_id`) VALUES
('1', '2020-05-01 12:20:00', 1, '', 150, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, NULL, 1, 3),
('2', '2020-05-01 13:40:00', 2, '', 157, 0, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, NULL, 2, 3),
('3', '2020-05-01 15:00:00', 3, 'Very sick', 200, 1, 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, 1, 3, 4);