package com.yszhdhyBoot.demo.construct.build;

import com.yszhdhyBoot.demo.model.vo.FileEntity;

public class Director {

    //声明 builder类型的变量

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装文件
    public FileEntity construct(){
        builder.builderDependency();
        builder.buildYaml();
        builder.buildCodeTemplate();
        return builder.createFile();
    }
}
