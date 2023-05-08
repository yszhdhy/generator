package com.yszhdhyBoot.demo.constant.code;


import com.yszhdhyBoot.demo.utils.PomUtils;

/**
 * @author makeronbean
 * @createDate 2023-05-01  16:19
 * @description
 */
@SuppressWarnings("all")
public enum MyBatisPlusCodeConst implements CodeTemplate {
    META_OBJECT_HANDLER("config/mybatis","CommonMetaObjectHandler.java","%s\n\n" +
            "import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;\n" +
            "import org.apache.ibatis.reflection.MetaObject;\n" +
            "import org.springframework.stereotype.Component;\n" +
            "\n" +
            "import java.util.Date;\n" +
            "\n" +
            "@Component\n" +
            "public class CommonMetaObjectHandler implements MetaObjectHandler {\n" +
            "    /**\n" +
            "     * 新增时自动填充\n" +
            "     */\n" +
            "    @Override\n" +
            "    public void insertFill(MetaObject metaObject) {\n" +
            "        //参数1:元数据对象\n" +
            "        //参数2:类属性名称\n" +
            "        //参数3:类对象\n" +
            "        //参数4:当前系统时间\n" +
            "        this.strictInsertFill(metaObject, \"createTime\", Date.class, new Date());\n" +
            "        this.strictUpdateFill(metaObject, \"updateTime\", Date.class, new Date());\n" +
            "    }\n" +
            "    \n" +
            "    /**\n" +
            "     * 修改时自动填充\n" +
            "     */\n" +
            "    @Override\n" +
            "    public void updateFill(MetaObject metaObject) {\n" +
            "        this.strictUpdateFill(metaObject, \"updateTime\", Date.class, new Date());\n" +
            "    }\n" +
            "}"),

    MYBATIS_CONFIG("config/mybatis", "MybatisConfig.java", "%s\n\n" +
            "import com.baomidou.mybatisplus.annotation.DbType;\n" +
            "import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;\n" +
            "import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;\n" +
            "import org.springframework.context.annotation.Bean;\n" +
            "import org.mybatis.spring.annotation.MapperScan;\n" +
            "import org.springframework.context.annotation.Configuration;\n" +
            "\n" +
            "@Configuration\n" +
            "@MapperScan(\""+ PomUtils.getSingleValue("groupId") +".mapper\")\n" +
            "public class MybatisConfig {\n" +
            "    \n" +
            "    /**\n" +
            "     * 配置：分页插件\n" +
            "     */\n" +
            "    @Bean\n" +
            "    public MybatisPlusInterceptor mybatisPlusInterceptor() {\n" +
            "        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();\n" +
            "        // 指定数据库类型\n" +
            "        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);\n" +
            "        // 溢出后从第1页开始\n" +
            "        paginationInnerInterceptor.setOverflow(true);\n" +
            "        interceptor.addInnerInterceptor(paginationInnerInterceptor);\n" +
            "        return interceptor;\n" +
            "    }\n" +
            "}")

    ;
    private final String path;
    private final String fileName;
    private final String codeTemplate;

    MyBatisPlusCodeConst(String path, String fileName, String codeTemplate) {
        this.path = path;
        this.fileName = fileName;
        this.codeTemplate = codeTemplate;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getCodeTemplate() {
        return codeTemplate;
    }
}
