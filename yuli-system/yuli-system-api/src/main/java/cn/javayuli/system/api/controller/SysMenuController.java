package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.security.util.YuLiSecurityUtil;
import cn.javayuli.system.api.service.SysMenuService;
import cn.javayuli.system.ref.entity.SysMenu;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
     * 获取菜单树
     *
     * @return
     */
    @GetMapping("/tree/own")
    public Rest<List<SysMenu>> doOwnMenuTree() {
        String currentUser = YuLiSecurityUtil.getUser().getUsername();
        return Rest.success(sysMenuService.ownMenuTree(currentUser));
    }

    /**
     * 获取表格中菜单树
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
        return sysMenuService.save(sysMenu) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     * @param sysMenu 菜单数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysMenu sysMenu) {
        return sysMenuService.updateById(sysMenu) ? Rest.success() : Rest.fail("更新失败");
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        return sysMenuService.removeByIds(idList) ? Rest.success() : Rest.fail("删除失败");
    }

}
