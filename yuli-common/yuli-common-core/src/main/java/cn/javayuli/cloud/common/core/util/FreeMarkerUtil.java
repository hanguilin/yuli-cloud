package cn.javayuli.cloud.common.core.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @description: freemarker工具类
 * @author: HanGuiLin
 * @createDate: 2021/1/19
 * @version: 1.0
 */
@Component
public class FreeMarkerUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FreeMarkerUtil.class);

    /**
     * 将参数带入freemarker模板
     *
     * @param viewName 文件名
     * @param params 参数
     * @return
     */
    public static String parseTpl(Configuration configuration, String viewName, Map<String, Object> params) {
        if (configuration == null) {
            configuration = SpringContextHolder.getBean(Configuration.class);
            configuration.setClassForTemplateLoading(FreeMarkerUtil.class, "/template");
        }
        String html = null;
        try {
            Template template = configuration.getTemplate(viewName + ".ftl");
            html = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
        } catch (IOException | TemplateException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return html;
    }
}
