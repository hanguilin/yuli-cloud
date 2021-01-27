package cn.javayuli.cloud.generator.mapper;

import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 生成属性定义Mapper
 * @author: hanguilin
 * @createDate: 2021/1/24
 * @version: 1.0
 */
@Mapper
public interface GeneratorDefinitionMapper extends BaseMapper<GeneratorDefinition> {
}
