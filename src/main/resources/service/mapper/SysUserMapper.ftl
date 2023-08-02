package ${packageName};

import ${packageNameModel}.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author atguigu
 * @since 2023-02-02
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
