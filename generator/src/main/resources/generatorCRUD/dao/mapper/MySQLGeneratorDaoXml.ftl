<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${packageName}.GeneratorDao">
	<select id="queryList" resultType="map">
		select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables
		where table_schema = (select database())
		<if test="tableName != null and tableName.trim() != ''">
			and table_name like concat('%', ${r"#{"}tableName${r"}"}, '%')
		</if>
		order by create_time desc
	</select>

	<select id="queryTable" resultType="map">
		select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables
			where table_schema = (select database()) and table_name = ${r"#{"}tableName${r"}"}
	</select>

	<select id="queryColumns" resultType="map">
		select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns
 			where table_name = ${r"#{"}tableName${r"}"} and table_schema = (select database()) order by ordinal_position
	</select>
</mapper>