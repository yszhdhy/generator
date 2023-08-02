package com.yszhdhy.generator.constant.templateParameters;

import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.model.dto.TemplateParametersDto;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.SystemUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @project generator
 * @description 关于创建模板代码的参数等
 * @author capture or new
 * @date 2023/7/22 13:26:21
 * @version 1.0
 */
public enum TemplateParametersList {

    SECURITY_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "WebSecurityConfig.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/config/WebSecurityConfig.java",
                    "/common/common-security/config"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("commonUtilPackageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "CustomMd5PasswordEncoder.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/custom/CustomMd5PasswordEncoder.java",
                    "/common/common-security/custom"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("modelPackageName", ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "CustomUser.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/custom/CustomUser.java",
                    "/common/common-security/custom"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "LoginUserInfoHelper.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/custom/LoginUserInfoHelper.java",
                    "/common/common-security/custom"),


            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "UserDetailsService.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/custom/UserDetailsService.java",
                    "/common/common-security/custom"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("commonUtilPackageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "TokenAuthenticationFilter.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/filter/TokenAuthenticationFilter.java",
                    "/common/common-security/filter"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("commonUtilPackageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("modelPackageName", ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "TokenLoginFilter.ftl",
                    PackagePath.PACKAGE_COMMON_SECURITY_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId() + "/filter/TokenLoginFilter.java",
                    "/common/common-security/filter"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("securityPackageName", ModuleGroupId.MODULE_COMMON_SECURITY_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("modelPackageName", ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "UserDetailsServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId() + "/service/impl/UserDetailsServiceImpl.java",
                    "/common/common-security/serviceImpl"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "ResponseUtil.ftl",
                    PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId() + "/result/ResponseUtil.java",
                    "/common/common-security/commonUtilResult")

    )),


    MINIO_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "MinIOConfig.ftl",
                    PackagePath.PACKAGE_COMMON_MINIO_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/config/MinIOConfig.java",
                    "/common/common-minio/config"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "MinIOConfigProperties.ftl",
                    PackagePath.PACKAGE_COMMON_MINIO_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/config/MinIOConfigProperties.java",
                    "/common/common-minio/config"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "FileStorageService.ftl",
                    PackagePath.PACKAGE_COMMON_MINIO_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/service/FileStorageService.java",
                    "/common/common-minio/service"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "MinIOFileStorageService.ftl",
                    PackagePath.PACKAGE_COMMON_MINIO_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/service/impl/MinIOFileStorageService.java",
                    "/common/common-minio/service/impl"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("CommonUtilPackageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("CommonMinioPackageName", ModuleGroupId.MODULE_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "FileController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId() + "/controller/FileController.java",
                    "/common/common-minio/controller")

    )),

