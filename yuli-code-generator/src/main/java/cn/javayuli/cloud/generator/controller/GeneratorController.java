package cn.javayuli.cloud.generator.controller;

import cn.hutool.core.io.IoUtil;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import cn.javayuli.cloud.generator.properties.GenerateProperties;
import cn.javayuli.cloud.generator.service.GeneratorDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @description: 生成器controller
 * @author: HanGuiLin
 * @createDate: 2021/1/18
 * @version: 1.0
 */
@RestController
@RequestMapping("/gen")
public class GeneratorController {

    @Autowired
    private GeneratorDefinitionService generatorDefinitionService;

    @Autowired
    private GenerateProperties generateProperties;
    /**
     * 生成代码并下载
     *
     * @param generatorDefinition 生成属性描述
     * @param response 响应对象
     */
    @PostMapping("/code")
    public void doGeneratorCode(@RequestBody GeneratorDefinition generatorDefinition, HttpServletResponse response) throws IOException {
        byte[] codeByteArr = generatorDefinitionService.getCodeByte(generatorDefinition);
        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                String.format("attachment; filename=%s.zip", generatorDefinition.getTableName()));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(codeByteArr.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, codeByteArr);
    }

    @GetMapping("/test")
    public void test() {
        Map<String, Object> type = generateProperties.getType();
        System.out.println(type);
    }
}
