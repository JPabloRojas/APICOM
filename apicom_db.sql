-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-01-2018 a las 15:41:36
-- Versión del servidor: 5.7.20-0ubuntu0.16.04.1
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apicom_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_base`
--

CREATE TABLE `apicom_base` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `sales_check` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_base`
--

INSERT INTO `apicom_base` (`id`, `id_user`, `date`, `name`, `sales_check`) VALUES
(1, 1, '2018-01-04 00:00:00', 'test_name', 0),
(2, 20, '2018-01-25 00:00:00', 'basetest', 1),
(3, 28, '2018-01-25 00:00:00', 'basetestbasetest', 0),
(4, 1, '2018-01-26 00:00:00', 'asdas', 1),
(5, 76, '2018-01-26 00:00:00', 'asdas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_client`
--

CREATE TABLE `apicom_client` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creation_date` datetime NOT NULL,
  `active` tinyint(1) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `rut` varchar(15) NOT NULL,
  `adress` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_client`
--

INSERT INTO `apicom_client` (`id`, `name`, `creation_date`, `active`, `contact`, `phone`, `mail`, `rut`, `adress`) VALUES
(1, 'test', '2018-01-10 05:14:14', 0, 'trading test', '123123', 'test@test.com', '11.111.111-1', 'test adress'),
(2, 'client_2', '2018-01-10 00:00:00', 1, '8786453', '12312353', 'client@test2.cl', '19272546-0', 'direccion test'),
(3, 'test', '2018-01-19 16:54:19', 1, 'contacttest', '+5693737', 'mail@mail.cl', '19237546-0', 'adresstest'),
(4, 'test', '2018-01-20 22:07:10', 1, 'contacttest', '+5693737', 'mail@mail.cl', '19237546-0', 'adresstest'),
(5, 'test12', '2018-01-20 22:07:14', 1, 'contacttest', '+5693737', 'mail@mail.cl', '19237546-0', 'adresstest');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_detail`
--

CREATE TABLE `apicom_detail` (
  `id` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `id_pair` bigint(20) NOT NULL,
  `estate` int(11) NOT NULL,
  `estate_date` datetime NOT NULL,
  `despair_date` datetime NOT NULL,
  `ingress_date` datetime NOT NULL,
  `id_lista` bigint(20) NOT NULL,
  `id_base` bigint(20) NOT NULL,
  `iata` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `id_repeat` int(11) NOT NULL,
  `adress` text NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `comment` text NOT NULL,
  `receptor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_detail`
--

INSERT INTO `apicom_detail` (`id`, `id_manufacture`, `id_pair`, `estate`, `estate_date`, `despair_date`, `ingress_date`, `id_lista`, `id_base`, `iata`, `id_sector`, `id_repeat`, `adress`, `latitude`, `longitude`, `comment`, `receptor`) VALUES
(1, 2, 123, 5, '2018-01-04 00:00:00', '2018-01-10 00:00:00', '2018-01-10 00:00:00', 2, 1, 1234, 1, 1, 'mi casa', 0, 0, 'Casa azul, reja blanca', ''),
(2, 2, 1, 1, '2018-01-10 00:00:00', '2018-01-12 00:00:00', '2018-01-17 00:00:00', 2, 2, 1234, 1, 1, 'mi casa', 0, 0, 'asdasd', ''),
(3, 2, 1, 1, '2018-01-17 00:00:00', '2018-01-04 00:00:00', '2018-01-03 00:00:00', 2, 3, 1, 2, 2, 'su casa', 0, 0, 'asdasd', ''),
(4, 2, 123, 1, '2018-01-15 00:00:00', '2018-01-24 00:00:00', '2018-01-21 00:00:00', 3, 4, 123123, 1, 0, '', 0, 0, 'asdasds', ''),
(5, 3, 123123, 1, '2018-01-24 00:00:00', '2018-01-24 11:00:00', '2018-01-24 06:00:00', 2, 5, 123123, 2, 2, 'su casa', 0, 0, 'asdasda', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_emergency`
--

CREATE TABLE `apicom_emergency` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_emergency`
--

INSERT INTO `apicom_emergency` (`id`, `id_user`, `type`, `description`, `date`) VALUES
(8, 105, 'Choque', 'Android apps are making the rounds these days. With popularity of Android based ', '1970-01-18 10:11:47'),
(9, 105, 'Choque', 'Android apps are making the rounds these days. With popularity of Android based ', '1970-01-18 10:11:48'),
(12, 1, 'choque', 'bla', '2018-12-11 21:00:00'),
(15, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(16, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(17, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(18, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(19, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(20, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(21, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(22, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(23, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(24, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(25, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(26, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(27, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(28, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(29, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45'),
(30, 1, 'Choque', 'Descripcion', '2018-01-17 14:42:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_gps`
--

CREATE TABLE `apicom_gps` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_gps`
--

INSERT INTO `apicom_gps` (`id`, `latitude`, `longitude`, `id_user`) VALUES
(1, 666, 666, 1),
(2, -756, 653, 1),
(3, -75.656, 65.643, 1),
(6, -75.656, 65.643, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_gps_last`
--

CREATE TABLE `apicom_gps_last` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_user` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_gps_last`
--

INSERT INTO `apicom_gps_last` (`id`, `latitude`, `longitude`, `id_user`) VALUES
(1, -34.7868114, -55.2337042, 1),
(3, -75.123, 65.213, 95),
(5, -34.7868114, -55.2337042, 105),
(7, -75.123, 65.213, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_list`
--

CREATE TABLE `apicom_list` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `price` int(20) NOT NULL,
  `list_date` datetime NOT NULL,
  `active` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_list`
--

INSERT INTO `apicom_list` (`id`, `id_user`, `price`, `list_date`, `active`) VALUES
(2, 1, 123123, '2018-01-18 00:00:00', 1),
(3, 95, 0, '2018-01-15 19:12:13', 1),
(5, 99, 0, '2018-01-15 20:24:25', 1),
(6, 99, 0, '2018-01-15 20:24:29', 1),
(7, 99, 0, '2018-01-15 20:24:30', 1),
(8, 99, 0, '2018-01-15 20:24:31', 1),
(9, 99, 0, '2018-01-15 20:24:32', 1),
(10, 99, 0, '2018-01-15 20:24:33', 1),
(11, 105, 0, '2018-01-15 20:25:38', 1),
(12, 105, 0, '2018-01-15 20:26:31', 1),
(13, 105, 0, '2018-01-17 12:39:29', 1),
(14, 1, 20000, '2018-01-25 00:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_logs`
--

CREATE TABLE `apicom_logs` (
  `id` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `action` varchar(20) NOT NULL,
  `ip` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_logs`
--

INSERT INTO `apicom_logs` (`id`, `id_user`, `date`, `action`, `ip`) VALUES
(1, 1, '2018-01-04 00:00:00', 'test_action', '192.168.0.1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_manufacture`
--

CREATE TABLE `apicom_manufacture` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(300) NOT NULL,
  `id_type` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_manufacture`
--

INSERT INTO `apicom_manufacture` (`id`, `name`, `description`, `id_type`) VALUES
(2, 'caja', 'cajatest', 1),
(3, 'paquete', 'test', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_client_sector`
--

CREATE TABLE `apicom_price_client_sector` (
  `id` bigint(20) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_price_client_sector`
--

INSERT INTO `apicom_price_client_sector` (`id`, `id_cliente`, `id_manufacture`, `id_sector`, `price`, `active`) VALUES
(2, 1, 2, 1, 56765, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_manuf_sector`
--

CREATE TABLE `apicom_price_manuf_sector` (
  `id` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_price_manuf_sector`
--

INSERT INTO `apicom_price_manuf_sector` (`id`, `id_sector`, `id_manufacture`, `price`, `active`) VALUES
(1, 1, 2, 1000, 1),
(9, 2, 2, 4000, 1),
(10, 2, 3, 2500, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_profile`
--

CREATE TABLE `apicom_profile` (
  `id` bigint(20) NOT NULL,
  `description` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_profile`
--

INSERT INTO `apicom_profile` (`id`, `description`) VALUES
(1, 'Administrativo'),
(2, 'Distribuidor'),
(3, 'Operario'),
(4, 'Contador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_sector`
--

CREATE TABLE `apicom_sector` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `delimitation` text NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_sector`
--

INSERT INTO `apicom_sector` (`id`, `name`, `delimitation`, `active`) VALUES
(1, 'nametest', 'description test', 1),
(2, 'sectora', 'asdas', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_type_manufacture`
--

CREATE TABLE `apicom_type_manufacture` (
  `id` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_type_manufacture`
--

INSERT INTO `apicom_type_manufacture` (`id`, `description`, `active`) VALUES
(1, 'fragil', 1),
(2, 'pesado', 1),
(3, 'grande', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_users`
--

CREATE TABLE `apicom_users` (
  `id` bigint(20) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(15) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_change_date` datetime DEFAULT NULL,
  `mail` varchar(100) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `id_client` bigint(20) NOT NULL,
  `id_profile` bigint(20) NOT NULL,
  `payment_status` tinyint(1) NOT NULL,
  `payment_type` varchar(20) NOT NULL,
  `patente_vehiculo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_users`
--

INSERT INTO `apicom_users` (`id`, `user_name`, `user`, `password`, `creation_date`, `last_change_date`, `mail`, `active`, `id_client`, `id_profile`, `payment_status`, `payment_type`, `patente_vehiculo`) VALUES
(1, 'a', 'test_user', 'test_pass', '2018-01-17 08:20:10', NULL, 'test@test.com', 1, 1, 1, 0, '0', ''),
(20, 'Juan Pablo Rojas', 'juan1234', 'pass1235', '2018-12-11 21:00:00', '2018-12-11 21:00:00', 'mailjuan@mail.mail', 1, 1, 1, 0, '5', 'npantente'),
(28, 'Juan Pablo Rojas', 'juansdf1234', 'passdfs1235', '2018-12-11 21:00:00', '2018-12-11 21:00:00', 'mailjuan@mail.mail', 1, 2, 2, 0, '5', 'npantente'),
(76, 'Juan Pablo Rojas', 'pass1', 'pass2', '2018-12-11 21:00:00', NULL, 'asdasd', 1, 1, 3, 0, '5', 'npantente'),
(95, 'Juan Pablo Rojas', 'user8', 'pass8', '2018-12-11 21:00:00', NULL, 'asdasd', 1, 1, 3, 0, '5', 'npantente'),
(99, 'Juan Pablo Rojas', 'user9', 'pass9', '2018-12-11 21:00:00', NULL, 'asdasd', 1, 1, 1, 0, '5', 'npantente'),
(105, 'Juan Pablo Rojas', 'user10', 'pass10', '2018-12-11 21:00:00', NULL, 'asdasd', 1, 1, 1, 0, '5', 'npantente'),
(109, 'Juan Pablo Rojas', 'user13', 'pass13', '2018-12-11 21:00:00', NULL, 'asdasd', 1, 1, 1, 0, '5', 'npantente'),
(111, 'Juan Pablo Rojas', 'user106', 'pass106', '2018-01-18 14:48:39', NULL, 'asdasd', 1, 2, 2, 0, 'chequera', 'npantente'),
(118, 'Sebastian Venegas', 'svenegas', 'svenegas', '2018-01-18 15:46:07', NULL, 'test@gmail.com', 1, 1, 1, 0, 'chequera', 'AA-BB-CC'),
(130, 'SebastianVenegas4', 'svenegas4', 'svenegas4', '2018-01-18 16:31:58', NULL, 'tesgmail.com', 1, 1, 3, 0, 'chequera', 'AA-BB-CC'),
(131, '"hola"', '"svenegaas2"', '"svenegas2"', '2018-01-18 16:33:26', NULL, '"tesgmail.com"', 1, 1, 3, 0, '"chequera"', '"AA-BB-CC"'),
(132, 'SebastianVenegas5', 'svenegas5', 'svenegas5', '2018-01-18 16:42:19', NULL, 'tesgmail.com', 1, 1, 2, 0, 'chequera', 'AA-BB-CC'),
(133, '"hola"', '"svenegaaas2"', '"svenegas2"', '2018-01-18 17:01:58', NULL, '"tesgmail.com"', 1, 1, 1, 0, '"chequera"', '"AA-BB-CC"'),
(134, '"hola"', '"svenegas7"', '"svenegas7"', '2018-01-18 17:05:33', NULL, '"tesgmail.com"', 1, 1, 1, 0, '"chequera"', '"AA-BB-CC"'),
(135, 'SebastianVenegass', 'svenegas6', 'svenegas6', '2018-01-18 17:06:15', '2018-01-21 17:42:20', 'testchange@gmail.com', 1, 2, 3, 0, 'boleta', 'AA-BB-C6'),
(136, 'SebastianVenegas7', 'svenegas7', 'svenegas7', '2018-01-18 17:06:58', '2018-01-20 22:10:51', 'testchange@gmail.com', 1, 1, 1, 0, 'boleta', 'AA-BB-CC'),
(137, 'Juan Pablo Rojas', 'jpablo1', 'jpablo1', '2018-01-20 22:14:10', NULL, 'mail@mail1.com', 1, 1, 1, 0, 'cheque', 'AA-BB-CC'),
(143, 'Sebastian Venegas', 'test', 'testtest', '2018-01-22 20:51:43', NULL, 'sebastianvenegas.t@gmail.com', 1, 1, 2, 0, 'Transferencia', 'AA-AA-00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apicom_base`
--
ALTER TABLE `apicom_base`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`);

--
-- Indices de la tabla `apicom_client`
--
ALTER TABLE `apicom_client`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_manufacture` (`id_manufacture`),
  ADD KEY `id_lista` (`id_lista`),
  ADD KEY `id_base` (`id_base`);

--
-- Indices de la tabla `apicom_emergency`
--
ALTER TABLE `apicom_emergency`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`),
  ADD KEY `id_user_3` (`id_user`);

--
-- Indices de la tabla `apicom_gps_last`
--
ALTER TABLE `apicom_gps_last`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`),
  ADD KEY `id_user_3` (`id_user`),
  ADD KEY `id_user_4` (`id_user`),
  ADD KEY `id_user_5` (`id_user`);

--
-- Indices de la tabla `apicom_logs`
--
ALTER TABLE `apicom_logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`);

--
-- Indices de la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_type` (`id_type`);

--
-- Indices de la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_cliente` (`id_cliente`),
  ADD KEY `id_product` (`id_manufacture`),
  ADD KEY `id_sector` (`id_sector`);

--
-- Indices de la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sector` (`id_sector`),
  ADD KEY `id_manufacture` (`id_manufacture`);

--
-- Indices de la tabla `apicom_profile`
--
ALTER TABLE `apicom_profile`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_sector`
--
ALTER TABLE `apicom_sector`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_type_manufacture`
--
ALTER TABLE `apicom_type_manufacture`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`user`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_client_2` (`id_client`),
  ADD KEY `id_profile` (`id_profile`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apicom_base`
--
ALTER TABLE `apicom_base`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `apicom_client`
--
ALTER TABLE `apicom_client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `apicom_emergency`
--
ALTER TABLE `apicom_emergency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `apicom_gps_last`
--
ALTER TABLE `apicom_gps_last`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `apicom_logs`
--
ALTER TABLE `apicom_logs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `apicom_profile`
--
ALTER TABLE `apicom_profile`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `apicom_sector`
--
ALTER TABLE `apicom_sector`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_type_manufacture`
--
ALTER TABLE `apicom_type_manufacture`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `apicom_base`
--
ALTER TABLE `apicom_base`
  ADD CONSTRAINT `apicom_base_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  ADD CONSTRAINT `apicom_detail_ibfk_1` FOREIGN KEY (`id_lista`) REFERENCES `apicom_list` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_detail_ibfk_2` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_emergency`
--
ALTER TABLE `apicom_emergency`
  ADD CONSTRAINT `apicom_emergency_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  ADD CONSTRAINT `apicom_gps_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_gps_last`
--
ALTER TABLE `apicom_gps_last`
  ADD CONSTRAINT `apicom_gps_last_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  ADD CONSTRAINT `apicom_list_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_logs`
--
ALTER TABLE `apicom_logs`
  ADD CONSTRAINT `apicom_logs_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  ADD CONSTRAINT `apicom_manufacture_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `apicom_type_manufacture` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  ADD CONSTRAINT `apicom_price_manuf_sector_ibfk_1` FOREIGN KEY (`id_sector`) REFERENCES `apicom_sector` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_price_manuf_sector_ibfk_2` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  ADD CONSTRAINT `apicom_users_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `apicom_client` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_users_ibfk_2` FOREIGN KEY (`id_profile`) REFERENCES `apicom_profile` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
