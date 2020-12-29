package cn.javayuli.core.constant;

/**
 * Spring Security常量
 *
 * @author hanguilin
 */
public interface SecurityConstant {

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
    String DETAILS_USER_ACCOUNT = "user_account";

    /***
     * 资源服务器默认bean名称
     */
    String RESOURCE_SERVER_CONFIGURER = "resourceServerConfigurerAdapter";
}
