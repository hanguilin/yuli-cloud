package cn.javayuli.system.api.service;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysDictType;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
