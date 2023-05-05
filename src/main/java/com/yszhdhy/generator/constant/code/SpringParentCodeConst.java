package com.yszhdhy.generator.constant.code;


import com.yszhdhy.generator.model.dto.SpringBootParentDto;

/**
 * @author makeronbean
 * @createDate 2023-05-01  20:06
 * @description
 */
@SuppressWarnings("all")
public enum SpringParentCodeConst implements CodeTemplate {
    BOOT("",
            SpringBootParentDto.mainBootName + "Application.java",
            "%s\n\n" +
                    "import org.springframework.boot.SpringApplication;\n" +
                    "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                    "\n" +
                    "@SpringBootApplication\n" +
                    "public class " + SpringBootParentDto.mainBootName + "Application" + " {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        SpringApplication.run(" + SpringBootParentDto.mainBootName + "Application" + ".class, args);\n" +
                    "    }\n" +
                    "}"),
    ;
    private final String path;
    private final String fileName;
    private final String codeTemplate;

    SpringParentCodeConst(String path, String fileName, String codeTemplate) {
        this.path = path;
        this.fileName = fileName;
        this.codeTemplate = codeTemplate;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getCodeTemplate() {
        return codeTemplate;
    }
}
