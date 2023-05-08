package com.yszhdhyBoot.demo.model.project;

import lombok.Data;


@Data
public class ProjectInfo {
    /**
     * 项目磁盘路径
     */
    private String basePath;

    /**
     * 包路径
     */
    private String basePackagePath;

    private String basePackagePathForModule;

    /**
     * 基包名
     */
    private String basePackage;


    /**
     * 配置文件路径
     */
    private String yamlPath;

    public ProjectInfo(String basePath, String basePackagePath) {
        this.basePath = basePath + "/" + "src" + "/" + "main" + "/" + "java" + "/";
        this.yamlPath = basePath +  "/" + "src" + "/" + "main" + "/" + "resources" + "/" + "application.yaml";
        this.basePackage = basePackagePath;
        this.basePackagePath = basePackagePath.replaceAll("\\.", "/");
    }

    public String getBaseGeneratePath() {
        return basePath + basePackagePath;
    }


    public String getBaseGeneratePathForModule(String basePath, String ModulePath){

        String basePackagePathForModule = basePath + ModulePath + "/" + "src" + "/" + "main" + "/" + "java" + "/";
        return  basePackagePathForModule+basePackagePath;
    }

    /**
     *
     * @param basePath 项目路径
     * @param ModulePath 模块路径
     * @param basePackagePath groupid
     * @return
     */
    public String getBaseGeneratePathForModuleGroupId(String basePath, String ModulePath,String basePackagePath){

        String basePackagePathForModule = basePath + ModulePath + "/" + "src" + "/" + "main" + "/" + "java" + "/";

        if(ModulePath == null){
           basePackagePathForModule = basePath + "/" + "src" + "/" + "main" + "/" + "java" + "/";
        }
        return  basePackagePathForModule+basePackagePath;
    }
}
