package com.yszhdhy.generator.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VueFileVo {

    private String fileNamefetchPath;

    private String fileName;

    private Map<String, Object> data;

    private String filePath;

    private String suffix;
}
