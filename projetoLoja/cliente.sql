-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Maio-2017 às 22:37
-- Versão do servidor: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbloja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `celular` varchar(14) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `data` varchar(30) NOT NULL,
  `sexo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `telefone`, `celular`, `email`, `data`, `sexo`) VALUES
(1, 'Maria ', '111.222.333-30', '(98)9999-9999', '(98)98465-4681', 'ronaldo@hotmail.com', '', ''),
(3, 'Cincrano', '666.666.666-66', '(98)9945-4648', '(98)98326-5263', 'email@uol.com', '', ''),
(4, 'Pedro', '555.544.645-64', '(98)3278-5656', '(98)98665-6236', 'erro@gmail.com', '', ''),
(9, 'Ronaldo Santos', '123.151.186-15', '(85)6565-6545', '(98)65464-5654', 'email@gmail.com', '', ''),
(10, 'Filipe', '545.131.554-15', '(98)5696-8989', '(98)98989-8989', 'filipe@hotmail.com', '', ''),
(20, 'Filipe Costa ', '857.878.787-87', '(98)7777-7777', '(98)66666-6666', 'filipe@gmail.com', '10/02/2017', 'Masculino');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
