package cn.javayuli.cloud.common.core.util;

import cn.javayuli.cloud.common.core.exception.CheckedException;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @description: 配置文件工具类
 * @author: HanGuiLin
 * @createDate: 2021/1/19
 * @version: 1.0
 */
public class PropertiesUtil {

    /**
     * 获取配置信息
     */
    public static Configuration load(String fileName) {
        try {
            return new PropertiesConfiguration(String.format("%s.properties", fileName));
        }
        catch (ConfigurationException e) {
            throw new CheckedException("获取配置文件失败，", e);
        }
    }
}
