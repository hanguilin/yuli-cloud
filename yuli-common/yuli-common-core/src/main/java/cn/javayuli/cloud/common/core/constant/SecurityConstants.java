package cn.javayuli.cloud.common.core.constant;

/**
 * Spring Security常量
 *
 * @author hanguilin
 */
public interface SecurityConstants {

    /**
     * 通行证字段
     */
    String LICENCE = "licence";

    /**
     * 通行证内容
     */
    String PROJECT_LICENSE = "made by yuli";

    /**
     * 角色前缀
     */
    String ROLE = "ROLE_";

    /**
     * 用户id
     */
    String DETAILS_USER_ID = "user_id";

    /**
     * 用户账户
     */
    String DETAILS_USERNAME = "username";

    /**
     * 用户昵称
     */
    String DETAILS_NICKNAME = "nickname";

    /**
     * 用户是否启用
     */
    String DETAILS_ENABLED = "enabled";

    /***
     * 资源服务器默认bean名称
     */
    String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";

    /**
     * 登录路径
     */
    String LOGIN_URL = "/token/login";

    /**
     * 登录表单方法路径
     */
    String LOGIN_FORM = "/token/form";

    /**
     * 请求来源
     */
    String SOURCE = "request_source";

    /**
     * 内部访问
     */
    String SOURCE_IN = "request_source_in";
}
