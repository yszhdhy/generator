package  ${packageName};

import ${packageName}.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ApiModel(description = "菜单")
@TableName("sys_menu")
@ToString(callSuper = true)
public class SysMenu extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "所属上级")
	@TableField("parent_id")
	private Long parentId;

	@ApiModelProperty(value = "名称")
	@TableField("name")
	private String name;

	@ApiModelProperty(value = "类型(1:菜单,2:按钮)")
	@TableField("type")
	private Integer type;

	@ApiModelProperty(value = "路由地址")
	@TableField("path")
	private String path;

	@ApiModelProperty(value = "组件路径")
	@TableField("component")
	private String component;

	@ApiModelProperty(value = "权限标识")
	@TableField("perms")
	private String perms;

	@ApiModelProperty(value = "图标")
	@TableField("icon")
	private String icon;

	@ApiModelProperty(value = "排序")
	@TableField("sort_value")
	private Integer sortValue;

	@ApiModelProperty(value = "状态(0:禁止,1:正常)")
	@TableField("status")
	private Integer status;

	@ApiModelProperty(value = "路由名称")
	@TableField("route_name")
	private String routeName;

	@ApiModelProperty(value = "路由重定向")
	@TableField("redirect")
	private String redirect;

	@ApiModelProperty(value = "vue2图标")
	@TableField("vue2_icon")
	private String vue2Icon;

	// 下级列表
	@TableField(exist = false)
	private List<SysMenu> children;
	//是否选中
	@TableField(exist = false)
	private boolean isSelect;

	// 表名
	@TableField(exist = false)
	private String tableName;

	//	模块名称 RequestMapping 对应路径
	@TableField(exist = false)
	private String moduleName;

	// 作者
	@TableField(exist = false)
	private String  author;

	// 邮箱
	@TableField(exist = false)
	private String  email;

	// 角色Id
	@TableField(exist = false)
	private Integer[]  roleIds;

	// 是否打包
	@TableField(exist = false)
	private Integer isPack;
}

