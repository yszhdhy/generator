package com.yszhdhy.generator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @project generator
 * @description 创建模板时对应的参数等
 * @author capture or new
 * @date 2023/7/22 13:23:04
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TemplateParametersDto {
    // 参数
    private Map<String, Object> data;
    //文件名称
    private String fileName;
    // 将文件生成在哪里
    private String toPath;
    // 模板文件位置
    private String fromPath;
}
