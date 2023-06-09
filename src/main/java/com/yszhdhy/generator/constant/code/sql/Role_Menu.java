package com.yszhdhy.generator.constant.code.sql;

public enum Role_Menu {

    ROLE_MENU_TABLE("create table sys_role_menu\n" +
            "(\n" +
            "    id          bigint auto_increment\n" +
            "        primary key,\n" +
            "    role_id     bigint    default 0                 not null,\n" +
            "    menu_id     bigint    default 0                 not null,\n" +
            "    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',\n" +
            "    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',\n" +
            "    is_deleted  tinyint   default 0                 not null comment '删除标记（0:不可用 1:可用）'\n" +
            ")\n" +
            "    comment '角色菜单' charset = utf8mb3;",
            " INSERT INTO sys_role_menu (id, role_id, menu_id, create_time, update_time, is_deleted) VALUES(1, 2, 2, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (2, 2, 3, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (3, 2, 6, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (4, 2, 7, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (5, 2, 8, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (6, 2, 9, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (7, 2, 18, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (8, 2, 4, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (9, 2, 10, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (10, 2, 11, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (11, 2, 12, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (12, 2, 13, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (13, 2, 19, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (14, 2, 5, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (15, 2, 14, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (16, 2, 15, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (17, 2, 16, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (18, 2, 17, '2022-06-02 16:11:27', '2022-06-02 16:16:10', 1),\n" +
                    " (19, 2, 2, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),\n" +
                    " (20, 2, 3, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),\n" +
                    " (21, 2, 6, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),\n" +
                    " (22, 2, 7, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),\n" +
                    " (23, 2, 8, '2022-06-02 16:16:10', '2022-06-09 09:26:34', 1),\n" +
                    " (24, 2, 2, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (25, 2, 3, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (26, 2, 6, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (27, 2, 7, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (28, 2, 8, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (29, 2, 5, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (30, 2, 14, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (31, 2, 20, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (32, 2, 21, '2022-06-09 09:26:34', '2022-06-09 09:26:34', 0),\n" +
                    " (33, 10, 2, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0),\n" +
                    " (34, 10, 4, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0),\n" +
                    " (35, 10, 10, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0),\n" +
                    " (36, 10, 11, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0),\n" +
                    " (37, 10, 12, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0),\n" +
                    " (38, 10, 19, '2023-04-28 08:37:00', '2023-04-28 08:37:00', 0);"),
    ;

    private String createTableSql;
    private String insertTableSql;

    Role_Menu(String createTableSql,String insertTableSql) {
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
