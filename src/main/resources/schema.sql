CREATE TABLE `mpplayerpayment` (
  `id_payment` varchar(255) NOT NULL,
  `player_account_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_paid` varchar(255) DEFAULT NULL,
  `is_received` varchar(255) DEFAULT NULL,
  `mercado_pago_status_payment` varchar(255) DEFAULT NULL,
  `payer_email` varchar(255) DEFAULT NULL,
  `payment_method_id` varchar(255) DEFAULT NULL,
  `qr_code` varchar(255) DEFAULT NULL,
  `transaction_amount` double DEFAULT NULL,
  PRIMARY KEY (`id_payment`,`player_account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci