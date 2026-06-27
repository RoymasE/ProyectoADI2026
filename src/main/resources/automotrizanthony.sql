-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-06-2026 a las 00:48:52
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `automotrizanthony`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `estado`) VALUES
('CLI001', 'Juan Perez', 1),
('CLI002', 'Ana Torres', 1),
('CLI003', 'Carlos Mendoza', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idfactura` int(10) UNSIGNED NOT NULL,
  `idventa` int(10) UNSIGNED NOT NULL,
  `catidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `fecha` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `IVA` double DEFAULT NULL,
  `IRPF` double DEFAULT NULL,
  `idsecretario` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idfactura`, `idventa`, `catidad`, `subtotal`, `fecha`, `correo`, `IVA`, `IRPF`, `idsecretario`) VALUES
(1, 1, 1, 25.5, '2026-06-20', 'juan@gmail.com', 3.06, 0, 1),
(2, 2, 1, 15, '2026-06-20', 'ana@gmail.com', 1.8, 0, 1),
(3, 3, 1, 120, '2026-06-20', 'carlos@gmail.com', 14.4, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idproducto` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idproducto`, `nombre`, `cantidad`, `precio`, `descripcion`, `estado`) VALUES
('1', 'Aceite Motor', 50, 25.5, 'Aceite sintético para motor', '1'),
('2', 'Filtro de Aire', 30, 15, 'Filtro para vehículos', '1'),
('3', 'Batería 12V', 10, 120, 'Batería para automóvil', '1'),
('4', 'Filtro de Aire nananan', 30, 15, 'Filtro para vehículos', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reguistro`
--

CREATE TABLE `reguistro` (
  `idreguistro` varchar(100) NOT NULL,
  `idcliente` varchar(100) DEFAULT NULL,
  `idsecretario` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reguistro`
--

INSERT INTO `reguistro` (`idreguistro`, `idcliente`, `idsecretario`) VALUES
('REG001', 'CLI001', '1'),
('REG002', 'CLI002', '1'),
('REG003', 'CLI003', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secretario`
--

CREATE TABLE `secretario` (
  `idsecretario` varchar(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `cedula` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `secretario`
--

INSERT INTO `secretario` (`idsecretario`, `nombre`, `apellido`, `cedula`, `telefono`, `direccion`, `estado`) VALUES
('1', 'Anthony', 'Ramirez', '1234567890', '0991111111', 'Av. Principal 123', 1),
('2', 'Maria', 'Lopez', '0987654321', '0992222222', 'Calle Central 456', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idventa` int(10) UNSIGNED NOT NULL,
  `idcliente` varchar(100) NOT NULL,
  `idproducto` varchar(100) DEFAULT NULL,
  `fechaventa` varchar(100) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idventa`, `idcliente`, `idproducto`, `fechaventa`, `subtotal`, `estado`) VALUES
(1, 'CLI001', '1', '2026-06-20', 25.5, '1'),
(2, 'CLI002', '2', '2026-06-20', 15, '1'),
(3, 'CLI003', '3', '2026-06-20', 120, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idfactura`),
  ADD KEY `idventa` (`idventa`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idproducto`);

--
-- Indices de la tabla `reguistro`
--
ALTER TABLE `reguistro`
  ADD PRIMARY KEY (`idreguistro`),
  ADD KEY `idcliente` (`idcliente`),
  ADD KEY `idsecretario` (`idsecretario`);

--
-- Indices de la tabla `secretario`
--
ALTER TABLE `secretario`
  ADD PRIMARY KEY (`idsecretario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idventa`),
  ADD KEY `idcliente` (`idcliente`),
  ADD KEY `idproducto` (`idproducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `idfactura` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idventa` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE CASCADE;

--
-- Filtros para la tabla `reguistro`
--
ALTER TABLE `reguistro`
  ADD CONSTRAINT `reguistro_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE,
  ADD CONSTRAINT `reguistro_ibfk_2` FOREIGN KEY (`idsecretario`) REFERENCES `secretario` (`idsecretario`) ON DELETE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE,
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
