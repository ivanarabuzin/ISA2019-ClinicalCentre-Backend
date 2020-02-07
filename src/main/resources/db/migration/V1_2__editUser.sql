ALTER TABLE `user`
ADD COLUMN `registration_confirmed` varchar(255) NOT NULL,
ADD COLUMN `admin_registration_confirmed` bit(1) NOT NULL DEFAULT 0,
ADD COLUMN `registration_token` varchar(255),
ADD COLUMN `address` varchar(255) NOT NULL,
ADD COLUMN `city` varchar(255) NOT NULL,
ADD COLUMN `country` varchar(255) NOT NULL,
ADD COLUMN `phone_number` varchar(255) NOT NULL,
ADD COLUMN `jbo` varchar(255) NOT NULL,
ADD COLUMN `deleted` bit(1) NOT NULL;

INSERT INTO `user` (`id`, `email`, `password`, `admin_registration_confirmed`, `name`, `surname`, `registration_confirmed`, `role`, `deleted`, `date_created`, `date_deleted`, `date_updated`,
 `address`, `city`, `country`, `phone_number`, `jbo`, `clinic_id`) VALUES

('1', 'test1@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Ana', 'Mandic', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Jurišića 3', 'Novi Sad', 'Serbia', '+381213292411', '85697423654', NULL),

('2', 'test2@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Mika ', 'Mikic', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Fruškogorska 13a', 'Beograd', 'Serbia', '+3813333333333', '123456789', NULL),

('3', 'test3@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Dragan', 'Budakov', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Osmana Đikića 3', 'Beograd', 'Serbia', '+381113292411', '85239741236', '1'),

('4', 'test4@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Sanja', 'Bulatović', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Osmana Đikića 3', 'Beograd', 'Serbia', '+3813333333333', '9638596471296', '9'),

('5', 'aivanarabuzin.isa2019@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Iva', 'Ivić', 1, 'ADMIN', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Osmana Đikića 3', 'Beograd', 'Serbia', '+3813333333333', '8956321458', '1'),

('6', 'test5@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Jelena', 'Jelić', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Borkovačka 78', 'Niš', 'Serbia', '+3811833333333', '123456789', NULL),

('7', 'test6@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Vesna', 'Nikolić', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Danila Kiša 89', 'Kikinda', 'Serbia', '+3816333333333', '8879633214', NULL),

('8', 'test7@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Andrea', 'Peter', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Bulevar Zorana Đinđića 106a', 'Beograd', 'Serbia', '+381115633333', '998523456789', '2'),

('9', 'test8@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Igor', 'Tomas', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Bulevar Zorana Đinđića 14-24', 'Niš', 'Serbia', '+38118853777', '888521364793', '8'),

('10', 'test9@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Dimitrije', 'Jeremić', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Sabljarska 1', 'Kanjiža', 'Serbia', '+38124856933', '18523697445', '10'),

('11', 'test10@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Mila', 'Marić', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Drum bb', 'Novi Sad', 'Serbia', '+381218292411', '9632577746', NULL),

('12', 'test11@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Veljko', 'Petrović', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Pećka 22', 'Paraćin', 'Serbia', '+381353292411', '85697423654', NULL),

('13', 'test12@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Saška', 'Sić', 1, 'PATIENT', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Pavla Jurišića 19s', 'Novi Sad', 'Serbia', '+381213292411', '858852334', NULL),

('14', 'test13@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Dragana', 'Jovanović', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Bulevar Zorana Đinđića 106a', 'Beograd', 'Serbia', '+381115633333', '998523456789', '3'),

('15', 'test14@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Mirjana', 'Stojković', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Bulevar 106a', 'Beograd', 'Serbia', '+381115633333', '998523456789', '4'),

('16', 'test15@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Rastko', 'Ilić', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Zoran Đinđić 6', 'Beograd', 'Serbia', '+381115633333', '998523456789', '2'),

('17', 'test16@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Saša', 'Cvetković', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Alekse Šantića 22', 'Beograd', 'Serbia', '+381115633333', '998523456789', '5'),

('18', 'test17@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Miroslav', 'Dinić', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Tolstojeva 89', 'Beograd', 'Serbia', '+381115633333', '998523456789', '6'),

('19', 'test18@gmail.com', '$2a$10$gDqfRHdeFeiopzJ3MSNiLOdYsTDU/RJWhTr5OJvGHE3355C5OLDDm', 1, 'Goran', 'Cvijović', 1, 'DOCTOR', 0, '2011-11-11 00:00:00','2011-11-11 00:00:00',
'2011-11-11 00:00:00', 'Miše Dimitrijevića 6', 'Beograd', 'Serbia', '+381115633333', '998523456789', '7');

