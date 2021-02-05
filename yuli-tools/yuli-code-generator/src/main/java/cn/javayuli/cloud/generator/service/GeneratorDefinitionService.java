package cn.javayuli.cloud.generator.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @description: 代码生成业务类
 * @author: HanGuiLin
 * @createDate: 2021/1/18
 * @version: 1.0
 */
public interface GeneratorDefinitionService extends IService<GeneratorDefinition> {

    /**
     * 根据配置生成代码并包装成byte数组
     *
     * @param generatorDefinition 生成描述
     * @return
     * @throws IOException
     */
    byte[] getCodeByte(GeneratorDefinition generatorDefinition) throws IOException;

    /**
     * 创建菜单
     *
     * @param tableName 表名
     * @param parentId 菜单父id
     * @return
     */
    Rest<Boolean> createMenu(String tableName, String parentId);

    /**
     * 获取最新的一次生成配置
     *
     * @param tableName 表名
     * @return
     */
    GeneratorDefinition getRecently(String tableName);

    /**
     * 生成模板
     *
     * @param generatorDefinition 配置
     * @param zip 压缩对象
     * @return
     * @throws IOException
     */
    Map<String, String> genTemplate(GeneratorDefinition generatorDefinition, ZipOutputStream zip) throws IOException;
}
