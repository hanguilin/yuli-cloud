package cn.javayuli.cloud.generator.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import cn.javayuli.cloud.generator.service.GeneratorDefinitionService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        Page page = generatorDefinitionService.page(new Page(1, 1), Wrappers.lambdaQuery(GeneratorDefinition.class).eq(GeneratorDefinition::getTableName, tableName).orderByDesc(GeneratorDefinition::getCreateTime));
        List records = page.getRecords();
        return Rest.success(CollUtil.isNotEmpty(records) ? records.get(0) : null);
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
}
