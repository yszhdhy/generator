package com.yszhdhy.generator.constant.code.sql;

public enum Menu implements SqlCodeTemplate{

    MENU_TABLE("create table sys_menu\n" +
            "(\n" +
            "    id          bigint auto_increment comment '编号'\n" +
            "        primary key,\n" +
            "    parent_id   bigint      default 0                 not null comment '所属上级',\n" +
            "    name        varchar(20) default ''                not null comment '名称',\n" +
            "    type        tinyint     default 0                 not null comment '类型(0:目录,1:菜单,2:按钮)',\n" +
            "    path        varchar(100)                          null comment '路由地址',\n" +
            "    component   varchar(100)                          null comment '组件路径',\n" +
            "    perms       varchar(100)                          null comment '权限标识',\n" +
            "    icon        varchar(100)                          null comment '图标',\n" +
            "    sort_value  int                                   null comment '排序',\n" +
            "    status      tinyint                               null comment '状态(0:禁止,1:正常)',\n" +
            "    create_time timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',\n" +
            "    update_time timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',\n" +
            "    is_deleted  tinyint     default 0                 not null comment '删除标记（0:不可用 1:可用）',\n" +
            "    route_name  varchar(255)                          null comment '路由名称',\n" +
            "    redirect    varchar(255)                          null comment '路由重定向',\n"+
            "    vue2_icon   varchar(255)                          null comment 'vue2图标'\n"+
            ")\n" +
            "    comment '菜单表';",
            " INSERT INTO sys_menu (id, parent_id, name, type, path, component, perms, icon, sort_value, status, create_time, update_time, is_deleted, route_name, redirect, vue2_icon) VALUES (2, 0, '系统管理', 0, 'system', 'layout/index', null, 'Lock', 2, 1, '2021-05-31 00:00:00', '2023-07-23 18:03:05', 0, 'System', '/system/sysUser', 'el-icon-s-tools'),\n" +
                    " (3, 2, '用户管理', 1, '/system/sysUser', 'system/sysUser/index', '', 'User', 3, 1, '2021-05-31 00:00:00', '2023-07-23 18:03:05', 0, 'SysUser', null, 'el-icon-s-custom'),\n" +
                    " (4, 2, '角色管理', 1, '/system/sysRole', 'system/sysRole/index', '', 'Avatar', 2, 1, '2021-05-31 00:00:00', '2023-07-23 18:03:05', 0, 'SysRole', null, 'el-icon-user-solid'),\n" +
                    " (5, 2, '菜单管理', 1, '/system/sysMenu', 'system/sysMenu/index', '', 'List', 3, 1, '2021-05-31 00:00:00', '2023-07-23 18:03:05', 0, 'SysMenu', null, 'el-icon-s-unfold'),\n" +
                    " (6, 3, '查看', 2, null, null, 'bnt.sysUser.list', null, 1, 1, '2021-05-31 18:05:37', '2023-07-20 11:30:19', 0, '', null, null),\n" +
                    " (7, 3, '添加', 2, null, null, 'bnt.sysUser.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (8, 8, '修改', 2, '', null, 'bnt.sysUser.update', null, 1, 1, '2021-05-31 00:00:00', '2023-07-20 11:34:22', 0, '', null, null),\n" +
                    " (9, 3, '删除', 2, null, null, 'bnt.sysUser.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (10, 4, '查看', 2, null, null, 'bnt.sysRole.list', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (11, 4, '添加', 2, null, null, 'bnt.sysRole.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (12, 4, '修改', 2, null, null, 'bnt.sysRole.update', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (13, 4, '删除', 2, null, null, 'bnt.sysRole.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (14, 5, '查看', 2, null, null, 'bnt.sysMenu.list', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (15, 5, '添加', 2, null, null, 'bnt.sysMenu.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (16, 5, '修改', 2, null, null, 'bnt.sysMenu.update', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (17, 5, '删除', 2, null, null, 'bnt.sysMenu.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0, '', null, null),\n" +
                    " (18, 3, '分配角色', 2, null, null, 'bnt.sysUser.assignRole', null, 1, 1, '2022-05-23 17:14:32', '2023-07-20 11:30:15', 0, '', null, null),\n" +
                    " (19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'bnt.sysRole.assignAuth', null, 1, 1, '2022-05-23 17:18:14', '2023-07-23 13:54:29', 0, '', null, null),\n" +
                    " (20, 2, '权限管理', 0, '/home/getCountData', 'ParentView', '', 'el-icon-s-custom', 1, 1, '2023-07-19 20:29:34', '2023-07-21 21:53:06', 1, null, null, null),\n" +
                    " (21, 20, '权限', 1, '/home/getCountData', 'hoome', '', 'el-icon-s-tools', 1, 1, '2023-07-19 20:30:34', '2023-07-19 20:37:26', 1, null, null, null),\n" +
                    " (22, 2, '权限管理', 0, '/home/getCountData', 'ParentView', '', 'el-icon-s-tools', 1, 1, '2023-07-19 20:38:14', '2023-07-19 21:47:07', 1, null, null, null),\n" +
                    " (23, 4, 'q', 2, '', '', '', '', 1, 0, '2023-07-19 21:48:41', '2023-07-19 21:48:48', 1, null, null, null),\n" +
                    " (24, 2, '1', 1, '', '', '', '', 1, 1, '2023-07-19 21:54:07', '2023-07-19 21:54:12', 1, null, null, null),\n" +
                    " (25, 2, 'menu', 1, 'sendecho', 'system/Sendecho/Sendechoindex', '', 'el-icon-s-tools', 1, 1, '2023-07-20 11:41:47', '2023-07-20 15:39:17', 1, null, null, null),\n" +
                    " (26, 3, '修改', 2, '/home/getCountData', '/getCountData', '123', '', 1, 1, '2021-05-31 00:00:00', '2023-07-20 15:27:46', 1, 'System', null, null)"
            )

    ;


    private String createTableSql;
    private String insertTableSql;

    Menu(String createTableSql,String insertTableSql) {
        this.createTableSql = createTableSql;
        this.insertTableSql = insertTableSql;
    }

    public String getCreateTableSql() {
        return createTableSql;
    }

    public String getInsertTableSql() {
        return insertTableSql;
    }
}
