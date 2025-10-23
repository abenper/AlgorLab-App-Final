-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-10-2025 a las 20:09:57
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
-- Base de datos: `algorlab`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_contra` (IN `p_id` INT, IN `p_passNueva` VARCHAR(255))   BEGIN
    UPDATE usuarios
    SET contrasena = p_passNueva
    WHERE id = p_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_aprobados_por_tarea` (IN `p_tarea_id` INT, OUT `p_total` INT)   BEGIN
    SELECT COUNT(*) INTO p_total
    FROM entregas
    WHERE tarea_id = p_tarea_id AND estado = 'Aprobado';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `corregir_entrega` (IN `p_entrega_id` INT, IN `p_estado` ENUM('Aprobado','Suspenso'), IN `p_observacion` VARCHAR(255))   BEGIN
    UPDATE entregas
    SET estado = p_estado,
        observacion_profesor = p_observacion
    WHERE id = p_entrega_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_entrega` (IN `p_tarea_id` INT, IN `p_alumno_id` INT, IN `p_fecha` DATETIME, IN `p_url` VARCHAR(255))   BEGIN
    INSERT INTO entregas (tarea_id, alumno_id, fecha_entrega, url_archivo)
    VALUES (p_tarea_id, p_alumno_id, p_fecha, p_url);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_alumnos_por_curso` (IN `p_curso_id` INT)   BEGIN
    SELECT u.id, u.nombre, u.apellidos, u.correo
    FROM usuarios u
    INNER JOIN usuarios_cursos uc ON u.id = uc.usuario_id
    WHERE uc.curso_id = p_curso_id AND u.tipo = 'Alumno';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `p_usuario` VARCHAR(100), IN `p_password` VARCHAR(255), OUT `p_login_ok` TINYINT, OUT `p_tratamiento` VARCHAR(10))   BEGIN
    DECLARE cnt INT DEFAULT 0;

    SELECT COUNT(*) INTO cnt
    FROM usuarios
    WHERE correo = p_usuario 
      AND contrasena = p_password 
      AND tipo IN ('profesor', 'director');

    SET p_login_ok = cnt > 0;

    IF p_login_ok THEN
        SELECT tratamiento INTO p_tratamiento
        FROM usuarios
        WHERE correo = p_usuario
          AND contrasena = p_password
        LIMIT 1;
    ELSE
        SET p_tratamiento = NULL;
    END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `marcar_tarea_como_actualizada` (IN `p_tarea_id` INT)   BEGIN
    UPDATE tareas SET descripcion = CONCAT('[Actualizado] ', descripcion)
    WHERE id = p_tarea_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `menuSelect` (IN `p_usuario` VARCHAR(100), OUT `p_tipo_usuario` VARCHAR(20))   BEGIN
    SELECT tipo
    INTO p_tipo_usuario
    FROM usuarios
    WHERE correo = p_usuario
    LIMIT 1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_tareas_por_curso` (IN `p_curso_id` INT)   BEGIN
    SELECT * FROM tareas
    WHERE curso_id = p_curso_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `validar_recucontra` (IN `p_usuario` VARCHAR(100), IN `p_codigo` VARCHAR(255), OUT `p_id` INT)   BEGIN
    SELECT id INTO p_id
    FROM usuarios
    WHERE correo = p_usuario AND cod_recuperacion = p_codigo
    LIMIT 1;

    IF p_id IS NULL THEN
        SET p_id = 0;
    END IF;
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `estado_entrega_texto` (`p_estado` ENUM('No corregida','Aprobado','Suspenso')) RETURNS VARCHAR(20) CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
    RETURN CASE 
        WHEN p_estado = 'No corregida' THEN 'Pendiente'
        WHEN p_estado = 'Aprobado' THEN 'OK'
        WHEN p_estado = 'Suspenso' THEN 'Mal'
        ELSE 'Desconocido'
    END;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_completo_usuario` (`p_id` INT) RETURNS VARCHAR(255) CHARSET utf8mb4 COLLATE utf8mb4_general_ci DETERMINISTIC BEGIN
    DECLARE nombre_completo VARCHAR(255);
    SELECT CONCAT(nombre, ' ', apellidos) INTO nombre_completo
    FROM usuarios WHERE id = p_id;
    RETURN nombre_completo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria_accesos_cursos`
--

CREATE TABLE `auditoria_accesos_cursos` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL,
  `fecha_acceso` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `auditoria_accesos_cursos`
--

INSERT INTO `auditoria_accesos_cursos` (`id`, `usuario_id`, `curso_id`, `fecha_acceso`) VALUES
(1, 7, 1, '2025-05-27 11:02:58'),
(2, 7, 1, '2025-05-27 11:06:25'),
(3, 7, 1, '2025-05-27 11:06:38'),
(4, 7, 1, '2025-05-27 11:09:46'),
(5, 7, 1, '2025-05-27 11:10:34'),
(6, 7, 2, '2025-05-27 11:10:34'),
(7, 7, 3, '2025-05-27 11:10:34'),
(8, 7, 1, '2025-05-27 11:12:23'),
(9, 7, 2, '2025-05-27 11:12:23'),
(10, 7, 3, '2025-05-27 11:12:23'),
(11, 7, 1, '2025-05-27 11:15:54'),
(12, 7, 2, '2025-05-27 11:15:54'),
(13, 7, 3, '2025-05-27 11:15:54'),
(14, 7, 1, '2025-05-27 11:19:46'),
(15, 7, 2, '2025-05-27 11:19:46'),
(16, 7, 3, '2025-05-27 11:19:46'),
(17, 7, 1, '2025-05-27 11:20:54'),
(18, 7, 2, '2025-05-27 11:20:54'),
(19, 7, 3, '2025-05-27 11:20:54'),
(20, 9, 1, '2025-05-27 11:23:57'),
(21, 9, 2, '2025-05-27 11:23:57'),
(22, 9, 3, '2025-05-27 11:23:57'),
(23, 11, 1, '2025-05-27 11:37:12'),
(24, 11, 2, '2025-05-27 11:37:12'),
(25, 11, 3, '2025-05-27 11:37:12'),
(26, 10, 1, '2025-05-27 11:37:24'),
(27, 10, 2, '2025-05-27 11:37:24'),
(28, 10, 3, '2025-05-27 11:37:24'),
(29, 10, 1, '2025-05-27 11:37:33'),
(30, 10, 2, '2025-05-27 11:37:33'),
(31, 10, 3, '2025-05-27 11:37:33'),
(32, 10, 1, '2025-05-27 11:37:45'),
(33, 10, 2, '2025-05-27 11:37:45'),
(34, 10, 3, '2025-05-27 11:37:45'),
(35, 9, 1, '2025-05-27 11:38:00'),
(36, 9, 2, '2025-05-27 11:38:00'),
(37, 9, 3, '2025-05-27 11:38:00'),
(38, 9, 1, '2025-05-27 11:40:07'),
(39, 10, 2, '2025-05-27 11:40:14'),
(40, 10, 3, '2025-05-27 11:40:14'),
(41, 11, 3, '2025-05-27 11:40:22'),
(42, 7, 2, '2025-05-27 11:40:31'),
(43, 7, 3, '2025-05-27 11:40:31'),
(44, 10, 2, '2025-05-27 11:41:15'),
(45, 10, 3, '2025-05-27 11:41:15'),
(46, 11, 3, '2025-05-27 11:41:36'),
(47, 7, 2, '2025-05-27 11:41:48'),
(48, 7, 3, '2025-05-27 11:41:48'),
(49, 10, 2, '2025-05-27 11:41:57'),
(50, 10, 3, '2025-05-27 11:41:57'),
(51, 10, 2, '2025-05-27 11:46:13'),
(52, 10, 3, '2025-05-27 11:46:13'),
(53, 11, 3, '2025-05-27 11:47:01'),
(54, 11, 3, '2025-05-27 11:47:09'),
(55, 12, 1, '2025-05-27 19:09:30'),
(56, 12, 2, '2025-05-27 19:09:30'),
(57, 12, 3, '2025-05-27 19:09:30'),
(58, 20, 1, '2025-05-27 19:39:06'),
(59, 20, 2, '2025-05-27 19:39:06'),
(60, 20, 3, '2025-05-27 19:39:06'),
(61, 12, 2, '2025-05-27 19:44:54'),
(62, 12, 1, '2025-05-27 19:46:04'),
(63, 12, 2, '2025-05-27 19:46:04'),
(64, 12, 3, '2025-05-27 19:46:04'),
(65, 21, 1, '2025-06-18 08:24:49'),
(66, 21, 2, '2025-06-18 08:24:49'),
(67, 11, 3, '2025-10-23 18:08:31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria_entregas`
--

