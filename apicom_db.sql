-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 14-01-2018 a las 14:43:53
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
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  `sales_check` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_base`
--

INSERT INTO `apicom_base` (`id`, `id_user`, `date`, `name`, `sales_check`) VALUES
(1, 1, '2018-01-04 00:00:00', 'test_name', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_client`
--

CREATE TABLE `apicom_client` (
  `id` int(11) NOT NULL,
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
(1, 'test', '2018-01-10 05:14:14', 1, 'trading test', '123123', 'test@test.com', '11.111.111-1', 'test adress'),
(2, 'client_2', '2018-01-10 00:00:00', 1, '8786453', '12312353', 'client@test2.cl', '19272546-0', 'direccion test');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_detail`
--

CREATE TABLE `apicom_detail` (
  `id` int(11) NOT NULL,
  `id_manufacture` int(11) NOT NULL,
  `id_pair` int(11) NOT NULL,
  `estate` tinyint(1) NOT NULL,
  `estate_date` datetime NOT NULL,
  `despair_date` datetime NOT NULL,
  `ingress_date` datetime NOT NULL,
  `id_lista` int(11) NOT NULL,
  `id_base` int(11) NOT NULL,
  `iata` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_detail`
--

INSERT INTO `apicom_detail` (`id`, `id_manufacture`, `id_pair`, `estate`, `estate_date`, `despair_date`, `ingress_date`, `id_lista`, `id_base`, `iata`) VALUES
(1, 2, 123, 1, '2018-01-04 00:00:00', '2018-01-10 00:00:00', '2018-01-10 00:00:00', 2, 1, 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_gps`
--

CREATE TABLE `apicom_gps` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_gps`
--

INSERT INTO `apicom_gps` (`id`, `latitude`, `longitude`, `id_user`) VALUES
(1, -3322, 343, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_list`
--

CREATE TABLE `apicom_list` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `price` int(20) NOT NULL,
  `list_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_list`
--

INSERT INTO `apicom_list` (`id`, `id_user`, `price`, `list_date`) VALUES
(2, 1, 123123, '2018-01-18 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_logs`
--

CREATE TABLE `apicom_logs` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
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
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(300) NOT NULL,
  `id_type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_manufacture`
--

INSERT INTO `apicom_manufacture` (`id`, `name`, `description`, `id_type`) VALUES
(2, 'caja', 'cajatest', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_client_sector`
--

CREATE TABLE `apicom_price_client_sector` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_manufacture` int(11) NOT NULL,
  `id_sector` int(11) NOT NULL,
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
  `id` int(11) NOT NULL,
  `id_sector` int(11) NOT NULL,
  `id_manufacture` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_price_manuf_sector`
--

INSERT INTO `apicom_price_manuf_sector` (`id`, `id_sector`, `id_manufacture`, `price`, `active`) VALUES
(1, 1, 2, 123345, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_sector`
--

CREATE TABLE `apicom_sector` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `delimitation` text NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_sector`
--

INSERT INTO `apicom_sector` (`id`, `name`, `delimitation`, `active`) VALUES
(1, 'nametest', 'description test', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_type_manufacture`
--

CREATE TABLE `apicom_type_manufacture` (
  `id` int(11) NOT NULL,
  `description` text NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_type_manufacture`
--

INSERT INTO `apicom_type_manufacture` (`id`, `description`, `active`) VALUES
(1, 'fragil', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_users`
--

CREATE TABLE `apicom_users` (
  `id` int(11) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `password` varchar(15) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_change_date` datetime DEFAULT NULL,
  `mail` varchar(100) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `id_client` int(11) NOT NULL,
  `profile` int(11) NOT NULL,
  `payment_status` tinyint(1) NOT NULL,
  `payment_type` int(11) NOT NULL,
  `patente_vehiculo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_users`
--

INSERT INTO `apicom_users` (`id`, `user_name`, `user`, `password`, `creation_date`, `last_change_date`, `mail`, `active`, `id_client`, `profile`, `payment_status`, `payment_type`, `patente_vehiculo`) VALUES
(1, 'test_user_name', 'test_user', 'test_pass', '2018-01-17 08:20:10', NULL, 'test@test.com', 1, 1, 5, 0, 0, ''),
(2, 'test_username', 'test_user2', 'test_pass2', '2018-01-17 00:00:00', '2018-01-03 00:00:00', 'test@testtest.cl', 1, 1, 2, 1, 5, 'hd-fd-gd'),
(3, 'nombre cliente2', 'userclien2', 'passclient2', '2018-01-03 00:00:00', '2018-01-01 00:00:00', 'mail@client2.cl1', 1, 2, 5, 5, 6, 'hg-gt-ww'),
(4, 'nombre user5', 'user5', 'user5pass', '2018-01-03 00:00:00', NULL, 'lient5@test.cl', 1, 2, 5, 1, 4, 'gf-hg-dc');

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
-- Indices de la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_user_2` (`id_user`),
  ADD KEY `id_user_3` (`id_user`);

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
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_client_2` (`id_client`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apicom_base`
--
ALTER TABLE `apicom_base`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_client`
--
ALTER TABLE `apicom_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_logs`
--
ALTER TABLE `apicom_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_sector`
--
ALTER TABLE `apicom_sector`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_type_manufacture`
--
ALTER TABLE `apicom_type_manufacture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  ADD CONSTRAINT `apicom_detail_ibfk_1` FOREIGN KEY (`id_base`) REFERENCES `apicom_base` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_detail_ibfk_2` FOREIGN KEY (`id_lista`) REFERENCES `apicom_list` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_detail_ibfk_3` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_gps`
--
ALTER TABLE `apicom_gps`
  ADD CONSTRAINT `apicom_gps_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `apicom_users` (`id`) ON UPDATE CASCADE;

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
-- Filtros para la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  ADD CONSTRAINT `apicom_price_client_sector_ibfk_1` FOREIGN KEY (`id_sector`) REFERENCES `apicom_sector` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_price_client_sector_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `apicom_client` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_price_client_sector_ibfk_3` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  ADD CONSTRAINT `apicom_price_manuf_sector_ibfk_1` FOREIGN KEY (`id_manufacture`) REFERENCES `apicom_manufacture` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `apicom_price_manuf_sector_ibfk_2` FOREIGN KEY (`id_sector`) REFERENCES `apicom_sector` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  ADD CONSTRAINT `apicom_users_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `apicom_client` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
