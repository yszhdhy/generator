create table sys_user
(
    id          bigint auto_increment comment '会员id'
        primary key,
    username    varchar(20) default ''                not null comment '用户名',
    password    varchar(32) default ''                not null comment '密码',
    name        varchar(50)                           null comment '姓名',
    phone       varchar(11)                           null comment '手机',
    head_url    varchar(200)                          null comment '头像地址',
    dept_id     bigint                                null comment '部门id',
    post_id     bigint                                null comment '岗位id',
    open_id     varchar(255)                          null comment '微信openId',
    description varchar(255)                          null comment '描述',
    status      tinyint                               null comment '状态（1：正常 0：停用）',
    create_time timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted  tinyint     default 0                 not null comment '删除标记（0:不可用 1:可用）',
    constraint idx_username
        unique (username)
)
    comment '用户表';

INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (1, 'admin', '96e79218965eb72c92a549dd5a330112', 'admin', '15000000000', 'http://r61cnlsfq.hn-bkt.clouddn.com/7daa4595-dfde-45da-8513-c5c2b81d20cc', 1022, null, '', null, 1, '2021-05-31 18:08:43', '2022-12-13 14:52:31', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (2, 'wjl', '96e79218965eb72c92a549dd5a330112', '王经理', '15000000002', 'http://r61cnlsfq.hn-bkt.clouddn.com/b09b3467-3d99-437a-bd2e-dd8c9be92bb8', 1022, 6, '', null, 1, '2022-02-08 10:35:38', '2022-12-22 10:05:03', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (3, 'lrsjl', '96e79218965eb72c92a549dd5a330112', '李人事经理', '15000000004', null, 2018, 5, '', null, 1, '2022-05-24 11:05:40', '2022-12-22 10:05:21', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (4, 'lisi', '96e79218965eb72c92a549dd5a330112', '李四', '15000000001', null, 1021, 10, 'omwf25izKON9dktgoy0dogqvnGhk', null, 1, '2022-12-06 09:32:31', '2022-12-21 09:25:06', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (5, 'zzjl', '96e79218965eb72c92a549dd5a330112', '张总经理', '15000000003', null, 10, 8, '', null, 1, '2022-12-07 16:47:00', '2022-12-22 10:05:07', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (6, 'xkfzr', '96e79218965eb72c92a549dd5a330112', '张学科', '15000000005', null, 1010, 11, null, null, 1, '2022-12-14 09:18:12', '2022-12-14 09:18:12', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (7, 'zhangsan', '96e79218965eb72c92a549dd5a330112', '张三', '15000000006', null, 1021, 10, null, null, 1, '2022-12-26 11:26:45', '2022-12-27 09:11:37', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (11, 'zhangsan01', '96e79218965eb72c92a549dd5a330112', '张三01', '15000000007', null, 1021, 10, null, null, 1, '2022-12-26 11:27:33', '2022-12-27 09:11:38', 0);
INSERT INTO generator.sys_user (id, username, password, name, phone, head_url, dept_id, post_id, open_id, description, status, create_time, update_time, is_deleted) VALUES (12, 'zhangsan02', '96e79218965eb72c92a549dd5a330112', '张三02', '15000000008', null, 1021, 10, null, null, 1, '2022-12-26 11:27:39', '2022-12-27 09:11:39', 0);
