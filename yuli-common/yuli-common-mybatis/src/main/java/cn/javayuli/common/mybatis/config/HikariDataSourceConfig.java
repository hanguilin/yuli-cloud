package cn.javayuli.common.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * hikari数据源
 *
 * @author hanguilin
 */
@Configuration
@ConditionalOnClass(HikariDataSource.class)
public class HikariDataSourceConfig {

    /**
     * 原生datasource前缀取"spring.datasource"
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }
}
