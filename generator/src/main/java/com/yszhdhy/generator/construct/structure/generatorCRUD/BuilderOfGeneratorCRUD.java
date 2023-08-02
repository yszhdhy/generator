package com.yszhdhy.generator.construct.structure.generatorCRUD;


import com.yszhdhy.generator.constant.common.ModuleGroupId;
import com.yszhdhy.generator.constant.common.PackagePath;
import com.yszhdhy.generator.constant.common.VoPackageList;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.FileUtils;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BuilderOfGeneratorCRUD {


    final public static String url = PackagePath.PACKAGE_SERVICE_PATH.getPackagePath()+"/src/main/java/"+ ModuleGroupId.MODULE_SERVICE_GROUP_ID.getModuleGroupId();
//    final public static String url =SystemUtils.getProjectPath();

    public static void construct() throws DocumentException, IOException {
        List<PackageVo> packageList = VoPackageList.GeneratorCURD_PACKAGES.getPackageList();
        File file = new File(url, "generatorCRUD");
        file.mkdir();

        // 创建基本目录
        for (PackageVo packageVo : packageList) {
//                执行本目录
            FileUtils.mkdir(url+"/generatorCRUD", packageVo);
        }


    }





}
