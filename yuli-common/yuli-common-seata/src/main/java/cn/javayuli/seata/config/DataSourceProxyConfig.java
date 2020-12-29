package cn.javayuli.seata.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 对分布式事务seata配置的数据源代理
 *
 * @author hanguilin
 */
@Configuration
@ConditionalOnClass(HikariDataSource.class)
public class DataSourceProxyConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * 构造datasource代理对象，替换原来的datasource
     *
     * @return
     */
    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSourceProxy() {
        return new DataSourceProxy(dataSource);
    }
}
