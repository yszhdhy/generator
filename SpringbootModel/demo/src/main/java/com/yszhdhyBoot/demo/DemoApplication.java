package com.yszhdhyBoot.demo;

import com.yszhdhyBoot.demo.model.project.Project;
import org.dom4j.DocumentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        SpringApplication.run(DemoApplication.class, args);

//        Ceshi.kaiShi();
//        Project project = new Project();
//        project.generate();

    }

}
