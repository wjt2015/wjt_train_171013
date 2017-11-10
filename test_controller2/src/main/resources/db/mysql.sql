CREATE TABLE IF NOT EXISTS `ims`.`white_list` (
`id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键,酒店白名单的唯一标识|jintao.wang|2017-10-31',
`name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '白名单名字|jintao.wang|2017-10-31',
`count_of_hotels` INT ZEROFILL NOT NULL DEFAULT 0 COMMENT '这个白名单包含的酒店数量|jintao.wang|2017-10-31',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间|jintao.wang|2017-10-31',
`create_user` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '创建者|jintao.wang|2017-10-31',
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间|jintao.wang|2017-10-31',
`update_user` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '更新者|jintao.wang|2017-10-31',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
COMMENT = '酒店白名单|jintao.wang|2017-10-31';


CREATE TABLE IF NOT EXISTS `ims`.`white_list_hotel` (
`id` INT NOT NULL AUTO_INCREMENT COMMENT '自增主键，酒店的唯一标识|jintao.wang|2017-10-31',
`white_list_id` INT NOT NULL DEFAULT 0 COMMENT '该酒店所属白名单的标识|jintao.wang|2017-10-31',
`hotelSeq` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '酒店seq，酒店的唯一标示|jintao.wang|2017-10-31',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间|jintao.wang|2017-10-31',
`create_user` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '创建者|jintao.wang|2017-10-31',
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间|jintao.wang|2017-10-31',
`update_user` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '更新者|jintao.wang|2017-10-31',
PRIMARY KEY (`id`),
UNIQUE INDEX seqIndex USING BTREE (`hotelSeq`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
COMMENT = '白名单内的酒店|jintao.wang|2017-10-31';
