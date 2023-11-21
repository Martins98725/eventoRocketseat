CREATE TABLE `tb_users` (
  `id` binary(16) NOT NULL,
  `createad_at` datetime(6) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(40) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `role` tinyint DEFAULT NULL,
  `nome_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2lb0ppn3ki2554mv1dqq91m2k` (`nome_usuario`),
  CONSTRAINT `tb_users_chk_1` CHECK ((`role` between 0 and 1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;