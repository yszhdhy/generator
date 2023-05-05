package cloud.makeronbean.generate.resolver.FileBuilder;

import cloud.makeronbean.generate.constant.code.CodeTemplate;
import cloud.makeronbean.generate.constant.common.PackagePath;
import cloud.makeronbean.generate.entity.Module;
import cloud.makeronbean.generate.entity.project.ProjectInfo;
import cloud.makeronbean.generate.resolver.FileBuilder.service.SpringbootInitiate;
import cloud.makeronbean.generate.utils.FileUtils;
import cloud.makeronbean.generate.utils.MkdirFileWriteUtils;
import cloud.makeronbean.generate.utils.PomResolverUtils;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

/**
 * 构建文件
 */
public class BuildTheFile {

    public static void construct(List<CodeTemplate> codeTemplateList, String filePath, String GroupId) throws IOException {

        MkdirFileWriteUtils.write(codeTemplateList,filePath,GroupId);
    }



    public static void buildTheFile(ProjectInfo info) throws IOException {

        SpringbootInitiate.construct(info);
    }


}
