package com.yszhdhy.generator.constant.code.sql;

public enum Role {

    ROLE_TABLE("create table sys_role\n" +
            "(\n" +
            "    id          bigint auto_increment comment '角色id'\n" +
            "        primary key,\n" +
            "    role_name   varchar(20) default ''                not null comment '角色名称',\n" +
            "    role_code   varchar(20)                           null comment '角色编码',\n" +
            "    description varchar(255)                          null comment '描述',\n" +
            "    create_time timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',\n" +
            "    update_time timestamp   default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',\n" +
            "    is_deleted  tinyint     default 0                 not null comment '删除标记（0:不可用 1:可用）'\n" +
            ")\n" +
            "    comment '角色' charset = utf8mb3;",
            "INSERT INTO sys_role (id, role_name, role_code, description, create_time, update_time, is_deleted) VALUES (1, '系统管理员', 'SYSTEM', '系统管理员', '2021-05-31 18:09:18', '2022-06-08 09:21:10', 0),\n" +
                    "(2, '普通管理员', 'COMMON', '普通管理员', '2021-06-01 08:38:40', '2022-02-24 10:42:46', 0),\n" +
                    "(8, '用户管理员', 'yhgly', null, '2022-06-08 17:39:04', '2022-06-08 17:39:04', 0),\n" +
                    "(10, '角色管理员', 'rrrr', null, '2023-04-28 08:35:13', '2023-04-28 08:35:13', 0);"),
    ;

    private String createTableSql;
    private String insertTableSql;

    Role(String createTableSql,String insertTableSql) {
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
