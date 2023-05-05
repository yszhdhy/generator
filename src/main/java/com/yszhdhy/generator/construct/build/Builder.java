package com.yszhdhy.generator.construct.build;

import com.yszhdhy.generator.model.vo.FileEntity;

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
