package com.yszhdhy.generator.construct.structure.vue;


import com.yszhdhy.generator.constant.common.*;
import com.yszhdhy.generator.construct.structure.common.commonUtil.BuilderOfCommonUtil;
import com.yszhdhy.generator.construct.structure.common.serviceUtil.BuilderOfServiceUitl;
import com.yszhdhy.generator.model.project.ProjectInfo;
import com.yszhdhy.generator.model.vo.Module;
import com.yszhdhy.generator.model.vo.PackageVo;
import com.yszhdhy.generator.utils.FileUtils;
import com.yszhdhy.generator.utils.PomResolverUtils;
import com.yszhdhy.generator.utils.SystemUtils;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BuilderOfVue {

    public static void construct() throws DocumentException, IOException {
        List<PackageVo> packageList = VoPackageList.BASE_VUE_PACKAGE.getPackageList();
        File file = new File(SystemUtils.getProjectPath(), "vue");
        file.mkdir();

        // 创建基本目录
        for (PackageVo packageVo : packageList) {
//                执行本目录
            FileUtils.mkdir(SystemUtils.getProjectPath()+"/vue", packageVo);
        }


    }





}