CREATE TABLE `auditoria_entregas` (
  `id` int(11) NOT NULL,
  `entrega_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `accion` varchar(20) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `auditoria_entregas`
--

INSERT INTO `auditoria_entregas` (`id`, `entrega_id`, `usuario_id`, `accion`, `fecha`) VALUES
(1, 10, 6, 'Cambio de estado: Ap', '2025-05-23 18:58:29'),
(2, 10, 6, 'Cambio de estado: Su', '2025-05-23 18:58:35'),
(3, 10, 6, 'Cambio de estado: Ap', '2025-06-03 09:55:50'),
(4, 10, 6, 'Cambio de estado: Su', '2025-06-03 09:56:02'),
(5, 12, 21, 'Cambio de estado: No', '2025-06-18 08:27:06');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria_logins`
--

CREATE TABLE `auditoria_logins` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `ip_origen` varchar(45) DEFAULT NULL,
  `exito` tinyint(1) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria_passwords`
--

CREATE TABLE `auditoria_passwords` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `fecha_cambio` timestamp NOT NULL DEFAULT current_timestamp(),
  `metodo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `auditoria_passwords`
--

INSERT INTO `auditoria_passwords` (`id`, `usuario_id`, `fecha_cambio`, `metodo`) VALUES
(1, 7, '2025-05-27 10:00:19', 'Actualización desde panel'),
(2, 11, '2025-05-27 11:46:59', 'Actualización desde panel'),
(3, 11, '2025-05-27 11:47:08', 'Actualización desde panel'),
(4, 1, '2025-06-18 08:23:40', 'Actualización desde panel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria_tareas`
--

CREATE TABLE `auditoria_tareas` (
  `id` int(11) NOT NULL,
  `tarea_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `accion` varchar(20) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `capacidad` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `capacidad`) VALUES
(1, 'Java', 30),
(2, 'C#', 25),
(3, 'PHP', 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entregas`
--

CREATE TABLE `entregas` (
  `id` int(11) NOT NULL,
  `tarea_id` int(11) NOT NULL,
  `alumno_id` int(11) NOT NULL,
  `fecha_entrega` datetime DEFAULT NULL,
  `url_archivo` varchar(255) DEFAULT NULL,
  `observacion_profesor` varchar(255) DEFAULT NULL,
  `estado` enum('No corregida','Aprobado','Suspenso') NOT NULL DEFAULT 'No corregida'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entregas`
--

INSERT INTO `entregas` (`id`, `tarea_id`, `alumno_id`, `fecha_entrega`, `url_archivo`, `observacion_profesor`, `estado`) VALUES
(1, 1, 4, '2025-05-20 10:00:00', NULL, NULL, 'No corregida'),
(2, 1, 5, '2025-05-21 15:30:00', NULL, NULL, 'No corregida'),
(3, 3, 6, '2025-05-22 18:00:00', NULL, 'sin observación', 'Suspenso'),
(4, 5, 4, '2025-06-11 09:00:00', NULL, NULL, 'No corregida'),
(5, 6, 4, '2025-06-17 10:30:00', NULL, NULL, 'No corregida'),
(6, 9, 4, '2025-06-09 16:00:00', NULL, 'Ana están regular.', 'Suspenso'),
(7, 5, 5, '2025-06-12 14:15:00', NULL, NULL, 'No corregida'),
(8, 6, 5, NULL, NULL, NULL, 'No corregida'),
(9, 7, 6, '2025-06-07 08:45:00', NULL, NULL, 'No corregida'),
(10, 8, 6, '2025-06-14 18:00:00', NULL, 'Sofia esta muy bien la tarea', 'Aprobado'),
(11, 10, 6, '2025-06-15 11:00:00', NULL, NULL, 'No corregida'),
(12, 1, 21, '2025-06-18 10:25:24', 'entregas/entrega_21_1_1750235124.pdf', 'sin observación', 'Suspenso');

--
-- Disparadores `entregas`
--
DELIMITER $$
CREATE TRIGGER `tr_auditoria_entregas` AFTER UPDATE ON `entregas` FOR EACH ROW BEGIN
  IF OLD.estado <> NEW.estado THEN
    INSERT INTO auditoria_entregas (entrega_id, usuario_id, accion, fecha)
    VALUES (NEW.id, NEW.alumno_id, CONCAT('Cambio de estado: ', OLD.estado, ' → ', NEW.estado), NOW());
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id`, `curso_id`, `titulo`, `descripcion`, `fecha_entrega`) VALUES
(1, 1, 'Variables en Java', 'Crear una clase con atributos y métodos.', '2025-06-01'),
(2, 1, 'Interfaces en Java', 'Implementar interfaces básicas.', '2025-06-10'),
(3, 2, 'Variables en C#', 'Desarrollar una app sencilla.', '2025-06-05'),
(4, 3, 'Variables en PHP', 'Crear una clase con atributos y métodos.', '2025-06-01'),
(5, 1, 'Bucles Java', 'Practicar bucles for y while.', '2025-06-12'),
(6, 1, 'POO Java', 'Aplicar herencia y polimorfismo.', '2025-06-18'),
(7, 2, 'Bucles C#', 'Hacer ejercicios con for y foreach.', '2025-06-08'),
(8, 2, 'POO C#', 'Implementar clases y objetos.', '2025-06-15'),
(9, 3, 'Bucles PHP', 'Usar estructuras de control.', '2025-06-10'),
(10, 3, 'Funciones PHP', 'Crear funciones reutilizables.', '2025-06-16');

--
-- Disparadores `tareas`
--
DELIMITER $$
CREATE TRIGGER `tr_auditoria_tareas` AFTER UPDATE ON `tareas` FOR EACH ROW BEGIN
  INSERT INTO auditoria_tareas (tarea_id, usuario_id, accion, fecha)
  VALUES (NEW.id, NULL, 'Actualización tarea', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `correo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `contrasena` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `cod_recuperacion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tratamiento` enum('Masculino','Femenino','Otro') NOT NULL DEFAULT 'Otro',
  `tipo` enum('Alumno','Profesor','Director') NOT NULL DEFAULT 'Alumno',
  `metodo_pago` enum('Transferencia','Tarjeta','Paypal','Bizum') DEFAULT NULL,
  `sueldo` int(11) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `correo`, `contrasena`, `cod_recuperacion`, `tratamiento`, `tipo`, `metodo_pago`, `sueldo`, `fecha_registro`) VALUES
(1, 'Admin', 'Principal', 'ad', 'ad1', 'ABC123', 'Otro', 'Director', NULL, 5000, '2025-05-19 19:31:31'),
(2, 'Laura', 'Gómez', 'laura.prof@algorlab.com', 'laura123', 'LAU456', 'Femenino', 'Profesor', NULL, 2200, '2025-05-19 19:31:31'),
(3, 'Carlos', 'Ruiz', 'carlos.prof@algorlab.com', 'carlos123', 'CAR789', 'Masculino', 'Profesor', NULL, 2100, '2025-05-19 19:31:31'),
(4, 'Ana', 'Martínez', 'ana.alumno@algorlab.com', 'ana123', 'ANA001', 'Femenino', 'Alumno', 'Tarjeta', NULL, '2025-05-19 19:31:31'),
(5, 'Pedro', 'López', 'pedro.alumno@algorlab.com', 'pedro123', 'PED002', 'Masculino', 'Alumno', 'Bizum', NULL, '2025-05-19 19:31:31'),
(6, 'Sofía', 'Hernández', 'sofia.alumno@algorlab.com', 'sofia123', 'SOF003', 'Femenino', 'Alumno', 'Paypal', NULL, '2025-05-19 19:31:31'),
(7, 'paco', 'martinez', 'paco.prof@algorlab.com', 'paco123', 'paco123', 'Masculino', 'Profesor', NULL, 1500, '2025-05-27 09:40:25'),
(10, 'jnieto', 'jnieto', 'jnieto.dir@algorlab.com', 'jnieto123', 'jnieto123', 'Otro', 'Director', NULL, 21500, '2025-05-27 11:30:04'),
(11, 'Roberto', 'Ruiz', 'roberto', 'roberto', 'roberto123', 'Masculino', 'Profesor', NULL, 2000, '2025-05-27 11:37:11'),
(12, 'marta', 'costilla', 'marta.dir@algorlab.com', 'marta', 'marta5', 'Femenino', 'Director', NULL, 2750, '2025-05-27 19:06:40'),
(20, 'manuel', 'rodriguez', 'manu.prof@algorlab.com', 'manolito', 'manolito2', 'Masculino', 'Profesor', NULL, 1500, '2025-05-27 19:39:05'),
(21, 'jnieto', 'jnieto', 'jnieto@jnieto.com', 'jnieto', '591340', 'Masculino', 'Alumno', 'Bizum', NULL, '2025-06-18 08:21:49');

--
-- Disparadores `usuarios`
--
DELIMITER $$
CREATE TRIGGER `tr_auditoria_passwords` AFTER UPDATE ON `usuarios` FOR EACH ROW BEGIN
  IF OLD.contrasena <> NEW.contrasena THEN
    INSERT INTO auditoria_passwords (usuario_id, fecha_cambio, metodo)
    VALUES (NEW.id, NOW(), 'Actualización desde panel');
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_cursos`
--

CREATE TABLE `usuarios_cursos` (
  `usuario_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios_cursos`
--

INSERT INTO `usuarios_cursos` (`usuario_id`, `curso_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(3, 2),
(3, 3),
(4, 1),
(4, 3),
(5, 1),
(6, 2),
(6, 3),
(7, 2),
(7, 3),
(10, 2),
(10, 3),
(11, 3),
(12, 1),
(12, 2),
(12, 3),
(20, 1),
(20, 2),
(20, 3),
(21, 1),
(21, 2);

--
-- Disparadores `usuarios_cursos`
--
DELIMITER $$
CREATE TRIGGER `tr_auditoria_accesos_cursos` AFTER INSERT ON `usuarios_cursos` FOR EACH ROW BEGIN
  INSERT INTO auditoria_accesos_cursos (usuario_id, curso_id, fecha_acceso)
  VALUES (NEW.usuario_id, NEW.curso_id, NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_inscripciones_cursos`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_inscripciones_cursos` (
`curso` varchar(100)
,`total_inscritos` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_tareas_pendientes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_tareas_pendientes` (
`entrega_id` int(11)
,`alumno` varchar(100)
,`tarea` varchar(255)
,`fecha_entrega` date
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_inscripciones_cursos`
--
DROP TABLE IF EXISTS `vista_inscripciones_cursos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_inscripciones_cursos`  AS SELECT `c`.`nombre` AS `curso`, count(`uc`.`usuario_id`) AS `total_inscritos` FROM (`cursos` `c` left join `usuarios_cursos` `uc` on(`c`.`id` = `uc`.`curso_id`)) GROUP BY `c`.`id` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_tareas_pendientes`
--
DROP TABLE IF EXISTS `vista_tareas_pendientes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_tareas_pendientes`  AS SELECT `e`.`id` AS `entrega_id`, `u`.`nombre` AS `alumno`, `t`.`titulo` AS `tarea`, `t`.`fecha_entrega` AS `fecha_entrega` FROM ((`entregas` `e` join `usuarios` `u` on(`u`.`id` = `e`.`alumno_id`)) join `tareas` `t` on(`t`.`id` = `e`.`tarea_id`)) WHERE `e`.`estado` = 'No corregida' ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `auditoria_accesos_cursos`
--
ALTER TABLE `auditoria_accesos_cursos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `auditoria_entregas`
--
ALTER TABLE `auditoria_entregas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `auditoria_logins`
--
ALTER TABLE `auditoria_logins`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `auditoria_passwords`
--
ALTER TABLE `auditoria_passwords`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `auditoria_tareas`
--
ALTER TABLE `auditoria_tareas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tarea_id` (`tarea_id`),
  ADD KEY `alumno_id` (`alumno_id`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `curso_id` (`curso_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `usuarios_cursos`
--
ALTER TABLE `usuarios_cursos`
  ADD PRIMARY KEY (`usuario_id`,`curso_id`),
  ADD KEY `curso_id` (`curso_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `auditoria_accesos_cursos`
--
ALTER TABLE `auditoria_accesos_cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT de la tabla `auditoria_entregas`
--
ALTER TABLE `auditoria_entregas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `auditoria_logins`
--
ALTER TABLE `auditoria_logins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `auditoria_passwords`
--
ALTER TABLE `auditoria_passwords`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `auditoria_tareas`
--
ALTER TABLE `auditoria_tareas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `entregas`
--
ALTER TABLE `entregas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`tarea_id`) REFERENCES `tareas` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`alumno_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuarios_cursos`
--
ALTER TABLE `usuarios_cursos`
  ADD CONSTRAINT `usuarios_cursos_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `usuarios_cursos_ibfk_2` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
