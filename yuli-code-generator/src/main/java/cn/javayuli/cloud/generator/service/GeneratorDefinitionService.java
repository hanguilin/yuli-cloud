package cn.javayuli.cloud.generator.service;

import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

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
}
