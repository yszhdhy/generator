<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.SysMenuMapper">

    <resultMap id="sysMenuMap"
               type="${packageNameModel}.model.SysMenu" autoMapping="true">
    </resultMap>

    <select id="findMenuListByUserId" resultMap="sysMenuMap">
        select distinct
            m.id,m.parent_id,m.name,m.type,m.path,m.component,m.perms,m.icon,m.sort_value,m.status,m.create_time,m.update_time,m.is_deleted
        from sys_menu m
        inner join sys_role_menu rm on rm.menu_id = m.id
        inner join sys_user_role ur on ur.role_id = rm.role_id
        where ur.user_id=${r"#{"}userId${r"}"}
          and m.status = 1
          and rm.is_deleted = 0
          and ur.is_deleted = 0
          and m.is_deleted = 0
    </select>
</mapper>
