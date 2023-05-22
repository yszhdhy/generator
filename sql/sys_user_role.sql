create table sys_user_role
(
    id          bigint auto_increment comment '主键id'
        primary key,
    role_id     bigint    default 0                 not null comment '角色id',
    user_id     bigint    default 0                 not null comment '用户id',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted  tinyint   default 0                 not null comment '删除标记（0:不可用 1:可用）'
)
    comment '用户角色' charset = utf8mb3;

INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (2, 2, 2, '2022-01-20 20:49:37', '2022-02-24 10:43:07', 0);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (3, 1, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (4, 2, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (5, 1, 1, '2022-05-24 16:55:53', '2022-05-24 16:55:53', 0);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (6, 2, 3, '2022-05-25 16:09:31', '2022-05-25 16:09:31', 0);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (7, 2, 4, '2022-06-02 11:08:14', '2022-06-02 11:15:36', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (8, 2, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (9, 1, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (10, 1, 4, '2022-06-02 16:10:53', '2023-04-28 08:36:36', 1);
INSERT INTO generator.sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES (11, 10, 4, '2023-04-28 08:36:36', '2023-04-28 08:36:36', 0);
