package cn.javayuli.security.config;

import feign.RequestTemplate;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * feign token传递
 *
 * @author hanguilin
 */
public class TokenFeignClientInterceptor extends OAuth2FeignRequestInterceptor {

    private OAuth2ClientContext oAuth2ClientContext;

    public TokenFeignClientInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource) {
        super(oAuth2ClientContext, resource);
        this.oAuth2ClientContext = oAuth2ClientContext;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (oAuth2ClientContext != null && oAuth2ClientContext.getAccessToken() != null) {
            super.apply(requestTemplate);
        }
    }
}