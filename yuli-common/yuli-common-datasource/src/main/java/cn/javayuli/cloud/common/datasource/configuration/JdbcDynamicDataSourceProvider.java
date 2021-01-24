package cn.javayuli.cloud.common.datasource.configuration;

import cn.javayuli.cloud.common.datasource.constant.DataSourceConstants;
import com.baomidou.dynamic.datasource.provider.AbstractJdbcDataSourceProvider;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import org.jasypt.encryption.StringEncryptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 动态数据源提供类
 * @author: hanguilin
 * @createDate: 2021/1/23
 * @version: 1.0
 */
public class JdbcDynamicDataSourceProvider extends AbstractJdbcDataSourceProvider {

    /**
     * 当前环境的数据库连接信息
     */
    private final DataSourceProperties dataSourceProperties;

    /**
     * 字符加解密
     */
    private final StringEncryptor stringEncryptor;

    public JdbcDynamicDataSourceProvider(StringEncryptor stringEncryptor, DataSourceProperties dataSourceProperties) {
        super(dataSourceProperties.getDriverClassName(), dataSourceProperties.getUrl(), dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
        this.dataSourceProperties = dataSourceProperties;
        this.stringEncryptor = stringEncryptor;
    }

    @Override
    protected Map<String, DataSourceProperty> executeStmt(Statement statement) throws SQLException {
        Map<String, DataSourceProperty> resultMap = new HashMap<String, DataSourceProperty>(8);
        // 查询数据库多数据源配置
        ResultSet resultSet = statement.executeQuery(DataSourceConstants.QUERY_DS_SQL);
        while (resultSet.next()) {
            String name = resultSet.getString(DataSourceConstants.DS_NAME);
            String username = resultSet.getString(DataSourceConstants.DS_USER_NAME);
            String password = resultSet.getString(DataSourceConstants.DS_USER_PWD);
            String url = resultSet.getString(DataSourceConstants.DS_JDBC_URL);
            DataSourceProperty dataSourceProperty = new DataSourceProperty();
            dataSourceProperty.setDriverClassName(DataSourceConstants.DS_DRIVER);
            dataSourceProperty.setUsername(username);
            dataSourceProperty.setPassword(stringEncryptor.decrypt(password));
            dataSourceProperty.setUrl(url);
            resultMap.put(name, dataSourceProperty);
        }
        // 设置主数据源
        DataSourceProperty masterDataSourceProperty = new DataSourceProperty();
        masterDataSourceProperty.setDriverClassName(DataSourceConstants.DS_DRIVER);
        masterDataSourceProperty.setUsername(dataSourceProperties.getUsername());
        masterDataSourceProperty.setPassword(dataSourceProperties.getPassword());
        masterDataSourceProperty.setUrl(dataSourceProperties.getUrl());
        resultMap.put(DataSourceConstants.DS_MASTER, masterDataSourceProperty);
        return resultMap;
    }
}
