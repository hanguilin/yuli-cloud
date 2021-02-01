package cn.javayuli.cloud.gateway.handler;

import cn.javayuli.cloud.gateway.configuration.SwaggerProviderConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @description: SwaggerResourceHandler
 * @author: hanguilin
 * @createDate: 2021/1/27
 * @version: 1.0
 */
@Component
public class SwaggerResourceHandler implements HandlerFunction<ServerResponse> {

    @Autowired
    private SwaggerProviderConfiguration swaggerProviderConfiguration;

    /**
     * webflux 响应事件
     *
     * @param serverRequest
     * @return
     */
    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(swaggerProviderConfiguration.get()));
    }
}