    ELASTICSEARCH_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "ElasticsearchConfig.ftl",
                    PackagePath.PACKAGE_COMMON_ELASTICSEARCH_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/config/ElasticsearchConfig.java",
                    "/common/common-elasticsearch/config"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "Order.ftl",
                    PackagePath.PACKAGE_COMMON_ELASTICSEARCH_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/pojo/Order.java",
                    "/common/common-elasticsearch/pojo"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "OrderRepository.ftl",
                    PackagePath.PACKAGE_COMMON_ELASTICSEARCH_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/repository/OrderRepository.java",
                    "/common/common-elasticsearch/repository"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "OrderService.ftl",
                    PackagePath.PACKAGE_COMMON_ELASTICSEARCH_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/service/OrderService.java",
                    "/common/common-elasticsearch/service"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "OrderServiceImpl.ftl",
                    PackagePath.PACKAGE_COMMON_ELASTICSEARCH_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId() + "/service/impl/OrderServiceImpl.java",
                    "/common/common-elasticsearch/service"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
                put("CommonElasticsearchPackageName", ModuleGroupId.ELASTICSEARCH_COMMON_MINIO_GROUP_ID.getModuleGroupId().replaceAll("/", "\\."));
            }}, "DocController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath() + "/src/main/java/" + ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId() + "/controller/DocController.java",
                    "/common/common-elasticsearch/controller")
    )),


    COMMON_UTIL_TEMPLATE_PARAMETERS_LIST(Arrays.asList(

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".jwt;");
            }}, "JwtHelper.ftl",
                    PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/jwt/JwtHelper.java",
                    "/common-util"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".utils;");
            }}, "MD5.ftl",
                    PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/utils/MD5.java",
                    "/common-util"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".result;");
            }}, "Result.ftl",
                    PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/result/Result.java",
                    "/common-util"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName", ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".result;");
            }}, "ResultCodeEnum.ftl",
                    PackagePath.PACKAGE_COMMON_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId()+"/result/ResultCodeEnum.java",
                    "/common-util")

    )),


    SERVICE_UTIL_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".exception;");
                put("packageNameResult",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".result.Result");
            }}, "GlobalExceptionHandler.ftl",
                    PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/exception/GlobalExceptionHandler.java",
                    "/service-util"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".exception;");
                put("packageNameResultCodeEnum",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".result.ResultCodeEnum");
            }}, "GuiguException.ftl",
                    PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/exception/GuiguException.java",
                    "/service-util"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".knife4j;");
                put("path", "\"/admin/.*\"");
            }}, "Knife4jConfig.ftl",
                    PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/knife4j/Knife4jConfig.java",
                    "/service-util"),


            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mp;");
                put("basePackages","\"" + ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper\"");
            }}, "MybatisPlusConfig.ftl",
                    PackagePath.PACKAGE_SERVICE_UTIL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_UTIL_GROUP_ID.getModuleGroupId()+"/mp/MybatisPlusConfig.java",
                    "/service-util")
    )),

    MODEL_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "BaseEntity.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/BaseEntity.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysLoginLog.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysLoginLog.java",
                    "/model/model/system"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysMenu.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysMenu.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysOperLog.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysOperLog.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysPost.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysPost.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysRole.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysRole.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysRoleMenu.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysRoleMenu.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysUser.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysUser.java",
                    "/model/model/system"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".model");
            }}, "SysUserRole.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/model/SysUserRole.java",
                    "/model/model/system"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "AssginMenuVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/AssginMenuVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "AssginRoleVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/AssginRoleVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "LoginVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/LoginVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "MetaVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/MetaVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "RouterVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/RouterVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "SysLoginLogQueryVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/SysLoginLogQueryVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "SysOperLogQueryVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/SysOperLogQueryVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "SysPostQueryVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/SysPostQueryVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "SysRoleQueryVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/SysRoleQueryVo.java",
                    "/model/model/vo"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".vo");
            }}, "SysUserQueryVo.ftl",
                    PackagePath.PACKAGE_MODEL_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId()+"/vo/SysUserQueryVo.java",
                    "/model/model/vo")
    )),


    GENERATORCURD_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.controller");
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD");
            }}, "SysGeneratorController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/controller/SysGeneratorController.java",
                    "/generatorCRUD/controller"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.dao");
            }}, "MySQLGeneratorDaoXml.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/dao/mapper/MySQLGeneratorDao.xml",
                    "/generatorCRUD/dao/mapper"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.dao");
            }}, "GeneratorDao.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/dao/GeneratorDao.java",
                    "/generatorCRUD/dao"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.dao");
            }}, "MySQLGeneratorDao.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/dao/MySQLGeneratorDao.java",
                    "/generatorCRUD/dao"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.entity");
            }}, "ColumnEntity.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/entity/ColumnEntity.java",
                    "/generatorCRUD/entity"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.entity");
            }}, "TableEntity.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/entity/TableEntity.java",
                    "/generatorCRUD/entity"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.service");
                put("packageNameDao",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD");
                put("packageNameUtils",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysGeneratorService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/service/SysGeneratorService.java",
                    "/generatorCRUD/service"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD.utils");
                put("packageNameEntity",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".generatorCRUD");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "GenUtils.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/utils/GenUtils.java",
                    "/generatorCRUD/utils"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageCommonUtilName",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageModelName",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "CRUDPageWeb.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/generatorCRUD/web/CRUDPageWeb.java",
                    "/generatorCRUD/web")
    )),


    SERVICE_TEMPLATE_PARAMETERS_LIST(Arrays.asList(
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".controller");
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "IndexController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller/IndexController.java",
                    "/service/controller"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".controller");
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysMenuController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller/SysMenuController.java",
                    "/service/controller"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".controller");
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller/SysRoleController.java",
                    "/service/controller"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".controller");
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserController.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/controller/SysUserController.java",
                    "/service/controller"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysMenuMapperXml.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/xml/SysMenuMapper.xml",
                    "/service/mapper/xml"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleMenuMapperXml.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/xml/SysRoleMenuMapperXml.xml",
                    "/service/mapper/xml"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserMapperXml.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/xml/SysUserMapperXml.xml",
                    "/service/mapper/xml"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserRoleMapperXml.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/xml/SysUserRoleMapperXml.xml",
                    "/service/mapper/xml"),


            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysMenuMapper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysMenuMapper.java",
                    "/service/mapper"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleMapper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysRoleMapper.java",
                    "/service/mapper"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleMenuMapper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysRoleMenuMapper.java",
                    "/service/mapper"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserMapper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysUserMapper.java",
                    "/service/mapper"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".mapper");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserRoleMapper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/mapper/SysUserRoleMapper.java",
                    "/service/mapper"),

            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysMenuServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/SysMenuServiceImpl.java",
                    "/service/service/impl"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleMenuServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/SysRoleMenuServiceImpl.java",
                    "/service/service/impl"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/SysRoleServiceImpl.java",
                    "/service/service/impl"),
