-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-02-2018 a las 13:40:40
-- Versión del servidor: 5.5.59-0ubuntu0.14.04.1
-- Versión de PHP: 5.5.9-1ubuntu4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `apicom_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_base`
--

CREATE TABLE IF NOT EXISTS `apicom_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `sales_check` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_user_2` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `apicom_base`
--

INSERT INTO `apicom_base` (`id`, `id_user`, `date`, `name`, `sales_check`) VALUES
(6, 153, '2018-02-06 00:00:00', 'BaseName', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_client`
--

CREATE TABLE IF NOT EXISTS `apicom_client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `creation_date` datetime NOT NULL,
  `active` tinyint(1) NOT NULL,
  `contact` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `rut` varchar(15) NOT NULL,
  `adress` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `apicom_client`
--

INSERT INTO `apicom_client` (`id`, `name`, `creation_date`, `active`, `contact`, `phone`, `mail`, `rut`, `adress`) VALUES
(10, 'Alimentos MasterDog', '2018-02-06 00:00:00', 1, 'Daniel Pedreros', '986278163', 'contacto@masterdog.cl', '15.331.553-6', 'Eliodoro Yañez 2416, Providencia, Región Metropolitana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_comunas`
--

CREATE TABLE IF NOT EXISTS `apicom_comunas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comuna` varchar(30) NOT NULL,
  `dir` tinyint(4) NOT NULL,
  `zona` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `apicom_comunas`
--

INSERT INTO `apicom_comunas` (`id`, `comuna`, `dir`, `zona`) VALUES
(1, 'Providencia', 1, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_detail`
--

CREATE TABLE IF NOT EXISTS `apicom_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `receptor` varchar(50) NOT NULL,
  `destinatario` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_manufacture` (`id_manufacture`),
  KEY `id_lista` (`id_lista`),
  KEY `id_base` (`id_base`),
  KEY `id_sector` (`id_sector`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Volcado de datos para la tabla `apicom_detail`
--

INSERT INTO `apicom_detail` (`id`, `id_manufacture`, `id_pair`, `estate`, `estate_date`, `despair_date`, `ingress_date`, `id_lista`, `id_base`, `iata`, `id_sector`, `id_repeat`, `adress`, `latitude`, `longitude`, `comment`, `receptor`, `destinatario`) VALUES
(8, 4, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 1, 'El Vergel 2282', -33.432919, -70.604002, '', 'Aurelio González', 'Jorge Gaete'),
(9, 5, 0, 8, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 1, 'El Vergel 2282', -33.432919, -70.604002, '', '', 'Felipe Sanchez'),
(10, 6, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 1, 'El Vergel 2282', -33.432919, -70.604002, '', '', 'Marta Donoso'),
(11, 7, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 2, 'Av. Ricardo Lyon 1601, Providencia, Región Metropolitana', -33.435713, -70.604729, '', 'Juan ', 'Cristina Martinez'),
(12, 7, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 3, 'Austria 2163, Santiago, Providencia, Región Metropolitana', -33.434632, -70.605437, '', '', 'Raul Castro'),
(13, 7, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 4, 'California 2238, Providencia, Santiago, Región Metropolitana\r\n', -33.43625, -70.603638, '', '', 'Jorge Fuentes'),
(14, 7, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 5, 'Llewellyn Jones 1530, P4 Dp 402, Providencia, Santiago, Región Metropolitana\r\n', -33.433786, -70.600614, '', '', ''),
(15, 7, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 6, 'Suecia 1280, Providencia, Región Metropolitana\r\n', -33.431855, -70.603938, '', '', ''),
(16, 7, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 7, 'Av. Holanda 1340 Providencia, Región Metropolitana\r\n', -33.431049, -70.600266, '', 'Juan Perez', ''),
(17, 7, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 8, 'Kinetex Inversiones Pocuro 2462, 405, Providencia, Santiago, Región Metropolitana\r\n', -33.434106, -70.600535, '', '', ''),
(18, 7, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 23763874, 3, 9, 'Av. Ricardo Lyon 1261, Providencia, Santiago, Región Metropolitana\r\n', -33.432984, -70.606419, '', 'tom', ''),
(20, 6, 0, 0, '2018-02-05 13:00:00', '2018-02-06 00:00:00', '2018-02-05 00:00:00', 15, 6, 123123, 5, 10, 'Los Zorzales 801-949 Maipú, Región Metropolitana', -33.52104, -70.777423, 'Producto fragil', '', ''),
(21, 7, 0, 1, '2018-02-06 11:00:00', '2018-02-06 07:00:00', '2018-02-05 10:00:00', 15, 6, 123123, 6, 11, 'San José 47 Maipú, Región Metropolitana', -33.514074, -70.757891, 'Producto fragil', '', ''),
(22, 7, 0, 1, '2018-02-06 00:00:00', '2018-02-06 12:21:10', '2018-02-05 00:00:00', 15, 6, 123123, 5, 12, 'Juan Antonio Ovalle 221-241 Maipú, Región Metropolitana', -33.515053, -70.754707, 'Producto pesado', '', ''),
(23, 7, 0, 0, '2018-02-06 09:00:00', '2018-02-06 13:00:00', '2018-02-05 00:00:00', 15, 6, 123123, 4, 13, 'Av. Italia 1293-1527 Providencia, Región Metropolitana', -33.448387, -70.624094, 'Producto pesado', '', ''),
(24, 6, 0, 0, '2018-02-06 00:00:00', '2018-02-06 10:00:00', '2018-02-05 11:00:00', 15, 6, 123123, 3, 14, 'Eusebio Lillo 501-573 Recoleta, Región Metropolitana', -33.428673, -70.645509, 'Producto liviano', '', ''),
(25, 6, 0, 0, '2018-02-06 00:00:00', '2018-02-06 08:00:00', '2018-02-05 05:00:00', 15, 6, 123123, 4, 15, 'La Paz 548-500 Recoleta, Región Metropolitana', -33.42493, -70.651217, 'Producto fragil', '', ''),
(26, 5, 0, 0, '2018-02-06 00:00:00', '2018-02-06 07:00:00', '2018-02-06 06:00:00', 15, 6, 123123, 4, 16, 'Arzobispo Vicuña 29-59 Providencia, Región Metropolitana', -33.438022, -70.629803, 'Producto Grande', '', ''),
(27, 6, 0, 0, '2018-02-06 10:00:00', '2018-02-06 10:00:00', '2018-02-05 00:00:00', 15, 6, 123123, 4, 17, 'Gral José Artigas 3250 Ñuñoa, Región Metropolitana', -33.447798, -70.597574, 'Producto pequeño', '', ''),
(28, 8, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 123123, 5, 17, 'Gral José Artigas 3250 Ñuñoa, Región Metropolitana', -33.447798, -70.597574, 'Producto grande', '', ''),
(29, 5, 0, 0, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 123123, 5, 18, 'Bernarda Morin 337-459 Providencia, Región Metropolitana', -33.437926, -70.627094, 'Producto grande', '', ''),
(30, 6, 0, 1, '2018-02-06 00:00:00', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 15, 6, 123123, 4, 18, 'Bernarda Morin 337-459 Providencia, Región Metropolitana', -33.437926, -70.627094, 'Producto pequeño', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_emergency`
--

CREATE TABLE IF NOT EXISTS `apicom_emergency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=66 ;

--
-- Volcado de datos para la tabla `apicom_emergency`
--

INSERT INTO `apicom_emergency` (`id`, `id_user`, `type`, `description`, `date`) VALUES
(65, 152, 'Choque', 'me cai', '2018-02-06 14:56:05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_gps`
--

CREATE TABLE IF NOT EXISTS `apicom_gps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_user_2` (`id_user`),
  KEY `id_user_3` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_gps_last`
--

CREATE TABLE IF NOT EXISTS `apicom_gps_last` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `apicom_gps_last`
--

INSERT INTO `apicom_gps_last` (`id`, `latitude`, `longitude`, `id_user`) VALUES
(5, -33.4543436, -70.57977, 152);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_ground`
--

CREATE TABLE IF NOT EXISTS `apicom_ground` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estate` varchar(20) NOT NULL,
  `mobility` varchar(20) NOT NULL,
  `patente` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_list`
--

CREATE TABLE IF NOT EXISTS `apicom_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `price` int(20) NOT NULL,
  `list_date` datetime NOT NULL,
  `active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_user_2` (`id_user`),
  KEY `id_user_3` (`id_user`),
  KEY `id_user_4` (`id_user`),
  KEY `id_user_5` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `apicom_list`
--

INSERT INTO `apicom_list` (`id`, `id_user`, `price`, `list_date`, `active`) VALUES
(15, 152, 0, '2018-02-16 00:00:00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_logs`
--

CREATE TABLE IF NOT EXISTS `apicom_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `action` varchar(20) NOT NULL,
  `ip` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_user_2` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_manufacture`
--

CREATE TABLE IF NOT EXISTS `apicom_manufacture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(300) NOT NULL,
  `id_type` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_type` (`id_type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `apicom_manufacture`
--

INSERT INTO `apicom_manufacture` (`id`, `name`, `description`, `id_type`) VALUES
(4, 'Comida de gato', 'Saco de 20kg, marca acuenta', 5),
(5, 'Carta de invitacion', 'Carta 10cm x 20cm', 4),
(6, 'Saco de comida de perro', 'Saco con 20kg de comida de perro marca acuenta', 5),
(7, 'Lata de comida de perro', 'Lata con 300gr de comida de perro marca acuenta', 5),
(8, 'Lata de comida de gato', 'Lata con 300gr de comida de gato marca acuenta', 5),
(9, 'Carta de cobro', 'Carta de 10cm x 25 cm', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_client_sector`
--

CREATE TABLE IF NOT EXISTS `apicom_price_client_sector` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_cliente` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_product` (`id_manufacture`),
  KEY `id_sector` (`id_sector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_manuf_sector`
--

CREATE TABLE IF NOT EXISTS `apicom_price_manuf_sector` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_sector` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `price` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sector` (`id_sector`),
  KEY `id_manufacture` (`id_manufacture`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Volcado de datos para la tabla `apicom_price_manuf_sector`
--

INSERT INTO `apicom_price_manuf_sector` (`id`, `id_sector`, `id_manufacture`, `price`, `active`) VALUES
(11, 3, 4, 3990, 1),
(12, 3, 5, 3950, 1),
(13, 3, 6, 4100, 1),
(14, 3, 7, 4125, 1),
(15, 3, 8, 3870, 1),
(16, 3, 9, 3890, 1),
(17, 4, 4, 4270, 1),
(18, 4, 5, 4500, 1),
(19, 4, 6, 4750, 1),
(20, 4, 7, 4570, 1),
(21, 4, 8, 4503, 1),
(22, 4, 9, 4760, 1),
(23, 5, 4, 4670, 1),
(24, 5, 5, 4630, 1),
(25, 5, 6, 3790, 1),
(26, 5, 7, 3990, 1),
(27, 5, 8, 4550, 1),
(28, 5, 9, 4690, 1),
(29, 6, 4, 3790, 1),
(30, 6, 5, 4440, 1),
(31, 6, 6, 4850, 1),
(32, 6, 7, 5140, 1),
(33, 6, 8, 4750, 1),
(34, 6, 9, 4950, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_profile`
--

CREATE TABLE IF NOT EXISTS `apicom_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `apicom_profile`
--

INSERT INTO `apicom_profile` (`id`, `description`) VALUES
(1, 'Administrativo'),
(2, 'Distribuidor'),
(3, 'Operario'),
(4, 'Contador'),
(5, 'Chofer'),
(6, 'Receptor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_sector`
--

CREATE TABLE IF NOT EXISTS `apicom_sector` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `delimitation` text NOT NULL,
  `verticeX` text NOT NULL,
  `verticeY` text NOT NULL,
  `active` tinyint(1) NOT NULL,
  `id_comuna` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `apicom_sector`
--

INSERT INTO `apicom_sector` (`id`, `name`, `delimitation`, `verticeX`, `verticeY`, `active`, `id_comuna`) VALUES
(3, 'Ñuñoa 1', '', '', '', 1, 1),
(4, 'Ñuñoa 2', '', '', '', 1, 1),
(5, 'Maipú 1', '', '', '', 1, 2),
(6, 'Maipú 2', '', '', '', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_type_manufacture`
--

CREATE TABLE IF NOT EXISTS `apicom_type_manufacture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `apicom_type_manufacture`
--

INSERT INTO `apicom_type_manufacture` (`id`, `description`, `active`) VALUES
(4, 'carta', 1),
(5, 'paquete', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_users`
--

CREATE TABLE IF NOT EXISTS `apicom_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
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
  `patente_vehiculo` varchar(15) NOT NULL,
  `id_ground` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user` (`user`),
  KEY `id_client` (`id_client`),
  KEY `id_client_2` (`id_client`),
  KEY `id_profile` (`id_profile`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=154 ;

--
-- Volcado de datos para la tabla `apicom_users`
--

INSERT INTO `apicom_users` (`id`, `user_name`, `user`, `password`, `creation_date`, `last_change_date`, `mail`, `active`, `id_client`, `id_profile`, `payment_status`, `payment_type`, `patente_vehiculo`, `id_ground`) VALUES
(152, 'Matías Gómez', 'matias.gomeza', '123456', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 'matias.gomeza@usach.cl', 1, 10, 5, 0, '1', 'CH-KS-32', 1),
(153, 'José Carmona', 'jose.carmona', '123456', '2018-02-06 00:00:00', '2018-02-06 00:00:00', 'jose.carmona@gmail.com', 1, 10, 6, 0, '0', '0', 0);

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
  ADD CONSTRAINT `apicom_detail_ibfk_2` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_detail_ibfk_3` FOREIGN KEY (`id_sector`) REFERENCES `apicom_sector` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_detail_ibfk_4` FOREIGN KEY (`id_base`) REFERENCES `apicom_base` (`id`) ON UPDATE CASCADE;

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
