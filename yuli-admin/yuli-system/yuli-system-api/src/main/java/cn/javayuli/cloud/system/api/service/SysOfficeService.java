package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysOffice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 机构service
 *
 * @author hanguilin
 */
public interface SysOfficeService extends IService<SysOffice> {

    /**
     * 获取机构树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    List<SysOffice> findOfficeTree(String topId, String excludeId, String type);

    /**
     * 更新数据
     * @param sysOffice 机构数据
     * @return
     */
    Rest<Boolean> updateOffice(SysOffice sysOffice);

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    Rest<Boolean> deleteOffice(String ids);
}
