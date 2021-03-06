package cn.javayuli.cloud.common.security.feign;

import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

/**
 * @author hanguilin
 *
 */
@Configuration
@ConditionalOnProperty("security.oauth2.client.client-id")
public class OAuth2FeignClientConfig {

	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource) {
		return new OAuth2FeignClientInterceptor(oAuth2ClientContext, resource);
	}

}
