package cn.javayuli.cloud.common.datasource.configuration;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description: 从mapper方法的最后一个参数获取数据源并切换
 * @author: hanguilin
 * @createDate: 2021/1/23
 * @version: 1.0
 */
public class LastParamDsProcessor extends DsProcessor {

    /**
     * last常量
     */
    private static final String LAST = "#last";

    /**
     * 匹配#last，@DS("#last")将会根据此类进行解析
     *
     * @param key @DS的value
     * @return 是否匹配
     */
    @Override
    public boolean matches(String key) {
        return key.equals(LAST);
    }

    /**
     * 解析方法
     *
     * @param methodInvocation @DS注解对应的Method
     * @param key @DS的value
     * @return 数据源名称
     */
    @Override
    public String doDetermineDatasource(MethodInvocation methodInvocation, String key) {
        Object[] arguments = methodInvocation.getArguments();
        Object sourceName = arguments[arguments.length - 1];
        if (sourceName instanceof String) {
            return String.valueOf(sourceName);
        }
        throw new RuntimeException("数据源名称必须为String类型");
    }
}
