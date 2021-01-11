package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.security.annotation.Inner;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import cn.javayuli.system.api.service.UserRoleMenuViewService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户接口
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/view")
public class SysUserRoleMenuViewController {

    @Autowired
    private UserRoleMenuViewService userRoleMenuViewService;

    @Inner
    @GetMapping("/{username}")
    public Rest<List<UserRoleMenuView>> doFindViewList(@PathVariable("username") String username) {
        List<UserRoleMenuView> list = userRoleMenuViewService.list(Wrappers.lambdaQuery(UserRoleMenuView.class).eq(UserRoleMenuView::getUsername, username));
        return Rest.success(list);
    }
}
