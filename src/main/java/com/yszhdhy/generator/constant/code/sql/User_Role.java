package com.yszhdhy.generator.constant.code.sql;

public enum User_Role {

    USER_ROLE_TABLE("create table sys_user_role\n" +
            "(\n" +
            "    id          bigint auto_increment comment '主键id'\n" +
            "        primary key,\n" +
            "    role_id     bigint    default 0                 not null comment '角色id',\n" +
            "    user_id     bigint    default 0                 not null comment '用户id',\n" +
            "    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',\n" +
            "    update_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',\n" +
            "    is_deleted  tinyint   default 0                 not null comment '删除标记（0:不可用 1:可用）'\n" +
            ")\n" +
            "    comment '用户角色' charset = utf8mb3;",
            " INSERT INTO sys_user_role (id, role_id, user_id, create_time, update_time, is_deleted) VALUES(2, 2, 2, '2022-01-20 20:49:37', '2022-02-24 10:43:07', 0),\n" +
                    " (3, 1, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1),\n" +
                    " (4, 2, 1, '2022-05-19 10:37:27', '2022-05-24 16:55:53', 1),\n" +
                    " (5, 1, 1, '2022-05-24 16:55:53', '2022-05-24 16:55:53', 0),\n" +
                    " (6, 2, 3, '2022-05-25 16:09:31', '2022-05-25 16:09:31', 0),\n" +
                    " (7, 2, 4, '2022-06-02 11:08:14', '2022-06-02 11:15:36', 1),\n" +
                    " (8, 2, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1),\n" +
                    " (9, 1, 4, '2022-06-02 11:15:36', '2022-06-02 16:10:53', 1),\n" +
                    " (10, 1, 4, '2022-06-02 16:10:53', '2023-04-28 08:36:36', 1),\n" +
                    " (11, 10, 4, '2023-04-28 08:36:36', '2023-04-28 08:36:36', 0);"),
    ;

    private String createTableSql;
    private String insertTableSql;

    User_Role(String createTableSql,String insertTableSql) {
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
