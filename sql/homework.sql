-- --------------------------------------------------------
-- 서버 버전:                        10.4.6-MariaDB-1:10.4.6+maria~bionic - mariadb.org binary distribution
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 work.tb_chat_room 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_chat_room` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 테이블 데이터 work.tb_chat_room:~3 rows (대략적) 내보내기
DELETE FROM `tb_chat_room`;
/*!40000 ALTER TABLE `tb_chat_room` DISABLE KEYS */;
INSERT INTO `tb_chat_room` (`seq`, `room_name`, `create_date`) VALUES
	(1, 'R-001', '2020-11-22 18:44:09'),
	(2, 'R-002', '2020-11-22 19:16:16'),
	(3, 'R-003', '2020-11-22 19:16:24');
/*!40000 ALTER TABLE `tb_chat_room` ENABLE KEYS */;

-- 테이블 work.tb_dist_allocated 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_dist_allocated` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `dist_seq` int(11) DEFAULT NULL,
  `allocate_amount` int(11) DEFAULT NULL,
  `allocate_user_seq` int(11) DEFAULT NULL,
  `allocate_date` datetime DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- 테이블 데이터 work.tb_dist_allocated:~9 rows (대략적) 내보내기
DELETE FROM `tb_dist_allocated`;
/*!40000 ALTER TABLE `tb_dist_allocated` DISABLE KEYS */;
INSERT INTO `tb_dist_allocated` (`seq`, `dist_seq`, `allocate_amount`, `allocate_user_seq`, `allocate_date`) VALUES
	(27, 35, 33333, 2, '2020-11-23 01:58:05'),
	(28, 35, 33333, 3, '2020-11-23 02:51:23'),
	(29, 35, 33334, NULL, NULL),
	(30, 36, 33333, 2, '2020-11-23 03:03:31'),
	(31, 36, 33333, NULL, NULL),
	(32, 36, 33334, NULL, NULL),
	(33, 37, 33333, 2, '2020-11-23 15:10:01'),
	(34, 37, 33333, NULL, NULL),
	(35, 37, 33334, NULL, NULL),
	(36, 38, 33333, NULL, NULL),
	(37, 38, 33333, NULL, NULL),
	(38, 38, 33334, NULL, NULL),
	(39, 39, 33333, NULL, NULL),
	(40, 39, 33333, NULL, NULL),
	(41, 39, 33334, NULL, NULL);
/*!40000 ALTER TABLE `tb_dist_allocated` ENABLE KEYS */;

-- 테이블 work.tb_dist_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_dist_info` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `token` int(11) NOT NULL,
  `user_seq` int(11) NOT NULL,
  `room_seq` int(11) NOT NULL,
  `dist_amount` int(11) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='token에 해당하는 뿌리기 건의 현재 상태를 응답값으로 내려줍니다. 현재 상태는 다음의 정보를 포함합니다.\r\n뿌린 시각, 뿌린 금액, 받기 완료된 금액, 받기 완료된 정보 ([받은 금액, 받은 사용자 아이디] 리스트)';

-- 테이블 데이터 work.tb_dist_info:~3 rows (대략적) 내보내기
DELETE FROM `tb_dist_info`;
/*!40000 ALTER TABLE `tb_dist_info` DISABLE KEYS */;
INSERT INTO `tb_dist_info` (`seq`, `token`, `user_seq`, `room_seq`, `dist_amount`, `create_date`) VALUES
	(35, 890, 1, 3, 100000, '2020-11-23 01:57:59'),
	(36, 503, 1, 3, 100000, '2020-11-23 03:03:21'),
	(37, 733, 1, 3, 100000, '2020-11-23 15:08:31'),
	(38, 169, 1, 3, 100000, '2020-11-23 15:10:01'),
	(39, 549, 1, 3, 100000, '2020-11-23 23:20:53');
/*!40000 ALTER TABLE `tb_dist_info` ENABLE KEYS */;

-- 테이블 work.tb_token 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_token` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_seq` int(11) NOT NULL,
  `token` smallint(6) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- 테이블 데이터 work.tb_token:~9 rows (대략적) 내보내기
DELETE FROM `tb_token`;
/*!40000 ALTER TABLE `tb_token` DISABLE KEYS */;
INSERT INTO `tb_token` (`seq`, `user_seq`, `token`, `create_date`) VALUES
	(32, 1, 963, '2020-11-23 01:29:48'),
	(33, 1, 299, '2020-11-23 01:43:38'),
	(34, 1, 207, '2020-11-23 01:51:46'),
	(35, 1, 753, '2020-11-23 01:53:36'),
	(36, 1, 751, '2020-11-23 01:57:26'),
	(37, 1, 324, '2020-11-23 01:57:30'),
	(38, 1, 890, '2020-11-23 01:57:59'),
	(39, 1, 503, '2020-11-23 03:03:21'),
	(40, 1, 733, '2020-11-23 15:08:31'),
	(41, 1, 169, '2020-11-23 15:10:01'),
	(42, 1, 549, '2020-11-23 23:20:53');
/*!40000 ALTER TABLE `tb_token` ENABLE KEYS */;

-- 테이블 work.tb_user 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_user` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(12) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 테이블 데이터 work.tb_user:~4 rows (대략적) 내보내기
DELETE FROM `tb_user`;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`seq`, `user_name`, `create_date`) VALUES
	(1, 'pay-01', '2020-11-22 18:40:32'),
	(2, 'pay-02', '2020-11-22 18:40:50'),
	(3, 'pay-03', '2020-11-22 18:42:16'),
	(4, 'pay-04', '2020-11-22 18:42:27'),
	(5, 'pay-05', '2020-11-22 18:42:32');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

-- 테이블 work.tm_chat_user 구조 내보내기
CREATE TABLE IF NOT EXISTS `tm_chat_user` (
  `seq` int(11) NOT NULL AUTO_INCREMENT,
  `room_seq` int(11) DEFAULT NULL,
  `user_seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 테이블 데이터 work.tm_chat_user:~11 rows (대략적) 내보내기
DELETE FROM `tm_chat_user`;
/*!40000 ALTER TABLE `tm_chat_user` DISABLE KEYS */;
INSERT INTO `tm_chat_user` (`seq`, `room_seq`, `user_seq`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 2, 2),
	(5, 2, 3),
	(6, 3, 1),
	(7, 3, 2),
	(8, 3, 4),
	(9, 3, 5),
	(10, 4, 2),
	(11, 4, 5);
/*!40000 ALTER TABLE `tm_chat_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
