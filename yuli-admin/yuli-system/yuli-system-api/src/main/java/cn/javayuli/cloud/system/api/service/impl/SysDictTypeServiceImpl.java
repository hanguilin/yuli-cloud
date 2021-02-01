package cn.javayuli.cloud.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.cloud.common.core.constant.CacheNames;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.mapper.SysDictTypeMapper;
import cn.javayuli.cloud.system.api.service.SysDictTypeService;
import cn.javayuli.cloud.system.api.service.SysDictValueService;
import cn.javayuli.cloud.system.ref.entity.SysDictType;
import cn.javayuli.cloud.system.ref.entity.SysDictValue;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 字典类型实现类
 *
 * @author hanguilin
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    @Autowired
    private SysDictValueService sysDictValueService;

    /**
     * 获取详情数据
     *
     * @param id 主键id
     * @return
     */
    @Override
    public Rest<SysDictType> getInfo(String id) {
        SysDictType sysDictType = getById(id);
        if (sysDictType == null) {
            return Rest.fail("字典类型不存在");
        }
        List<SysDictValue> sysDictValueList = sysDictValueService.list(Wrappers.lambdaQuery(SysDictValue.class).eq(SysDictValue::getTypeId, id));
        Collections.sort(sysDictValueList, Comparator.comparing(SysDictValue::getSort));
        sysDictType.setDictValueList(sysDictValueList);
        return Rest.success(sysDictType);
    }

    /**
     * 查询所有数据，包括字典值
     *
     * @return
     */
    @Cacheable(value = CacheNames.DICT_DETAILS)
    @Override
    public Rest<List<SysDictType>> all() {
        List<SysDictType> dictTypeList = list(Wrappers.lambdaQuery(SysDictType.class).select(SysDictType::getId, SysDictType::getType));
        List<SysDictValue> dictValueList = sysDictValueService.list(Wrappers.lambdaQuery(SysDictValue.class).select(SysDictValue::getTypeId, SysDictValue::getLabel, SysDictValue::getValue));
        Map<String, List<SysDictValue>> groupingBy = dictValueList.stream().collect(Collectors.groupingBy(SysDictValue::getTypeId));
        dictTypeList.forEach(o -> {
            List<SysDictValue> sysDictValues = groupingBy.get(o.getId());
            if (CollUtil.isNotEmpty(sysDictValues)) {
                // 去除额外字段
                sysDictValues.forEach(k -> k.setTypeId(null));
                o.setDictValueList(sysDictValues);
            }
            // 去除额外字段
            o.setId(null);
        });
        return Rest.success(dictTypeList);
    }
}
