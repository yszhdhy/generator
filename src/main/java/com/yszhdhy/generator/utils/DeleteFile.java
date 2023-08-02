package com.yszhdhy.generator.utils;

import java.io.File;

public class DeleteFile {

    public static boolean deleteFile(){

        // 删除原项目文件夹
        deleteFolder(new File(SystemUtils.getProjectPath()+"/src"));
        return false;
    }

    private static void deleteFolder(File folder) {
        // 遍历文件夹中的所有文件和子文件夹
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {

                    if (file.isDirectory()) {
                        // 递归删除子文件夹
                        deleteFolder(file);
                    } else {
                        // 删除文件
                        file.delete();
                    }

            }
        }

        // 删除空文件夹
        folder.delete();
    }

}
