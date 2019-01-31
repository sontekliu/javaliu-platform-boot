-- 用户表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE `sys_user` (
  `id` bigint(32) NOT NULL COMMENT '主键ID',
  `email` varchar(128) NOT NULL COMMENT 'Email地址',
  `code` varchar(64) DEFAULT NULL COMMENT '登录用户名',
  `name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `password` char(40) DEFAULT NULL COMMENT '密码',
  `salt`  CHAR(8) NOT NULL COMMENT '盐',
  `sex` int DEFAULT '0' COMMENT '性别',
  `year` int DEFAULT NULL COMMENT '年份',
  `month` int DEFAULT NULL COMMENT '月份',
  `day` int DEFAULT NULL COMMENT '日期',
  `header_pic` VARCHAR(64) DEFAULT NULL COMMENT '头像地址',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `delete_flag` int DEFAULT '0' COMMENT '删除标识',
  `create_by` bigint(32) NOT NULL COMMENT '创建人',
  `create_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(32) NOT NULL COMMENT '修改人',
  `update_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 操作日志
DROP TABLE IF EXISTS sys_log;
CREATE TABLE `sys_log` (
  `id` bigint(32) NOT NULL COMMENT '主键ID',
  `action` varchar(64) NOT NULL COMMENT '操作内容',
  `action_form` varchar(64) NOT NULL COMMENT '来自哪儿的操作，Web页面还是SDK接口调用',
  `ip_address` varchar(64) NOT NULL COMMENT 'IP地址',
  `user_id` bigint(32) NOT NULL COMMENT '操作人',
  `user_code` bigint(64) NOT NULL COMMENT '操作人登录账号',
  `create_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` int DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 短连接表
DROP TABLE IF EXISTS sms_short_link;
CREATE TABLE `sms_short_link` (
  `id` bigint(32) NOT NULL COMMENT '主键ID',
  `short_key` varchar(32) NOT NULL COMMENT '短链接码',
  `original_url` varchar(512) NOT NULL COMMENT '原始Url地址',
  `expire_date_time` TIMESTAMP NULL DEFAULT NULL COMMENT '过期时间',
  `biz_type` int DEFAULT NULL COMMENT '业务类型',
  `delete_flag` int DEFAULT '0' COMMENT '删除标识',
  `create_by` bigint(32) NOT NULL COMMENT '创建人',
  `create_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(32) NOT NULL COMMENT '修改人',
  `update_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;