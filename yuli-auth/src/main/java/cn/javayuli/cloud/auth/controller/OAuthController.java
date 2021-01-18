package cn.javayuli.cloud.auth.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

/**
 * 重新oAuth获取token接口
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/oauth")
public class OAuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * 重写oauth请求token方法，封装返回结果
     *
     * @param principal 认证对象
     * @param parameters 参数
     * @return
     * @throws HttpRequestMethodNotSupportedException
     */
    @PostMapping("/token")
    public Rest<OAuth2AccessToken> doToken (Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        ResponseEntity<OAuth2AccessToken> responseEntity = tokenEndpoint.postAccessToken(principal, parameters);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        if (HttpStatus.OK.equals(httpStatus)) {
            return Rest.success(responseEntity.getBody());
        }
        return Rest.fail("获取token失败", httpStatus.value());
    }
}
