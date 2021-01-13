package cn.javayuli.system.api.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.mapper.SysUserRoleMapper;
import cn.javayuli.system.api.service.SysUserRoleService;
import cn.javayuli.system.api.vo.UserRoleVo;
import cn.javayuli.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户关联角色实现类
 *
 * @author hanguilin
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    /**
     * 保存角色数据
     *
     * @param userRoleVo 用户角色保存对象
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> saveByRole(UserRoleVo userRoleVo) {
        String id = userRoleVo.getId();
        String ids = userRoleVo.getIds();
        if (StrUtil.isBlank(id) || StrUtil.isBlank(ids)) {
            return Rest.fail("缺少参数，保存失败");
        }
        // 批量删除旧数据
        remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getRoleId, id));
        List<String> idList = Splitter.on(",").splitToList(ids);
        List<SysUserRole> sysUserRoleList = idList.stream().map(o -> new SysUserRole(o, id)).collect(Collectors.toList());
        // 批量保存新数据
        saveBatch(sysUserRoleList);
        return Rest.success();
    }
}
