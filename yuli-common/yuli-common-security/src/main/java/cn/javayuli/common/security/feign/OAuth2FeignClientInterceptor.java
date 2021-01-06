package cn.javayuli.common.security.feign;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.common.core.constant.SecurityConstant;
import feign.RequestTemplate;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

import java.util.Collection;

/**
 * feign token传递
 *
 * @author hanguilin
 */
public class OAuth2FeignClientInterceptor extends OAuth2FeignRequestInterceptor {

    private OAuth2ClientContext oAuth2ClientContext;

    public OAuth2FeignClientInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource) {
        super(oAuth2ClientContext, resource);
        this.oAuth2ClientContext = oAuth2ClientContext;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Collection<String> fromHeader = requestTemplate.headers().get(SecurityConstant.SOURCE);
        if (CollUtil.isNotEmpty(fromHeader) && fromHeader.contains(SecurityConstant.SOURCE_IN)) {
            return;
        }
        if (oAuth2ClientContext != null && oAuth2ClientContext.getAccessToken() != null) {
            super.apply(requestTemplate);
        }
    }
}