package com.yszhdhy.generator.construct.FileBuilderOfProject.service;

import com.yszhdhy.generator.constant.templateParameters.TemplateParametersList;
import com.yszhdhy.generator.model.dto.TemplateParametersDto;
import com.yszhdhy.generator.utils.FreeMarkerUtils;

import java.io.IOException;
import java.util.List;

/**
 * @project generator
 * @description 构建ServiceUtil模块代码
 * @author capture or new
 */
public class ServiceModelFileBuilder {

    public static void construct() throws IOException {

        List<TemplateParametersDto> templateParametersList = TemplateParametersList.SERVICE_TEMPLATE_PARAMETERS_LIST.getTemplateParametersList();

        for (TemplateParametersDto templateParametersDto : templateParametersList) {
            FreeMarkerUtils.parse(templateParametersDto.getFileName(),
                    templateParametersDto.getData(),
                    templateParametersDto.getToPath(),
                    templateParametersDto.getFromPath());
        }

    }
}
