create table oauth_client_details ( client_id VARCHAR(256) PRIMARY KEY,
	 resource_ids VARCHAR(256), client_secret VARCHAR(256), scope VARCHAR(256),
	 authorized_grant_types VARCHAR(256), web_server_redirect_uri VARCHAR(256),
	 authorities VARCHAR(256), access_token_validity INTEGER,
	 refresh_token_validity INTEGER, additional_information VARCHAR(4096),
	 autoapprove VARCHAR(256) )ENGINE=InnoDB DEFAULT CHARSET=utf8;; 

INSERT INTO oauth_client_details (client_id,
	 client_secret, scope, authorized_grant_types, web_server_redirect_uri,
	 authorities, access_token_validity, refresh_token_validity,
	 additional_information, autoapprove) VALUES ('user-client',
	 '$2a$10$o2l5kA7z.Caekp72h5kU7uqdTDrlamLq.57M1F6ulJln9tRtOJufq', 'all',
	 'authorization_code,refresh_token,password', null, null, 3600, 36000, null,
	 true);
	 
	 INSERT INTO oauth_client_details (client_id, client_secret, scope,
	 authorized_grant_types, web_server_redirect_uri, authorities,
	 access_token_validity, refresh_token_validity, additional_information,
	 autoapprove) VALUES ('order-client',
	 '$2a$10$GoIOhjqFKVyrabUNcie8d.ADX.qZSxpYbO6YK4L2gsNzlCIxEUDlW', 'all',
	 'authorization_code,refresh_token,password', null, null, 3600, 36000, null,
	 true);

CREATE TABLE `wlc_user` (
  `user_id` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(100) DEFAULT NULL COMMENT '密码',
  `user_token` varchar(100) DEFAULT NULL COMMENT '令牌',
  `user_desc` text COMMENT '说明',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `wlc_user` AUTO_INCREMENT=10000;
CREATE TABLE `wlc_role` (
  `role_id` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `role_status` int(2) DEFAULT 1 COMMENT '状态 1启用 0禁用',
  `role_type` int(2) DEFAULT 0 COMMENT '角色类型 admin:1 普通：0',
  `role_desc` text COMMENT '说明',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `wlc_role` AUTO_INCREMENT=10000;

CREATE TABLE `wlc_user_role` (
  `id` bigint(20) NOT NULL  AUTO_INCREMENT COMMENT '唯一标识',
	`user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table `wlc_user_role` AUTO_INCREMENT=10000;