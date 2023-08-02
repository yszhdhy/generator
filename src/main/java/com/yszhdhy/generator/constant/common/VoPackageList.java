package com.yszhdhy.generator.constant.common;

import com.yszhdhy.generator.model.vo.PackageVo;

import java.util.Arrays;
import java.util.List;

public enum VoPackageList {

    BASE_VUE_PACKAGE(Arrays.asList(new PackageVo("build",null),
            new PackageVo("public",null),
            new PackageVo("src",Arrays.asList(new PackageVo("api",Arrays.asList(new PackageVo("system",null))),

            new PackageVo("assets",Arrays.asList(new PackageVo("404_images",null))),
            new PackageVo("components",Arrays.asList(new PackageVo("Breadcrumb",null),
                    new PackageVo("Hamburger",null),
                    new PackageVo("ParentView",null),
                    new PackageVo("SvgIcon",null))),
            new PackageVo("icons",Arrays.asList(new PackageVo("svg",null))),
            new PackageVo("layout",Arrays.asList(new PackageVo("components",Arrays.asList(new PackageVo("Sidebar",null))),
                    new PackageVo("mixin",null))),
            new PackageVo("router",null),
            new PackageVo("store",Arrays.asList(new PackageVo("modules",null))),
            new PackageVo("styles",null),
            new PackageVo("utils",null),
            new PackageVo("views",Arrays.asList(new PackageVo("dashboard",null),
                    new PackageVo("form",null),
                    new PackageVo("login",null),
                    new PackageVo("system",Arrays.asList(new PackageVo("sysMenu",null),
                            new PackageVo("sysRole",null),
                            new PackageVo("sysUser",null)
                            )),
                    new PackageVo("table",null),
                    new PackageVo("tree",null)
            ))
                    ))
            )),

    BASE_VUE3_PACKAGE(Arrays.asList(
            new PackageVo("public",null),
            new PackageVo("src",
                    Arrays.asList(
                            new PackageVo("api",
                            Arrays.asList(new PackageVo("system",
                                            Arrays.asList(new PackageVo("menu",null),
                                                    new PackageVo("role",null),
                                                    new PackageVo("user",null))),
                                    new PackageVo("user",null))),

                    new PackageVo("assets",Arrays.asList(new PackageVo("images",null))),
                    new PackageVo("components",
                            Arrays.asList(new PackageVo("ParentView",null),
                            new PackageVo("VerifyCode",null))),

                    new PackageVo("layout",
                            Arrays.asList(new PackageVo("logo", null),
                            new PackageVo("main",null),
                                    new PackageVo("menu",null),
                                    new PackageVo("tabbar",Arrays.asList(new PackageVo("breadcrumb",null),
                                            new PackageVo("setting",null))))),

                    new PackageVo("router",null),

                    new PackageVo("store",Arrays.asList(new PackageVo("modules",
                            Arrays.asList(new PackageVo("types",null))))),

                    new PackageVo("styles",null),

                    new PackageVo("utils",null),

                    new PackageVo("views", Arrays.asList(new PackageVo("404",null),
                            new PackageVo("dashboard",
                                    Arrays.asList(new PackageVo("dashboardCharts",null),
                                            new PackageVo("dashboardTable",null))),
                            new PackageVo("login",null),

                            new PackageVo("system",Arrays.asList(new PackageVo("sysMenu",null),
                                    new PackageVo("sysRole",null),
                                    new PackageVo("sysUser",null)
                            ))
                    ))
            ))
    )),


    GeneratorCURD_PACKAGES(Arrays.asList(new PackageVo("controller",null),
            new PackageVo("dao",Arrays.asList(new PackageVo("mapper",null))),
            new PackageVo("entity",null),
            new PackageVo("service",null),
            new PackageVo("utils",null),
            new PackageVo("controller",null),
            new PackageVo("web",null)
            )),

    // security 模块 包结构
    SECURITY_PACKAGES(Arrays.asList(new PackageVo("config",null),
            new PackageVo("custom",null),
            new PackageVo("filter",null))),


    // minio 模块 包结构
    MINIO_PACKAGES(Arrays.asList(new PackageVo("config",null),
            new PackageVo("service",
                    Arrays.asList(new PackageVo("impl",null))))),

    // minio 模块 包结构
    Elasticsearch_PACKAGES(Arrays.asList(new PackageVo("config",null),
            new PackageVo("controller", null),
            new PackageVo("pojo", null),
            new PackageVo("repository", null),
            new PackageVo("service",
                    Arrays.asList(new PackageVo("impl",null)))
            )),

    ;




    private List<PackageVo> packageList;

    VoPackageList(List<PackageVo> packageList) {
        this.packageList = packageList;
    }


    public List<PackageVo> getPackageList() {
        return packageList;
    }
}
