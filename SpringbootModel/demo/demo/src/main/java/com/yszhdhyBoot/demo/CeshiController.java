package com.yszhdhyBoot.demo;

import com.yszhdhyBoot.demo.model.project.Project;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class CeshiController {

    @GetMapping("ceshi")
    public String ceshi(){
//        System.out.println("进来了");
        try {
            Project project = new Project();
            project.generate();
            return "成功";
        } catch (DocumentException e) {
            return "成功";
        } catch (FileNotFoundException e) {
            return "失败";
        }
    }
}
