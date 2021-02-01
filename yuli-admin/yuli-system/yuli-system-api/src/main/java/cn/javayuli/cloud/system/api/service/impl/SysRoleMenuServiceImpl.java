package cn.javayuli.cloud.system.api.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.constant.CacheNames;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.mapper.SysRoleMenuMapper;
import cn.javayuli.cloud.system.api.service.SysRoleMenuService;
import cn.javayuli.cloud.system.ref.entity.SysRole;
import cn.javayuli.cloud.system.ref.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色菜单关联实现类
 *
 * @author hanguilin
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    /**
     * 更新角色菜单数据
     *
     * @param sysRole 角色
     * @return
     */
    @CacheEvict(value = CacheNames.USER_DETAILS, allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateRoleMenu(SysRole sysRole) {
        String roleId = sysRole.getId();
        if (StrUtil.isBlank(roleId)) {
            return Rest.fail("缺少角色id");
        }
        // 移除旧数据
        remove(Wrappers.lambdaQuery(SysRoleMenu.class).eq(SysRoleMenu::getRoleId, roleId));
        String menuIds = sysRole.getMenuIds();
        if (StrUtil.isNotBlank(menuIds)) {
            List<String> ids = Splitter.on(",").splitToList(menuIds);
            List<SysRoleMenu> sysRoleMenuList = ids.stream().map(o -> new SysRoleMenu(roleId, o)).collect(Collectors.toList());
            // 插入新数据
            saveBatch(sysRoleMenuList);
        }
        return Rest.success();
    }
}
