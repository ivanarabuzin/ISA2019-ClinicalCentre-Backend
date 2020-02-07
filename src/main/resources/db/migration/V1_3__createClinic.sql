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
('1', 'Atlas', 'Osmana Đikića 3', 'Opšta bolnica', 'Beograd', '0113292411', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('2', 'Alfa medica', 'Bulevar Zorana Đinđića 106a', 'Poliklinika', 'Beograd', '0113118591', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('3', 'Euromedik poliklinka', 'Alekse Nenadovića 7, Slavija', 'Poliklinika', 'Beograd', '0118569377', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('4', 'Consilium', 'Vršačka 21', 'Poliklinika', 'Novi Sad', '021426488', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('5', 'Eliksir', 'Marodićeva 12', 'Specijalna oftalmološka bolnica', 'Novi Sad', '021444716', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('6', 'Healthmedic', 'Narodnog Fronta 73a', 'Poliklinika', 'Novi Sad', '0646453225', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('7', 'Novakov et al.', 'Svetosavska 7', 'Poliklinika', 'Novi Sad', '0213007659', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('8', 'Human', 'Bulevar Zorana Đinđića 14-24', 'Poliklinika', 'Niš', '018538889', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('9', 'Neuromedic plus', 'Jeronimova 19', 'Specijalistička neuropsihijatrijska ordinacija', 'Niš', '018249249', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('10', 'Karh poliklinika', 'Sabljarska 1', 'Poliklinika', 'Kanjiža', '024876454', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00'),
('11', 'Alba', 'Majora Marka 35', 'Poliklinika', 'Paraćin', '035570510', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00', '2011-11-11 00:00:00');
