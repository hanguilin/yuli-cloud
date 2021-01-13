package cn.javayuli.system.ref.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 菜单
 *
 * @author hanguilin
 */
@TableName("user_role_menu_view")
public class UserRoleMenuView extends Model<UserRoleMenuView> {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 登录名
     */
    private String username;

    /**
     * 用户名
     */
    private String nickname;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色英文名
     */
    private String roleEnName;

    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 菜单标题
     */
    private String menuTitle;

    /**
     * 菜单路径
     */
    private String menuPath;

    /**
     * 菜单图标类
     */
    private String menuIcon;

    /**
     * 菜单是否可见
     */
    private String menuVisible;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 菜单链接类型 0，系统页面；1，外链
     */
    private String menuTarget;

    /**
     * 菜单权限标识
     */
    private String menuPermission;

    /**
     * 菜单排序
     */
    private Integer menuSort;

    /**
     * 菜单父id
     */
    private String menuParentId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleEnName() {
        return roleEnName;
    }

    public void setRoleEnName(String roleEnName) {
        this.roleEnName = roleEnName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuVisible() {
        return menuVisible;
    }

    public void setMenuVisible(String menuVisible) {
        this.menuVisible = menuVisible;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }
}
