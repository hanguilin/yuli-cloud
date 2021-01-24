package cn.javayuli.cloud.common.datasource.constant;

/**
 * @description: 数据源相关常量
 * @author: hanguilin
 * @createDate: 2021/1/23
 * @version: 1.0
 */
public interface DataSourceConstants {

	/**
	 * 数据源名称
	 */
	String DS_NAME = "name";

	/**
	 * 默认驱动
	 */
	String DS_DRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * 默认数据源（master）
	 */
	String DS_MASTER = "master";

	/**
	 * jdbcurl
	 */
	String DS_JDBC_URL = "url";

	/**
	 * 用户名
	 */
	String DS_USER_NAME = "username";

	/**
	 * 密码
	 */
	String DS_USER_PWD = "password";

	/**
	 * 查询数据源的SQL
	 */
	String QUERY_DS_SQL = "select * from datasource_conf where del_flag = '0'";
}
