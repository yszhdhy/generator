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
            "    is_deleted  tinyint     default 0                 not null comment '删除标记（0:不可用 1:可用）'\n" +
            ")\n" +
            "    comment '菜单表';",
            "INSERT INTO sys_menu (id, parent_id, name, type, path, component, perms, icon, sort_value, status, create_time, update_time, is_deleted) VALUES  (2, 0, '系统管理', 0, 'system', 'Layout', null, 'el-icon-s-tools', 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:23:24', 0),\n" +
                    "(3, 2, '用户管理', 1, 'sysUser', 'system/sysUser/list', '', 'el-icon-s-custom', 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:47', 0),\n" +
                    "(4, 2, '角色管理', 1, 'sysRole', 'system/sysRole/list', '', 'el-icon-user-solid', 2, 1, '2021-05-31 18:05:37', '2022-06-09 09:37:18', 0),\n" +
                    "(5, 2, '菜单管理', 1, 'sysMenu', 'system/sysMenu/list', '', 'el-icon-s-unfold', 3, 1, '2021-05-31 18:05:37', '2022-06-09 09:37:21', 0),\n" +
                    "(6, 3, '查看', 2, null, null, 'bnt.sysUser.list', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(7, 3, '添加', 2, null, null, 'bnt.sysUser.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(8, 3, '修改', 2, null, null, 'bnt.sysUser.update', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(9, 3, '删除', 2, null, null, 'bnt.sysUser.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(10, 4, '查看', 2, null, null, 'bnt.sysRole.list', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(11, 4, '添加', 2, null, null, 'bnt.sysRole.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(12, 4, '修改', 2, null, null, 'bnt.sysRole.update', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(13, 4, '删除', 2, null, null, 'bnt.sysRole.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(14, 5, '查看', 2, null, null, 'bnt.sysMenu.list', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(15, 5, '添加', 2, null, null, 'bnt.sysMenu.add', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(16, 5, '修改', 2, null, null, 'bnt.sysMenu.update', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(17, 5, '删除', 2, null, null, 'bnt.sysMenu.remove', null, 1, 1, '2021-05-31 18:05:37', '2022-06-09 09:22:38', 0),\n" +
                    "(18, 3, '分配角色', 2, null, null, 'bnt.sysUser.assignRole', null, 1, 1, '2022-05-23 17:14:32', '2022-06-09 09:22:38', 0),\n" +
                    "(19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'bnt.sysRole.assignAuth', null, 1, 1, '2022-05-23 17:18:14', '2022-06-09 09:22:38', 0)"),
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
