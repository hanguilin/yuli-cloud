package cn.javayuli.cloud.generator.controller;

import cn.hutool.core.io.IoUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
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
public class GeneratorDefinitionController {

    @Autowired
    private GeneratorDefinitionService generatorDefinitionService;

    /**
     * 获取最新的一次生成配置
     *
     * @param tableName 表名
     * @return
     */
    @GetMapping("/recently")
    public Rest<GeneratorDefinition> getRecently(String tableName) {
        return Rest.success(generatorDefinitionService.getRecently(tableName));
    }

    /**
     * 预览代码
     *
     * @param generatorDefinition 生成属性描述
     * @return
     */
    @PostMapping("/preview")
    public Rest<Map<String, String>> doPreview(@RequestBody GeneratorDefinition generatorDefinition) throws IOException {
        Map<String, String> resMap = generatorDefinitionService.genTemplate(generatorDefinition, null);
        return Rest.success(resMap);
    }

    /**
     * 生成代码并下载
     *
     * @param generatorDefinition 生成属性描述
     * @param response 响应对象
     */
    @PostMapping("/code")
    public void doGeneratorCode(@RequestBody GeneratorDefinition generatorDefinition, HttpServletResponse response) throws IOException {
        // 保存此次配置
        generatorDefinitionService.save(generatorDefinition);
        byte[] codeByteArr = generatorDefinitionService.getCodeByte(generatorDefinition);
        response.reset();
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                String.format("attachment; filename=%s.zip", generatorDefinition.getTableName()));
        response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(codeByteArr.length));
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), Boolean.TRUE, codeByteArr);
    }

    /**
     * 创建菜单
     *
     * @param tableName 表名
     * @param parentId 菜单父id
     * @return
     */
    @PostMapping("/createMenu")
    public Rest<Boolean> doCreateMenu(String tableName, String parentId) {
        return generatorDefinitionService.createMenu(tableName, parentId);
    }
}
