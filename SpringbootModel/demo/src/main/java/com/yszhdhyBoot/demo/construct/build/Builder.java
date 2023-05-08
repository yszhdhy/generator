package com.yszhdhyBoot.demo.construct.build;

import com.yszhdhyBoot.demo.model.vo.FileEntity;

public abstract class Builder {

    protected FileEntity file = new FileEntity();

    /**
     * 以下散步分为组装
     */
    public abstract void builderDependency();

    public abstract void buildYaml();

    public abstract void buildCodeTemplate();

    //构建文件
    public abstract FileEntity createFile();
}
