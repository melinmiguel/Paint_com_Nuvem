
SET SQL_MODE = NO_AUTO_VALUE_ON_ZERO;
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = +0000;

CREATE TABLE `desenhos` (
  `id` int(11) NOT NULL,
  `nome` varchar(225) NOT NULL,
  `dataCriacao` date NOT NULL,
  `dataModificacao` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `desenhos`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `desenhos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

