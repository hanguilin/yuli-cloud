package cn.javayuli.cloud.common.security.exception.handler;

import cn.hutool.http.HttpStatus;
import cn.javayuli.cloud.common.security.exception.YuLiOAuth2Exception;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * OAuth2 异常格式化
 *
 * @author hanguilin
 */
public class YuLiAuthExceptionSerializer extends StdSerializer<YuLiOAuth2Exception> {

	public YuLiAuthExceptionSerializer() {
		super(YuLiOAuth2Exception.class);
	}

	@Override
	public void serialize(YuLiOAuth2Exception value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeObjectField("code", HttpStatus.HTTP_INTERNAL_ERROR);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}

}
