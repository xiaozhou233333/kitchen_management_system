create database food_test;
use food_test;
CREATE TABLE user_info (
`id` INT NOT NULL AUTO_INCREMENT,
`user_name` VARCHAR ( 128 ) NOT NULL,
`password` VARCHAR ( 128 ) NOT NULL,
`delete_flag` TINYINT ( 4 ) NULL DEFAULT 0,
`create_time` DATETIME DEFAULT now(),
`update_time` DATETIME DEFAULT now() ON UPDATE now(),
PRIMARY KEY ( `id` ),
UNIQUE INDEX `user_name_UNIQUE` ( `user_name` ASC )) ENGINE = INNODB DEFAULT
CHARACTER
SET = utf8mb4 COMMENT = '用户表';

INSERT INTO user_info ( user_name, PASSWORD ) VALUES ( "admin", "admin" );
INSERT INTO user_info ( user_name, PASSWORD ) VALUES ( "zhangsan", "123456" );

CREATE TABLE `food_info` (
`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
`food_name` VARCHAR ( 127 ) NOT NULL,
`count` INT ( 11 ) NOT NULL,
`price` DECIMAL (7,2 ) NOT NULL,
`origin` VARCHAR ( 256 ) NOT NULL,
`status` TINYINT ( 4 ) DEFAULT 1 COMMENT '0-⽆效, 1-正常, 2-过期',
`create_time` DATETIME DEFAULT now(),
`update_time` DATETIME DEFAULT now() ON UPDATE now(),
PRIMARY KEY ( `id` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

INSERT INTO `food_info` ( food_name, count, price, origin) VALUES
('食材1',  29, 22.00, '产地2'), ('食材2',  29, 22.00, '产地3'),
('食材3',  29, 22.00, '产地1'), ('食材4',  29, 22.00, '产地1'),
('食材5',  29, 22.00, '产地1'), ('食材6',  29, 22.00, '产地1'),
('食材7',  29, 22.00, '产地1'), ('食材8',  29, 22.00, '产地1'),
('食材9',  29, 22.00, '产地1'), ('食材10', 29, 22.00, '产地1'),
('食材11', 29, 22.00, '产地1'), ('食材12', 29, 22.00, '产地1'),
('食材13', 29, 22.00, '产地1'), ('食材14', 29, 22.00, '产地1'),
('食材15', 29, 22.00, '产地1'), ('食材16', 29, 22.00, '产地1'),
('食材17', 29, 22.00, '产地1'), ('食材18', 29, 22.00, '产地1'),
('食材19', 29, 22.00, '产地1'), ('食材20', 29, 22.00, '产地1'),
('食材21', 29, 22.00, '产地1');