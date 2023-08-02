package com.yszhdhy.generator.model.dto;


import com.yszhdhy.generator.utils.PomUtils;

/**
 * @author makeronbean
 * @createDate 2023-05-01  20:16
 * @description
 */

public class SpringBootParentDto {

    public static String mainBootName = PomUtils.getSingleValue("artifactId").substring(0, 1).toUpperCase() + PomUtils.getSingleValue("artifactId").substring(1);

}
