drop table if exist  `db_stock`;
CREATE TABLE `db_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creator` varchar(50)  DEFAULT '',
  `modifier` varchar(50) DEFAULT '',
  `code` varchar(50)  NOT NULL COMMENT 'stock code',
  `name` varchar(50)  NULL COMMENT 'stock name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='stock';

drop table if exist  `db_stock_price`;
CREATE TABLE `db_stock_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creator` varchar(50)  DEFAULT '',
  `modifier` varchar(50)  utf8 DEFAULT '',
  `stock_id` int  NOT NULL COMMENT 'stock id',
  `date` date NOT NULL COMMENT 'stock date',
  `price` int NOT NULL COMMENT 'stock price  * 1000 ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='stock price';