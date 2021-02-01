package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysOfficeService;
import cn.javayuli.cloud.system.ref.entity.SysMenu;
import cn.javayuli.cloud.system.ref.entity.SysOffice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织机构controller
 *
 * @author hanguilin
 */
@Api(description = "组织机构")
@RestController
@RequestMapping("/office")
public class SysOfficeController {

    @Autowired
    private SysOfficeService sysOfficeService;

    /**
     * 获取机构树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    @ApiOperation("查询机构树")
    @GetMapping("/tree")
    public Rest<List<SysOffice>> doFindOfficeTree(@RequestParam(value = "topId", required = false) String topId,
                                              @RequestParam(value = "excludeId", required = false) String excludeId,
                                              @RequestParam(value = "type", required = false) String type) {
        return Rest.success(sysOfficeService.findOfficeTree(topId, excludeId, type));
    }

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @ApiOperation("根据id查询机构")
    @GetMapping("/info/{id}")
    public Rest<SysMenu> doInfo(@PathVariable("id") String id) {
        return Rest.success(sysOfficeService.getById(id));
    }

    /**
     * 保存数据
     *
     * @param sysOffice 菜单数据
     * @return
     */
    @ApiOperation("保存机构")
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysOffice sysOffice) {
        return sysOfficeService.save(sysOffice) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     * @param sysOffice 机构数据
     * @return
     */
    @ApiOperation("更新机构")
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysOffice sysOffice) {
        return sysOfficeService.updateOffice(sysOffice);
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @ApiOperation("删除机构")
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        return sysOfficeService.deleteOffice(ids);
    }

}
