-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-03-2024 a las 23:01:44
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `message`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `to` text NOT NULL,
  `date` varchar(30) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `message`
--

INSERT INTO `message` (`id`, `to`, `date`, `message`) VALUES
(3, '+50376138735', '2024-03-08', 'Test360'),
(4, '+50376138735', '2024-03-08', 'Test360'),
(5, '+12488342566', '2024-03-08', 'Test360'),
(6, '+50376138735', '2024-03-08', 'Test360'),
(7, '+50376138735', '2024-03-08', 'segundo Test360');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sender_message`
--

CREATE TABLE `sender_message` (
  `id` bigint(20) NOT NULL,
  `message_id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `confirmation_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sender_message`
--

INSERT INTO `sender_message` (`id`, `message_id`, `date`, `confirmation_code`) VALUES
(1, 4, '2024-03-08', NULL),
(2, 5, '2024-03-08', NULL),
(3, 6, '2024-03-08', NULL),
(4, 7, '2024-03-08', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sender_message`
--
ALTER TABLE `sender_message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_message_id` (`message_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `sender_message`
--
ALTER TABLE `sender_message`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `sender_message`
--
ALTER TABLE `sender_message`
  ADD CONSTRAINT `fk_message_id` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
