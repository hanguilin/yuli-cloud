package cn.javayuli.cloud.generator.mapper;

import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 生成属性定义数据接口
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
@Mapper
public interface GeneratorDefinitionMapper extends BaseMapper<GeneratorDefinition> {

}