//            new TemplateParametersDto(new HashMap<String, Object>() {{
//                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
//                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
//                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
//                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
//                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
//            }}, "UserDetailsServiceImpl.ftl",
//                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/UserDetailsServiceImpl.java",
//                    "/service/service/impl"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserRoleServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/SysUserRoleServiceImpl.java",
                    "/service/service/impl"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameService",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommon",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameCommonService",  ModuleGroupId.MODULE_COMMON_UTIL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserServiceImpl.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/impl/SysUserServiceImpl.java",
                    "/service/service/impl"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".service");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysMenuService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/SysMenuService.java",
                    "/service/service"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".service");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleMenuService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/SysRoleMenuService.java",
                    "/service/service"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".service");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysRoleService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/SysRoleService.java",
                    "/service/service"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".service");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserRoleService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/SysUserRoleService.java",
                    "/service/service"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\.")+".service");
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "SysUserService.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/service/SysUserService.java",
                    "/service/service"),
            new TemplateParametersDto(new HashMap<String, Object>() {{
                put("packageName",  ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
                put("packageNameModel",  ModuleGroupId.MODULE_MODEL_GROUP_ID.getModuleGroupId().replaceAll("/","\\."));
            }}, "MenuHelper.ftl",
                    PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId()+"/utils/MenuHelper.java",
                    "/service/utils")
    )),


    VUE_TEMPLATE_PACKAGES_LIST(Arrays.asList(
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/build/index.js",
                    "/vue/build"),
            new TemplateParametersDto(null,"favicon.ftl",
                    SystemUtils.getProjectPath()+"/vue/public/favicon.ico",
                    "/vue/public"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/public/index.html",
                    "/vue/public"),

            new TemplateParametersDto(null,"sysMenu.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/api/system/sysMenu.js",
                    "/vue/src/api/system"),
            new TemplateParametersDto(null,"sysRole.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/api/system/sysRole.js",
                    "/vue/src/api/system"),
            new TemplateParametersDto(null,"sysUser.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/api/system/sysUser.js",
                    "/vue/src/api/system"),

            new TemplateParametersDto(null,"table.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/api/table.js",
                    "/vue/src/api"),
            new TemplateParametersDto(null,"user.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/api/user.js",
                    "/vue/src/api"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/components/Breadcrumb/index.vue",
                    "/vue/src/components/Breadcrumb"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/components/Hamburger/index.vue",
                    "/vue/src/components/Hamburger"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/components/ParentView/index.vue",
                    "/vue/src/components/ParentView"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue/src/components/SvgIcon/index.vue",
                    "/vue/src/components/SvgIcon"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath() + "/vue/src/icons/index.js",
                    "/vue/src/icons"),
            new TemplateParametersDto(null,"svgo.ftl",
                    SystemUtils.getProjectPath() + "/vue/src/icons/svgo.js",
                    "/vue/src/icons")
    )),



    VUE3_TEMPLATE_PACKAGES_LIST(Arrays.asList(
            new TemplateParametersDto(null,"vite.ftl",
                    SystemUtils.getProjectPath()+"/vue3/public/vite.svg",
                    "/vue3/public"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/menu/index.ts",
                    "/vue3/src/api/system/menu"),
            new TemplateParametersDto(null,"type.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/menu/type.ts",
                    "/vue3/src/api/system/menu"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/role/index.ts",
                    "/vue3/src/api/system/role"),
            new TemplateParametersDto(null,"type.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/role/type.ts",
                    "/vue3/src/api/system/role"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/user/index.ts",
                    "/vue3/src/api/system/user"),
            new TemplateParametersDto(null,"type.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/system/user/type.ts",
                    "/vue3/src/api/system/user"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/user/index.ts",
                    "/vue3/src/api/user"),
            new TemplateParametersDto(null,"type.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/api/user/type.ts",
                    "/vue3/src/api/user"),

            new TemplateParametersDto(null,"login_background.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/assets/images/login_background.jpg",
                    "/vue3/src/assets/images"),
            new TemplateParametersDto(null,"login_left.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/assets/images/login_left.svg",
                    "/vue3/src/assets/images"),
            new TemplateParametersDto(null,"vue.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/assets/vue.svg",
                    "/vue3/src/assets"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/components/ParentView/index.vue",
                    "/vue3/src/components/ParentView"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/components/VerifyCode/index.vue",
                    "/vue3/src/components/VerifyCode"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/components/index.ts",
                    "/vue3/src/components"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/logo/index.vue",
                    "/vue3/src/layout/logo"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/main/index.vue",
                    "/vue3/src/layout/main"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/menu/index.vue",
                    "/vue3/src/layout/menu"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/tabbar/breadcrumb/index.vue",
                    "/vue3/src/layout/tabbar/breadcrumb"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/tabbar/setting/index.vue",
                    "/vue3/src/layout/tabbar/setting"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/tabbar/index.vue",
                    "/vue3/src/layout/tabbar"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/layout/index.vue",
                    "/vue3/src/layout"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/router/index.ts",
                    "/vue3/src/router"),
            new TemplateParametersDto(null,"routes.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/router/routes.ts",
                    "/vue3/src/router"),

            new TemplateParametersDto(null,"types.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/store/modules/types/types.ts",
                    "/vue3/src/store/modules/types"),
            new TemplateParametersDto(null,"setting.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/store/modules/setting.ts",
                    "/vue3/src/store/modules"),
            new TemplateParametersDto(null,"user.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/store/modules/user.ts",
                    "/vue3/src/store/modules"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/store/index.ts",
                    "/vue3/src/store"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/styles/index.scss",
                    "/vue3/src/styles"),
            new TemplateParametersDto(null,"newLogin.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/styles/newLogin.scss",
                    "/vue3/src/styles"),
            new TemplateParametersDto(null,"reset.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/styles/reset.scss",
                    "/vue3/src/styles"),
            new TemplateParametersDto(null,"variable.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/styles/variable.scss",
                    "/vue3/src/styles"),

            new TemplateParametersDto(null,"request.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/utils/request.ts",
                    "/vue3/src/utils"),
            new TemplateParametersDto(null,"time.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/utils/time.ts",
                    "/vue3/src/utils"),
            new TemplateParametersDto(null,"token.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/utils/token.ts",
                    "/vue3/src/utils"),

            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/404/index.vue",
                    "/vue3/src/views/404"),
            new TemplateParametersDto(null,"echartsLine.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/dashboard/dashboardCharts/echartsLine.vue",
                    "/vue3/src/views/dashboard/dashboardCharts"),
            new TemplateParametersDto(null,"dashboardTable.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/dashboard/dashboardTable/dashboardTable.vue",
                    "/vue3/src/views/dashboard/dashboardTable"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/dashboard/index.vue",
                    "/vue3/src/views/dashboard"),
            new TemplateParametersDto(null,"weather.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/dashboard/weather.ts",
                    "/vue3/src/views/dashboard"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/login/index.vue",
                    "/vue3/src/views/login"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/system/sysMenu/index.vue",
                    "/vue3/src/views/system/sysMenu"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/system/sysRole/index.vue",
                    "/vue3/src/views/system/sysRole"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/views/system/sysUser/index.vue",
                    "/vue3/src/views/system/sysUser"),

            new TemplateParametersDto(null,"App.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/App.vue",
                    "/vue3/src"),
            new TemplateParametersDto(null,"components.d.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/components.d.ts",
                    "/vue3/src"),
            new TemplateParametersDto(null,"main.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/main.ts",
                    "/vue3/src"),
            new TemplateParametersDto(null,"permission.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/permission.ts",
                    "/vue3/src"),
            new TemplateParametersDto(null,"setting.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/setting.ts",
                    "/vue3/src"),
            new TemplateParametersDto(null,"vite-env.d.ftl",
                    SystemUtils.getProjectPath()+"/vue3/src/vite-env.d.ts",
                    "/vue3/src"),

            new TemplateParametersDto(null,".env.development.ftl",
                    SystemUtils.getProjectPath()+"/vue3/.env.development",
                    "/vue3"),
            new TemplateParametersDto(null,".env.production.ftl",
                    SystemUtils.getProjectPath()+"/vue3/.env.production",
                    "/vue3"),
            new TemplateParametersDto(null,".env.test.ftl",
                    SystemUtils.getProjectPath()+"/vue3/.env.test",
                    "/vue3"),
            new TemplateParametersDto(null,".gitignore.ftl",
                    SystemUtils.getProjectPath()+"/vue3/.gitignore",
                    "/vue3"),
            new TemplateParametersDto(null,"index.ftl",
                    SystemUtils.getProjectPath()+"/vue3/index.html",
                    "/vue3"),
            new TemplateParametersDto(null,"package.ftl",
                    SystemUtils.getProjectPath()+"/vue3/package.json",
                    "/vue3"),
            new TemplateParametersDto(null,"pnpm-lock.ftl",
                    SystemUtils.getProjectPath()+"/vue3/pnpm-lock.yaml",
                    "/vue3"),
            new TemplateParametersDto(null,"README.ftl",
                    SystemUtils.getProjectPath()+"/vue3/README.md",
                    "/vue3"),
            new TemplateParametersDto(null,"tsconfig.ftl",
                    SystemUtils.getProjectPath()+"/vue3/tsconfig.json",
                    "/vue3"),
            new TemplateParametersDto(null,"tsconfig.node.ftl",
                    SystemUtils.getProjectPath()+"/vue3/tsconfig.node.json",
                    "/vue3"),
            new TemplateParametersDto(null,"vite.config.ftl",
                    SystemUtils.getProjectPath()+"/vue3/vite.config.ts",
                    "/vue3")

    )),


    ;


    private List<TemplateParametersDto> templateParametersList;

    TemplateParametersList(List<TemplateParametersDto> templateParametersList) {
        this.templateParametersList = templateParametersList;
    }

    public List<TemplateParametersDto> getTemplateParametersList() {
        return templateParametersList;
    }
}
