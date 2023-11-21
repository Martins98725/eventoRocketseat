
CREATE TABLE `tb_tasks` (
  `id` binary(16) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `descricao` varchar(255) NOT NULL,
  `end_at` datetime(6) DEFAULT NULL,
  `id_user` binary(16) DEFAULT NULL,
  `prioridade` varchar(30) NOT NULL,
  `start_at` datetime(6) DEFAULT NULL,
  `titulo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;