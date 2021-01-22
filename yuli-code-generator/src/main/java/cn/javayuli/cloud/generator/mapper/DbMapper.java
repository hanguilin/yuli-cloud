package cn.javayuli.cloud.generator.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @description: 查询数据库mapper
 * @author: HanGuiLin
 * @createDate: 2021/1/18
 * @version: 1.0
 */
@Mapper
public interface DbMapper {

    /**
     * 查询表信息
     *
     * @param tableName 表名
     * @return
     */
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables where table_schema = (select database()) and table_name = #{tableName}")
    Map<String, Object> queryTable(String tableName);

    /**
     * 查询列信息
     *
     * @param tableName 表名
     * @return
     */
    @Select("select column_name, data_type, column_comment, column_key, extra ,is_nullable,column_type from information_schema.columns where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
    List<Map<String, Object>> queryColumns(String tableName);
}
