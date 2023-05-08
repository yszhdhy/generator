package com.yszhdhyBoot.demo;

import com.yszhdhyBoot.demo.model.project.Project;
import org.dom4j.DocumentException;

import java.io.FileNotFoundException;

public class Ceshi {
    public static void kaiShi()  {
        System.out.println("进来了");
        try {
            new Project().generate();
            System.out.println("成功");
        } catch (DocumentException e) {
            System.out.println("失败");
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            System.out.println("失败");
            throw new RuntimeException(e);
        }
    }
}
