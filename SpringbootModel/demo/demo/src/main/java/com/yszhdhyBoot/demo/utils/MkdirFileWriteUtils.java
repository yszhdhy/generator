package com.yszhdhyBoot.demo.utils;


import com.yszhdhyBoot.demo.constant.code.CodeTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MkdirFileWriteUtils {

    /**
     * 创建文件并写入
     *
     * @param codeTemplateList
     * @throws IOException
     */
    public static void write(List<CodeTemplate> codeTemplateList, String filePath, String GroupId) throws IOException {
        for (CodeTemplate codeTemplate : codeTemplateList) {
            String path = codeTemplate.getPath();

            if (path != null && path.length() > 0) {
                filePath += "/" + path;
            }
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            File codeFile = new File(filePath + "/" + codeTemplate.getFileName());
            codeFile.createNewFile();

            String code = String.format(codeTemplate.getCodeTemplate(),
                    "package " + GroupId.replaceAll("/",".")
                            + (path != null && path.length() > 0 ? "."
                            + path.replaceAll("/", ".") : "")
                            + ";");

            FileOutputStream fos = new FileOutputStream(codeFile);
            fos.write(code.getBytes(StandardCharsets.UTF_8));
        }
    }

}
