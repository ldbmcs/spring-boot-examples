-- -------------------------------------------------------------
-- TablePlus 3.7.1(332)
--
-- https://tableplus.com/
--
-- Database: spring-boot-examples
-- Generation Time: 2020-08-14 14:55:38.4180
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


CREATE TABLE `sec_kill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `number` int(11) DEFAULT NULL COMMENT '库存数量',
  `start_time` int(11) DEFAULT NULL COMMENT '秒杀开启时间',
  `end_time` int(11) DEFAULT NULL COMMENT '秒杀结束时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `create_time` int(10) DEFAULT '0' COMMENT '新增时间',
  `update_time` int(10) DEFAULT '0' COMMENT '修改时间',
  `delete_status` tinyint(1) DEFAULT '1' COMMENT '是否删除(1 正常  2删除)',
  `delete_time` int(10) DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sec_kill_record` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sec_kill_id` int(11) DEFAULT NULL COMMENT '秒杀商品id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户Id',
  `state` tinyint(4) DEFAULT NULL COMMENT '状态标示：-1指无效，0指成功，1指已付款',
  `create_time` int(10) DEFAULT '0' COMMENT '新增时间',
  `update_time` int(10) DEFAULT '0' COMMENT '修改时间',
  `delete_status` tinyint(1) DEFAULT '1' COMMENT '是否删除(1 正常  2删除)',
  `delete_time` int(10) DEFAULT '0' COMMENT '删除时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `sec_kill` (`id`, `name`, `number`, `start_time`, `end_time`, `version`, `create_time`, `update_time`, `delete_status`, `delete_time`) VALUES
('1', '1000元秒杀iphone8', '0', '1597372291', '1598716800', '11', '0', '0', '1', '0');



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;