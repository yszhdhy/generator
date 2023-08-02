package com.yszhdhy.generator.constant.code;


import com.yszhdhy.generator.model.dto.SpringBootParentDto;


@SuppressWarnings("all")
public enum SpringParentCodeConst implements CodeTemplate {
    BOOT("",
            SpringBootParentDto.mainBootName + "Application.java",
            "%s\n\n" +
                    "import org.springframework.boot.SpringApplication;\n" +
                    "import org.springframework.boot.autoconfigure.SpringBootApplication;\n" +
                    "import org.springframework.context.annotation.ComponentScan;\n"+
                    "import java.io.IOException;\n"+
                    "\n" +
                    "@SpringBootApplication\n" +
                    "@ComponentScan(value = {\"com.xc\"})\n"+
                    "public class " + SpringBootParentDto.mainBootName + "Application" + " {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        SpringApplication.run(" + SpringBootParentDto.mainBootName + "Application" + ".class, args);\n" +
                    "        openBrowser(\"http://localhost:8080/admin/web/crud\");\n"+
                    "    }\n" +
                    "\n" +
                    "    /**\n" +
                    "     * @author CaptureOrNew\n" +
                    "     * @description 获取本地浏览器并自动打开项目首页\n" +
                    "     * @date 16:30:43 2023/7/16\n" +
                    "     * @param url\n" +
                    "     **/\n" +
                    "    private static void openBrowser(String url) {\n" +
                    "        try {\n" +
                    "            // 根据不同操作系统执行不同的命令\n" +
                    "            String os = System.getProperty(\"os.name\").toLowerCase();\n" +
                    "            if (os.contains(\"win\")) {\n" +
                    "                // Windows\n" +
                    "                Runtime.getRuntime().exec(\"rundll32 url.dll,FileProtocolHandler \" + url);\n" +
                    "            } else if (os.contains(\"mac\")) {\n" +
                    "                // macOS\n" +
                    "                Runtime.getRuntime().exec(\"open \" + url);\n" +
                    "            } else if (os.contains(\"nix\") || os.contains(\"nux\")) {\n" +
                    "                // Linux\n" +
                    "                Runtime.getRuntime().exec(\"xdg-open \" + url);\n" +
                    "            }\n" +
                    "        } catch (IOException e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "    }\n"+
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
