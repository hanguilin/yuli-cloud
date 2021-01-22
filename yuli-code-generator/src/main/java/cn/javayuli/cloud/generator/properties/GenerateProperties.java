package cn.javayuli.cloud.generator.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 代码生成的配置文件
 * @author: hanguilin
 * @createDate: 2021/1/21
 * @version: 1.0
 */
@Component
@PropertySource(value = {"generate.properties"})
@ConfigurationProperties(prefix = "generate")
public class GenerateProperties {

    /**
     * 数据库类型对应的java字段类型
     */
    private Map<String, Object> type;

    /**
     * 默认参数值
     */
    private Map<String, Object> defaultValue;

    /**
     * 需要额外导入的包类型
     */
    private Map<String, Object> importClass;

    /**
     * 结构参数
     */
    private Map<String, Object> structure;

    public Map<String, Object> getType() {
        return type;
    }

    public void setType(Map<String, Object> type) {
        this.type = type;
    }

    public Map<String, Object> getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Map<String, Object> defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Map<String, Object> getImportClass() {
        return importClass;
    }

    public void setImportClass(Map<String, Object> importClass) {
        this.importClass = importClass;
    }

    public Map<String, Object> getStructure() {
        return structure;
    }

    public void setStructure(Map<String, Object> structure) {
        this.structure = structure;
    }
}
