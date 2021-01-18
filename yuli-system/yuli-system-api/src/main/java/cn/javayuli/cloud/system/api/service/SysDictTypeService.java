package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 字典类型service
 *
 * @author hanguilin
 */
public interface SysDictTypeService extends IService<SysDictType> {

    /**
     * 获取详情数据
     *
     * @param id 主键id
     * @return
     */
    Rest<SysDictType> getInfo(String id);

    /**
     * 查询所有数据，包括字典值
     *
     * @return
     */
    Rest<List<SysDictType>> all();
}
