package cn.javayuli.system.api.service.impl;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.mapper.SysDictTypeMapper;
import cn.javayuli.system.api.service.SysDictTypeService;
import cn.javayuli.system.api.service.SysDictValueService;
import cn.javayuli.system.ref.entity.SysDictType;
import cn.javayuli.system.ref.entity.SysDictValue;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        sysDictType.setValueList(sysDictValueList);
        return Rest.success(sysDictType);
    }
}
