package com.yszhdhy.generator.construct.structure.vue3;


import com.yszhdhy.generator.constant.common.VoPackageList;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author CaptureOrNew
 * @description 构建 vue 目录结构
 * @date 15:27:37 2023/7/23
 **/
public class BuilderOfVue3 {

    public static void construct() throws DocumentException, IOException {
        List<PackageVo> packageList = VoPackageList.BASE_VUE3_PACKAGE.getPackageList();
        File file = new File(SystemUtils.getProjectPath(), "vue3");
        file.mkdir();

        // 创建基本目录
        for (PackageVo packageVo : packageList) {
//                执行本目录
            FileUtils.mkdir(SystemUtils.getProjectPath()+"/vue3", packageVo);
        }


    }





}
