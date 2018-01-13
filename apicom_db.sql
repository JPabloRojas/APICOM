-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-01-2018 a las 16:43:34
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
-- Estructura de tabla para la tabla `apicom_client`
--

CREATE TABLE `apicom_client` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `creation_date` datetime NOT NULL,
  `active` tinyint(1) NOT NULL,
  `trading_contact` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `rut` varchar(15) NOT NULL,
  `adress` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_client`
--

INSERT INTO `apicom_client` (`id`, `name`, `creation_date`, `active`, `trading_contact`, `phone`, `mail`, `rut`, `adress`) VALUES
(1, 'test', '2018-01-10 05:14:14', 1, 'trading test', '123123', 'test@test.com', '11.111.111-1', 'test adress');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_detail`
--

CREATE TABLE `apicom_detail` (
  `id` bigint(20) NOT NULL,
  `id_manufacture` bigint(20) NOT NULL,
  `id_list` bigint(20) NOT NULL,
  `estate` int(11) NOT NULL,
  `id_par` bigint(20) NOT NULL,
  `id_barcode` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_detail`
--

INSERT INTO `apicom_detail` (`id`, `id_manufacture`, `id_list`, `estate`, `id_par`, `id_barcode`) VALUES
(1, 123123, 123123, 1, 123123, '7373638123662h27132h');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_list`
--

CREATE TABLE `apicom_list` (
  `id` bigint(20) NOT NULL,
  `id_client` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  `price` bigint(20) NOT NULL,
  `list_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_list`
--

INSERT INTO `apicom_list` (`id`, `id_client`, `id_user`, `price`, `list_date`) VALUES
(1, 123123, 123132, 123123, '2018-01-11 05:29:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_manufacture`
--

CREATE TABLE `apicom_manufacture` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_client_sector`
--

CREATE TABLE `apicom_price_client_sector` (
  `id` bigint(20) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_price_manuf_sector`
--

CREATE TABLE `apicom_price_manuf_sector` (
  `id` bigint(20) NOT NULL,
  `id_sector` bigint(20) NOT NULL,
  `id_product` bigint(20) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_sectors`
--

CREATE TABLE `apicom_sectors` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `delimitation` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `apicom_users`
--

CREATE TABLE `apicom_users` (
  `id` bigint(20) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `creation_date` datetime NOT NULL,
  `last_change_date` datetime DEFAULT NULL,
  `mail` varchar(100) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `id_client` bigint(20) NOT NULL,
  `profile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `apicom_users`
--

INSERT INTO `apicom_users` (`id`, `user_name`, `user`, `creation_date`, `last_change_date`, `mail`, `active`, `id_client`, `profile`) VALUES
(1, 'test_user_name', 'test_user', '2018-01-17 08:20:10', NULL, 'test@test.com', 1, 1, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `apicom_client`
--
ALTER TABLE `apicom_client`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_sectors`
--
ALTER TABLE `apicom_sectors`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `apicom_client`
--
ALTER TABLE `apicom_client`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_detail`
--
ALTER TABLE `apicom_detail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_list`
--
ALTER TABLE `apicom_list`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `apicom_manufacture`
--
ALTER TABLE `apicom_manufacture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `apicom_price_client_sector`
--
ALTER TABLE `apicom_price_client_sector`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `apicom_price_manuf_sector`
--
ALTER TABLE `apicom_price_manuf_sector`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `apicom_sectors`
--
ALTER TABLE `apicom_sectors`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `apicom_users`
--
ALTER TABLE `apicom_users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
