/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.49 : Database - ticketweb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ticketweb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ticketweb`;

/*Table structure for table `concert` */

DROP TABLE IF EXISTS `concert`;

CREATE TABLE `concert` (
  `c_id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `c_title` varchar(50) DEFAULT NULL COMMENT '标题',
  `c_addr` varchar(50) DEFAULT NULL COMMENT '场馆',
  `c_cover` varchar(50) DEFAULT NULL COMMENT '图片',
  `c_content` text COMMENT '详情',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `concert` */

insert  into `concert`(`c_id`,`c_title`,`c_addr`,`c_cover`,`c_content`) values (2,'【长沙】周笔畅2019LUNAR巡回演唱会-长沙站','长沙市 | 湖南国际会展中心','pic/02.webp','极致舞美打造超强感官享受,层次递进的章节编排更彰显千面女力,视听、概念、现场演绎全面高度契合,现场万人为周笔畅庆生，近3小时高饱和唱演燃爆全场!'),(3,'【长沙】【全場暢飲】歲末狂歡！夜貓俱樂部之星城奇妙夜','长沙市 | MAO Livehouse长沙','pic/03.webp','让我们想想\r\n我们需要都市玩家们一起集结\r\n然后有非常好的音乐\r\n还要有足够的Chill和好奇心\r\n而且不想在你\"太难了\"的时候\r\n南上加南\r\n好吧\r\n那我们一起来吧！\r\n\r\n夜猫俱乐部在MAO Livehouse为你准备了一场梦幻派对\r\n你会穿过充满奇妙色彩的长沙老夜市\r\n来到充满未来主义的火星舞厅\r\n和Underground地下舞场\r\n用魔幻现实主义场景\r\n让你时空错乱，让你尖叫不停！\r\n这就是星城奇妙夜！\r\n也许你还会遇到每个不同时代的人哦\r\n我实在不能剧透太多了….'),(4,'【长沙】202020当我们谈论爱情-梁静茹世界巡回演唱会长沙站','长沙市 | 湖南国际会展中心','pic/04.webp','202020 当我们谈论爱情 \r\nWhen we talk about love \r\n\r\n「情歌天后-梁静茹-情歌本格派」 \r\n20th Anniversary The world tour \r\n\r\n你和谁擦肩而过\r\n你和谁又重逢相会\r\n\r\n「梁静茹 X 梁静茹20周年世界巡回演唱会」 \r\n\r\n在爱里 幸福与遗憾，热恋与失去， \r\n在情歌里 当我们谈论爱情，拾获爱情'),(5,'【长沙】2020陈小春【STOP ANGRY】全国巡回演唱会长沙站','长沙市 | 湖南国际会展中心','pic/05.webp','不管别人说的多么难听\r\n现在我拥有的事情\r\n是你 是给我一半的爱情\r\n我喜欢你 是我独家的记忆\r\n谁也不行\r\n从我这个身体中拿走你\r\n\r\n这段苦情的浪漫深情旋律有萦绕在你耳边吗？小春哥的歌曲也总是往往可以与我们内心连结，人生每个阶段都有自己的\"独家记忆\"。当然他的经典不仅如此，还有献世、相依为命、我爱的人、离不开你、友情岁月等等。他的苦情歌可以唱哭你，超喜欢。\r\n\r\n听了这首歌，你可以感觉得到他身上有一种特殊的人格魅力，一种亲和力！陈小春真的很独家，他的算你狠、别碰我的人等歌曲又继承了苦情的情感却可以用拽拽的而慵懒的嘶哑嗓音痞痞的表达了出来，歌曲里的故事很现实，歌词也很接地气，这种独家的演唱方式也让我们不自觉的将他的歌曲走心。因为在他的电影里有我们想要渴望的某些优点也有很多缺失和无奈，在他的歌曲里我们也仿佛总能看到自己的故事…'),(6,'【长沙】2019-2020跨年倒计时重磅活动—超模DJ巡演荧光派对-长沙站MAOlivehouse','长沙市 | 贺龙体育馆','pic/06.webp','让我们想想\r\n我们需要都市玩家们一起集结\r\n然后有非常好的音乐\r\n还要有足够的Chill和好奇心\r\n而且不想在你\"太难了\"的时候\r\n南上加南\r\n好吧\r\n那我们一起来吧！\r\n\r\n夜猫俱乐部在MAO Livehouse为你准备了一场梦幻派对\r\n你会穿过充满奇妙色彩的长沙老夜市\r\n来到充满未来主义的火星舞厅\r\n和Underground地下舞场\r\n用魔幻现实主义场景\r\n让你时空错乱，让你尖叫不停！\r\n这就是星城奇妙夜！\r\n也许你还会遇到每个不同时代的人哦\r\n我实在不能剧透太多了….');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `t_id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `c_id` int(5) NOT NULL COMMENT '演唱会ID',
  `t_select` datetime NOT NULL COMMENT '场次',
  `t_price` float(8,2) NOT NULL COMMENT '票档',
  `t_details` varchar(50) DEFAULT NULL COMMENT '票档详情',
  `t_count` int(5) NOT NULL COMMENT '余量',
  PRIMARY KEY (`t_id`),
  KEY `c_id` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `ticket` */

insert  into `ticket`(`t_id`,`c_id`,`t_select`,`t_price`,`t_details`,`t_count`) values (1,2,'2019-12-28 19:30:00',380.00,NULL,500),(2,2,'2019-12-28 19:30:00',580.00,NULL,300),(3,2,'2019-12-28 19:30:00',1280.00,NULL,120),(4,3,'2019-12-28 22:00:00',100.00,'畅饮单人票',200),(5,3,'2019-12-28 22:00:00',180.00,'畅饮双人票',200),(6,3,'2019-12-28 22:00:00',320.00,'畅饮四人票',200),(7,4,'2020-01-04 19:30:00',599.00,'五层看台',220),(8,4,'2020-01-04 10:30:00',999.00,'二层看台',220),(9,4,'2020-01-04 19:30:00',1299.00,'内场',110),(10,4,'2020-01-05 19:30:00',599.00,'五层看台',220),(11,4,'2020-01-05 19:30:00',999.00,'二层看台',220),(12,4,'2020-01-05 19:30:00',1299.00,'内场',110),(13,5,'2019-12-28 19:00:00',695.00,'看台',300),(14,5,'2019-12-28 19:00:00',1695.00,'内场',200),(15,6,'2019-12-31 20:00:00',98.00,'普通票',300),(16,6,'2019-12-31 20:00:00',188.00,'VIP票',200),(17,6,'2019-12-31 22:30:00',98.00,'普通票',300),(18,6,'2019-12-31 22:30:00',188.00,'VIP票',200);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
