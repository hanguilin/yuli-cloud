package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysMenuService;
import cn.javayuli.cloud.system.ref.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单controller
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 获取表格中菜单树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    @GetMapping("/tree")
    public Rest<List<SysMenu>> doFindMenuTree(@RequestParam(value = "topId", required = false) String topId,
                                              @RequestParam(value = "excludeId", required = false) String excludeId,
                                              @RequestParam(value = "type", required = false) String type) {
        return Rest.success(sysMenuService.findMenuTree(topId, excludeId, type));
    }

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<SysMenu> doInfo(@PathVariable("id") String id) {
        return Rest.success(sysMenuService.getById(id));
    }

    /**
     * 保存数据
     *
     * @param sysMenu 菜单数据
     * @return
     */
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysMenu sysMenu) {
        return sysMenuService.saveMenu(sysMenu);
    }

    /**
     * 更新数据
     * @param sysMenu 菜单数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysMenu sysMenu) {
        return sysMenuService.updateMenu(sysMenu);
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        return sysMenuService.deleteMenu(ids);
    }

}
