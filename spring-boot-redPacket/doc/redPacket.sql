-- -------------------------------------------------------------
-- TablePlus 3.7.1(332)
--
-- https://tableplus.com/
--
-- Database: spring-boot-examples
-- Generation Time: 2020-08-14 14:55:54.5110
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `red_packet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `total_amount` int(11) DEFAULT NULL COMMENT '红包总金额，单位分',
  `total_packet` int(11) DEFAULT NULL COMMENT '红包总个数',
  `version` varchar(255) DEFAULT NULL COMMENT '版本号',
  `create_time` int(10) DEFAULT '0' COMMENT '新增时间',
  `update_time` int(10) DEFAULT '0' COMMENT '修改时间',
  `delete_status` tinyint(1) DEFAULT '1' COMMENT '是否删除(1 正常  2删除)',
  `delete_time` int(10) DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `red_packet_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `red_packet_id` bigint(20) DEFAULT NULL COMMENT '红包id',
  `red_packet_amount` int(11) DEFAULT NULL COMMENT '红包金额',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `create_time` int(10) DEFAULT '0' COMMENT '新增时间',
  `update_time` int(10) DEFAULT '0' COMMENT '修改时间',
  `delete_status` tinyint(1) DEFAULT '1' COMMENT '是否删除(1 正常  2删除)',
  `delete_time` int(10) DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `red_packet` (`id`, `total_amount`, `total_packet`, `version`, `create_time`, `update_time`, `delete_status`, `delete_time`) VALUES
('1', '20000', '10', '1', '0', '0', '1', '0');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;