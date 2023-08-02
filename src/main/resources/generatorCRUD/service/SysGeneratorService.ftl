

package ${packageName};


import ${packageNameModel}.model.SysMenu;
import ${packageNameDao}.dao.GeneratorDao;
import ${packageNameUtils}.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author yszhdhy
 */
@Service
public class SysGeneratorService {
    @Autowired
    private GeneratorDao generatorDao;


    public Map<String, String> queryTable(String tableName) {
        return generatorDao.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorDao.queryColumns(tableName);
    }


    public byte[] generatorCode(String[] tableNames,String component,SysMenu sysMenu) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip,component,sysMenu);
        }


        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
