create table sys_role
(
    id          bigint auto_increment comment '角色id'
        primary key,
    role_name   varchar(20) default ''                not null comment '角色名称',
    role_code   varchar(20)                           null comment '角色编码',
    description varchar(255)                          null comment '描述',
    create_time timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted  tinyint     default 0                 not null comment '删除标记（0:不可用 1:可用）'
)
    comment '角色' charset = utf8mb3;

INSERT INTO generator.sys_role (id, role_name, role_code, description, create_time, update_time, is_deleted) VALUES (1, '系统管理员', 'SYSTEM', '系统管理员', '2021-05-31 18:09:18', '2022-06-08 09:21:10', 0);
INSERT INTO generator.sys_role (id, role_name, role_code, description, create_time, update_time, is_deleted) VALUES (2, '普通管理员', 'COMMON', '普通管理员', '2021-06-01 08:38:40', '2022-02-24 10:42:46', 0);
INSERT INTO generator.sys_role (id, role_name, role_code, description, create_time, update_time, is_deleted) VALUES (8, '用户管理员', 'yhgly', null, '2022-06-08 17:39:04', '2022-06-08 17:39:04', 0);
INSERT INTO generator.sys_role (id, role_name, role_code, description, create_time, update_time, is_deleted) VALUES (10, '角色管理员', 'rrrr', null, '2023-04-28 08:35:13', '2023-04-28 08:35:13', 0);
