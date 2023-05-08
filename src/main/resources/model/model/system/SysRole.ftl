package  ${packageName};

import ${packageName}.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	//角色名称
	@TableField("role_name")
	private String roleName;

	//角色编码
	@TableField("role_code")
	private String roleCode;

	//描述
	@TableField("description")
	private String description;
}

