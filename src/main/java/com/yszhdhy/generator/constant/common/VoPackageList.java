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
            )), //service-util
    ;



    private List<PackageVo> packageList;

    VoPackageList(List<PackageVo> packageList) {
        this.packageList = packageList;
    }


    public List<PackageVo> getPackageList() {
        return packageList;
    }
}
