DROP TABLE IF EXISTS `surgery`;

CREATE TABLE `surgery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_created` datetime NOT NULL,
  `date_deleted` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `date` datetime DEFAULT NULL,
    `description` varchar(255) NOT NULL,
    `patient_id` bigint(20) DEFAULT NULL,
    `hall_id` bigint(20) NOT NULL,
    `doctor_id` bigint(20) NOT NULL,
    `clinic_id` bigint(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_app_patient` (`patient_id`),
    KEY `FK_app_hall` (`hall_id`),
    KEY `FK_doctor_patient` (`doctor_id`),
    KEY `FK_clinic_patient` (`clinic_id`)
);

INSERT INTO `surgery` (`id`, `date`, `description`, `deleted`, `date_created`, `date_deleted`, `date_updated`, `clinic_id`, `patient_id`, `hall_id`, `doctor_id`) VALUES
('1', '2020-05-01 12:20:00', 'Žali se na bolove u grudima.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 1, 2, 1, 3),
('2', '2020-05-01 13:40:00', 'Prelom noge.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 9, 12, 10, 4),
('3', '2020-05-01 13:40:00', 'Prehlada.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 2, 1, 3, 8),
('4', '2020-05-01 13:40:00', 'Gubi svest, ubrzano kucanje srca.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 8, 11, 9, 9),
('5', '2020-05-01 13:40:00', 'Ujed od pćele.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 10, 13, 11, 10),
('6', '2020-05-01 13:40:00', 'Povreda tokom udesa.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 3, 2, 4, 14),
('7', '2020-05-01 13:40:00', 'Uganuće noge i bolovi u zglobovima.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 4, 7, 6, 15),
('9', '2020-05-01 13:40:00', 'Povreda glave tokom fizičke aktivnosti.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 5, 6, 5, 17),
('10', '2020-05-01 13:40:00', 'Prelom ruke.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 6, 6, 7, 18),
('11', '2020-05-01 13:40:00', 'Virusna infekcija.', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00', 7, 13, 8, 19);

