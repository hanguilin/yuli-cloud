package cn.javayuli.cloud.system.ref.feign;

import cn.javayuli.cloud.common.core.constant.ServiceConstants;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.feign.factory.RemoteMenuServiceFallbackFactory;
import cn.javayuli.cloud.system.ref.vo.MenuUnitVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 远程调用系统服务
 *
 * @author hanguilin
 */
@FeignClient(path = "/menu", contextId = "remoteMenuService", value = ServiceConstants.SYSTEM_API,
        fallbackFactory = RemoteMenuServiceFallbackFactory.class)
public interface RemoteMenuService {

    /**
     * 保存单元菜单
     * 单元指一个目录加增删改查按钮
     *
     * @param menuUnitVo 菜单数据
     * @return
     */
    @PostMapping("/saveMenuUnit")
    Rest<Boolean> doSaveMenuUnit(@RequestBody MenuUnitVo menuUnitVo);
}
