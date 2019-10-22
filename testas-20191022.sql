-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2019 m. Spa 22 d. 08:22
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testas`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `klientai`
--

CREATE TABLE `klientai` (
  `id` int(10) UNSIGNED NOT NULL,
  `vardas` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
  `pavarde` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
  `flag_alerg_pieno` int(11) DEFAULT NULL,
  `flag_alerg_riesutai` int(11) DEFAULT NULL,
  `flag_vartoja_alkoholi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `klientai`
--

INSERT INTO `klientai` (`id`, `vardas`, `pavarde`, `flag_alerg_pieno`, `flag_alerg_riesutai`, `flag_vartoja_alkoholi`) VALUES
(2, 'AŠ', 'as', NULL, 1, NULL),
(3, 'Tu ', 'tu', 1, 1, 1),
(4, 'Jis', 'Jis', NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `klientai_patiekalai`
--

CREATE TABLE `klientai_patiekalai` (
  `id` int(10) UNSIGNED NOT NULL,
  `klientai_id` int(10) UNSIGNED NOT NULL,
  `patiekalai_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `klientai_patiekalai`
--

INSERT INTO `klientai_patiekalai` (`id`, `klientai_id`, `patiekalai_id`) VALUES
(1, 2, 4),
(2, 2, 2),
(3, 2, 4),
(4, 2, 1),
(5, 3, 8),
(6, 3, 2),
(7, 3, 4),
(8, 2, 4),
(9, 2, 4),
(10, 3, 9),
(11, 3, 9),
(12, 4, 4),
(13, 4, 8),
(14, 4, 2);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `patiekalai`
--

CREATE TABLE `patiekalai` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(255) COLLATE utf8_lithuanian_ci DEFAULT NULL,
  `flag_yra_pieno` int(11) DEFAULT NULL,
  `flag_yra_riesutai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `patiekalai`
--

INSERT INTO `patiekalai` (`id`, `pav`, `flag_yra_pieno`, `flag_yra_riesutai`) VALUES
(1, 'Arbata', NULL, NULL),
(2, 'Tortas', 1, 1),
(4, 'Kebabas', 1, NULL),
(8, 'Sultys', NULL, NULL),
(9, 'Brokolių sriuba', NULL, NULL);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `rekomendacijos`
--

CREATE TABLE `rekomendacijos` (
  `id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klientai`
--
ALTER TABLE `klientai`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `klientai_patiekalai`
--
ALTER TABLE `klientai_patiekalai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `klientai_id` (`klientai_id`),
  ADD KEY `FKkkwrq28om8vfbxrownhrsw9kl` (`patiekalai_id`);

--
-- Indexes for table `patiekalai`
--
ALTER TABLE `patiekalai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rekomendacijos`
--
ALTER TABLE `rekomendacijos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klientai`
--
ALTER TABLE `klientai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `klientai_patiekalai`
--
ALTER TABLE `klientai_patiekalai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `patiekalai`
--
ALTER TABLE `patiekalai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `rekomendacijos`
--
ALTER TABLE `rekomendacijos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Apribojimai eksportuotom lentelėm
--

--
-- Apribojimai lentelei `klientai_patiekalai`
--
ALTER TABLE `klientai_patiekalai`
  ADD CONSTRAINT `FKkkwrq28om8vfbxrownhrsw9kl` FOREIGN KEY (`patiekalai_id`) REFERENCES `patiekalai` (`id`),
  ADD CONSTRAINT `FKo49n26ksf8net8fpsmyav2mgo` FOREIGN KEY (`klientai_id`) REFERENCES `klientai` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
