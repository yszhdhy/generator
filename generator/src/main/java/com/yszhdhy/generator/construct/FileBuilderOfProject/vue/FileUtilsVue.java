package com.yszhdhy.generator.construct.FileBuilderOfProject.vue;

import com.yszhdhy.generator.model.vo.VueFileVo;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.SystemUtils;

import java.io.IOException;
import java.util.List;

public class FileUtilsVue {
    public static void construct(List<VueFileVo> vueFileVos) throws IOException {

        for (VueFileVo vo : vueFileVos) {
            FreeMarkerUtils.parse(vo.getFileNamefetchPath(),
                    vo.getData(),
                    SystemUtils.getProjectPath()+vo.getFilePath()+"/"+vo.getFileName()+vo.getSuffix(),
                    vo.getFilePath());
        }

    }
}
