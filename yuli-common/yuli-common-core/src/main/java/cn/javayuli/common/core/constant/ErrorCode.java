package cn.javayuli.common.core.constant;

/**
 * @description: 错误码
 * @author: HanGuiLin
 * @createDate: 2021/1/15
 * @version: 1.0
 */
public interface ErrorCode {

    /**
     * 成功
     */
    Integer SUCCESS = 200;

    /**
     * 错误
     */
    Integer ERROR = 500;

    /**
     * 认证相关 1000~1999
     *
     * 无权限
     */
    Integer ACCESS_DENIED = 1001;
}
