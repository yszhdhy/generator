package com.yszhdhy.generator.construct.FileBuilderOfProject.common.commonElasticsearch;

import com.yszhdhy.generator.constant.templateParameters.TemplateParametersList;
import com.yszhdhy.generator.model.dto.TemplateParametersDto;
import com.yszhdhy.generator.utils.FreeMarkerUtils;
import com.yszhdhy.generator.utils.YamlDisposition;

import java.io.IOException;
import java.util.List;

import static com.yszhdhy.generator.constant.common.yaml.YamlPath.YAML_PATH;
import static com.yszhdhy.generator.constant.yaml.DispositionYaml.*;

/**
 * @project generator
 * @description 构建Elasticsearch模块代码
 * @author capture or new
 * @date 2023/7/22 13:49:57
 * @version 1.0
 */
public class ElasticsearchModelFileBuilder {

    public static void construct() throws IOException {

        List<TemplateParametersDto> templateParametersList = TemplateParametersList.ELASTICSEARCH_TEMPLATE_PARAMETERS_LIST.getTemplateParametersList();

        for (TemplateParametersDto templateParametersDto : templateParametersList) {
            FreeMarkerUtils.parse(templateParametersDto.getFileName(),
                    templateParametersDto.getData(),
                    templateParametersDto.getToPath(),
                    templateParametersDto.getFromPath());
        }

        // 生成yaml配置
        YamlDisposition.reconstitution(YAML_PATH.getYamlPath(),
                ELASTICSEARCH_DISPOSITION.getMap(), ELASTICSEARCH_DISPOSITION.getLevel(), ELASTICSEARCH_DISPOSITION.getDispositionName());

    }
}
