package com.yszhdhy.generator.construct.FileBuilderOfProject.service.generatorCRUD;

import com.yszhdhy.generator.constant.templateParameters.TemplateParametersList;
import com.yszhdhy.generator.model.dto.TemplateParametersDto;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.YamlDisposition;

import java.io.IOException;
import java.util.List;

import static com.yszhdhy.generator.constant.common.yaml.YamlPath.YAML_PATH;
import static com.yszhdhy.generator.constant.yaml.DispositionYaml.MINIO_DISPOSITION;

/**
 * @project generator
 * @description 构建 GeneratorCRUD模块代码
 * @author capture or new
 */
public class GeneratorCRUDModelFileBuilder {

    public static void construct() throws IOException {

        List<TemplateParametersDto> templateParametersList = TemplateParametersList.GENERATORCURD_TEMPLATE_PARAMETERS_LIST.getTemplateParametersList();

        for (TemplateParametersDto templateParametersDto : templateParametersList) {
            FreeMarkerUtils.parse(templateParametersDto.getFileName(),
                    templateParametersDto.getData(),
                    templateParametersDto.getToPath(),
                    templateParametersDto.getFromPath());
        }


    }
}
