-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 15-Maio-2020 às 01:29
-- Versão do servidor: 10.4.10-MariaDB
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetoc`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `conteudo_desenho`
--

DROP TABLE IF EXISTS `conteudo_desenho`;
CREATE TABLE IF NOT EXISTS `conteudo_desenho` (
  `ID` int(11) DEFAULT NULL,
  `ID_Desenho` int(11) DEFAULT NULL,
  `Conteudo` longtext DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `conteudo_desenho`
--

INSERT INTO `conteudo_desenho` (`ID`, `ID_Desenho`, `Conteudo`) VALUES
(1, 1, 'TESTE'),
(2, 1, 'TESTE2'),
(2, 1, 'TESTE2'),
(2, 1, 'TESTE2'),
(3, 2, 'TESTE2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `desenho`
--

DROP TABLE IF EXISTS `desenho`;
CREATE TABLE IF NOT EXISTS `desenho` (
  `ID` int(11) DEFAULT NULL,
  `ID_User` int(11) DEFAULT NULL,
  `Data_Criacao` date DEFAULT NULL,
  `Data_Atualizacao` date DEFAULT NULL,
  `Nome_Desenho` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `desenho`
--

INSERT INTO `desenho` (`ID`, `ID_User`, `Data_Criacao`, `Data_Atualizacao`, `Nome_Desenho`) VALUES
(1, 1, '0000-00-00', '0000-00-00', ''),
(2, 1, '0000-00-00', '0000-00-00', 'TESTE2'),
(2, 1, '0005-05-05', '0005-05-05', 'TESTE2'),
(2, 1, '0005-05-05', '2020-05-05', 'TESTE2'),
(3, 1, '2020-05-13', '2020-05-14', 'TESTE2'),
(4, 2, '2020-05-14', '2020-05-14', 'TESTE20');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
