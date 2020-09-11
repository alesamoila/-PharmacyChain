-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: mai 15, 2020 la 05:22 PM
-- Versiune server: 10.4.11-MariaDB
-- Versiune PHP: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `farmacie`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `contutilizator`
--

CREATE TABLE `contutilizator` (
  `functie` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `parola` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `contutilizator`
--

INSERT INTO `contutilizator` (`functie`, `username`, `parola`) VALUES
('AngajatFarmacie', 'f1', 'f1'),
('AngajatPlafar', 'p1', 'p1');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `medicament`
--

CREATE TABLE `medicament` (
  `nume` varchar(30) NOT NULL,
  `pret` double NOT NULL,
  `disponibilitate` int(30) NOT NULL,
  `valabilitate` varchar(30) NOT NULL,
  `producator` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `medicament`
--

INSERT INTO `medicament` (`nume`, `pret`, `disponibilitate`, `valabilitate`, `producator`) VALUES
('Nurofen', 15.7, 22, '21-03-2024', 'Nurofen'),
('Imodium', 7.9, 15, '03-07-2022', 'Imodium');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `produsnaturist`
--

CREATE TABLE `produsnaturist` (
  `nume` varchar(30) NOT NULL,
  `pret` double NOT NULL,
  `disponibilitate` int(30) NOT NULL,
  `valabilitate` varchar(30) NOT NULL,
  `producator` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `produsnaturist`
--

INSERT INTO `produsnaturist` (`nume`, `pret`, `disponibilitate`, `valabilitate`, `producator`) VALUES
('prod', 3.4, 15, '12-03-2024', 'val'),
('Ceai', 5.3, 12, '12-04-2022', 'Plafar');

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `utilizator`
--

CREATE TABLE `utilizator` (
  `nume` varchar(30) NOT NULL,
  `prenume` varchar(30) NOT NULL,
  `varsta` int(30) NOT NULL,
  `functie` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `utilizator`
--

INSERT INTO `utilizator` (`nume`, `prenume`, `varsta`, `functie`) VALUES
('Man', 'Diana', 24, 'AngajatPlafar'),
('Doaga', 'Bogdan', 28, 'AngajatFarmacie'),
('ang', 'adn', 24, 'AngP');

--
-- Indexuri pentru tabele eliminate
--

--
-- Indexuri pentru tabele `contutilizator`
--
ALTER TABLE `contutilizator`
  ADD PRIMARY KEY (`functie`),
  ADD UNIQUE KEY `username` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
