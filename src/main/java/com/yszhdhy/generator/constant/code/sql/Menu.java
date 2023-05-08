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
                    "(19, 4, '分配权限', 2, 'assignAuth', 'system/sysRole/assignAuth', 'bnt.sysRole.assignAuth', null, 1, 1, '2022-05-23 17:18:14', '2022-06-09 09:22:38', 0),\n" +
                    "(20, 2, '部门管理', 1, 'sysDept', 'system/sysDept/list', '', 'el-icon-s-operation', 4, 1, '2022-05-24 10:07:05', '2022-06-09 09:38:12', 0),\n" +
                    "(21, 20, '查看', 2, null, null, 'bnt.sysDept.list', null, 1, 1, '2022-05-24 10:07:44', '2022-06-09 09:22:38', 0),\n" +
                    "(22, 2, '岗位管理', 1, 'sysPost', 'system/sysPost/list', '', 'el-icon-more-outline', 5, 1, '2022-05-24 10:25:30', '2022-06-09 09:38:13', 0),\n" +
                    "(23, 22, '查看', 2, null, null, 'bnt.sysPost.list', null, 1, 1, '2022-05-24 10:25:45', '2022-06-09 09:22:38', 0),\n" +
                    "(24, 20, '添加', 2, null, null, 'bnt.sysDept.add', null, 1, 1, '2022-05-25 15:31:27', '2022-06-09 09:22:38', 0),\n" +
                    "(25, 20, '修改', 2, null, null, 'bnt.sysDept.update', null, 1, 1, '2022-05-25 15:31:41', '2022-06-09 09:22:38', 0),\n" +
                    "(26, 20, '删除', 2, null, null, 'bnt.sysDept.remove', null, 1, 1, '2022-05-25 15:31:59', '2022-06-09 09:22:38', 0),\n" +
                    "(27, 22, '添加', 2, null, null, 'bnt.sysPost.add', null, 1, 1, '2022-05-25 15:32:44', '2022-06-09 09:22:38', 0),\n" +
                    "(28, 22, '修改', 2, null, null, 'bnt.sysPost.update', null, 1, 1, '2022-05-25 15:32:58', '2022-06-09 09:22:38', 0),\n" +
                    "(29, 22, '删除', 2, null, null, 'bnt.sysPost.remove', null, 1, 1, '2022-05-25 15:33:11', '2022-06-09 09:22:38', 0),\n" +
                    "(30, 34, '操作日志', 1, 'sysOperLog', 'system/sysOperLog/list', '', 'el-icon-document-remove', 7, 1, '2022-05-26 16:09:59', '2022-06-09 09:39:23', 0),\n" +
                    "(31, 30, '查看', 2, null, null, 'bnt.sysOperLog.list', null, 1, 1, '2022-05-26 16:10:17', '2022-06-09 09:22:38', 0),\n" +
                    "(32, 34, '登录日志', 1, 'sysLoginLog', 'system/sysLoginLog/list', '', 'el-icon-s-goods', 8, 1, '2022-05-26 16:36:13', '2022-06-09 09:39:24', 0),\n" +
                    "(33, 32, '查看', 2, null, null, 'bnt.sysLoginLog.list', null, 1, 1, '2022-05-26 16:36:31', '2022-06-09 09:36:36', 0),\n" +
                    "(34, 2, '日志管理', 0, 'log', 'ParentView', '', 'el-icon-tickets', 6, 1, '2022-05-31 13:23:07', '2022-06-09 09:39:22', 0),\n" +
                    "(35, 0, '审批设置', 0, 'processSet', 'Layout', '', 'el-icon-setting', 1, 1, '2022-12-01 09:32:46', '2022-12-01 09:32:46', 0),\n" +
                    "(36, 35, '审批模板', 1, 'processTemplate', 'processSet/processTemplate/list', '', 'el-icon-s-help', 2, 1, '2022-12-01 09:37:08', '2022-12-19 14:10:48', 0),\n" +
                    "(37, 36, '查看', 2, '', '', 'bnt.processTemplate.list', '', 1, 1, '2022-12-01 09:37:49', '2022-12-01 09:37:49', 0),\n" +
                    "(38, 36, '审批模板设置', 2, 'templateSet', 'processSet/processTemplate/templateSet', 'bnt.processTemplate.templateSet', '', 1, 1, '2022-12-01 14:52:08', '2022-12-13 18:11:56', 0),\n" +
                    "(39, 35, '审批类型', 1, 'processType', 'processSet/processType/list', '', 'el-icon-s-unfold', 1, 1, '2022-12-02 14:46:18', '2022-12-13 18:12:24', 0),\n" +
                    "(40, 39, '查看', 2, '', '', 'bnt.processType.list', '', 1, 1, '2022-12-02 14:46:41', '2022-12-02 14:46:41', 0),\n" +
                    "(41, 0, '审批管理', 0, 'processMgr', 'Layout', '', 'el-icon-more-outline', 1, 1, '2022-12-02 14:48:11', '2022-12-20 09:29:30', 0),\n" +
                    "(42, 41, '审批列表', 1, 'process', 'processMgr/process/list', '', 'el-icon-document-remove', 1, 1, '2022-12-02 14:49:06', '2022-12-02 14:59:17', 0),\n" +
                    "(43, 42, '查看', 2, '', '', 'bnt.process.list', '', 1, 1, '2022-12-02 14:49:24', '2022-12-02 14:49:24', 0),\n" +
                    "(44, 36, '在线流程设置', 2, 'onlineProcessSet', 'processSet/processTemplate/onlineProcessSet', 'bnt.processTemplate.onlineProcessSet', '', 1, 1, '2022-12-08 10:13:15', '2022-12-19 18:57:35', 0),\n" +
                    "(45, 39, '添加', 2, '', '', 'bnt.processType.add', '', 1, 1, '2022-12-09 09:14:53', '2022-12-09 09:14:53', 0),\n" +
                    "(46, 39, '修改', 2, '', '', 'bnt.processType.update', '', 1, 1, '2022-12-09 09:15:10', '2022-12-09 09:15:10', 0),\n" +
                    "(47, 39, '删除', 2, '', '', 'bnt.processType.remove', '', 1, 1, '2022-12-09 09:15:25', '2022-12-09 09:15:25', 0),\n" +
                    "(48, 36, '删除', 2, '', '', 'bnt.processTemplate.remove', '', 1, 1, '2022-12-09 09:22:29', '2022-12-09 09:22:29', 0),\n" +
                    "(49, 36, '发布', 2, '', '', 'bnt.processTemplate.publish', '', 1, 1, '2022-12-09 09:24:47', '2022-12-09 09:24:47', 0),\n" +
                    "(50, 0, '公众号菜单', 0, 'wechat', 'Layout', '', 'el-icon-s-operation', 1, 1, '2022-12-13 09:06:58', '2022-12-21 11:20:55', 0),\n" +
                    "(51, 50, '菜单列表', 1, 'menu', 'wechat/menu/list', '', 'el-icon-s-help', 1, 1, '2022-12-13 09:07:52', '2022-12-13 09:09:49', 0),\n" +
                    "(52, 51, '查看', 2, '', '', 'bnt.menu.list', '', 1, 1, '2022-12-13 09:08:48', '2022-12-13 17:58:23', 0),\n" +
                    "(53, 51, '添加', 2, '', '', 'bnt.menu.add', '', 1, 1, '2022-12-13 16:29:25', '2022-12-13 17:58:34', 0),\n" +
                    "(54, 51, '修改', 2, '', '', 'bnt.menu.update', '', 1, 1, '2022-12-13 16:29:41', '2022-12-13 17:58:42', 0),\n" +
                    "(55, 51, '删除', 2, '', '', 'bnt.menu.remove', '', 1, 1, '2022-12-13 16:29:59', '2022-12-13 17:58:47', 0),\n" +
                    "(56, 51, '删除微信菜单', 2, '', '', 'bnt.menu.removeMenu', '', 1, 1, '2022-12-13 16:30:36', '2022-12-13 17:58:54', 0),\n" +
                    "(57, 51, '同步微信菜单', 2, '', '', 'bnt.menu.syncMenu', '', 1, 1, '2022-12-13 16:31:00', '2022-12-13 17:59:01', 0),\n" +
                    "(58, 50, 'fff', 1, '', '', '', '', 0, 1, '2023-04-27 11:40:19', '2023-04-27 11:40:30', 1);"),
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
