package cn.javayuli.cloud.generator.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     * 分页查询表信息
     *
     * @param dsName 数据源名称
     * @return
     */
    @DS("#last")
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables where table_schema = (select database())")
    List<Map<String, Object>> pageTable(String dsName);

    /**
     * 查询表信息
     *
     * @param tableName 表名
     * @param dsName 数据源名称
     * @return
     */
    @DS("#last")
    @Select("select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables where table_schema = (select database()) and table_name = #{tableName}")
    Map<String, Object> queryTable(@Param("tableName") String tableName, String dsName);

    /**
     * 查询列信息
     *
     * @param tableName 表名
     * @param dsName 数据源名称
     * @return
     */
    @DS("#last")
    @Select("select column_name AS columnName, data_type AS dataType, column_comment AS columnComment, column_key AS columnKey, extra ,is_nullable AS isNullable,column_type AS columnType from information_schema.columns where table_name = #{tableName} and table_schema = (select database()) order by ordinal_position")
    List<Map<String, Object>> queryColumns(@Param("tableName") String tableName, String dsName);
}
