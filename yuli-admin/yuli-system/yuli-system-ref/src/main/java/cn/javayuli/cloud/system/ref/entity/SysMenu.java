package cn.javayuli.cloud.system.ref.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 菜单
 *
 * @author hanguilin
 */
@ApiModel("菜单")
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 路由路径
     */
    @ApiModelProperty("路由路径")
    private String path;

    /**
     * 外链url
     */
    @ApiModelProperty("外链url")
    private String url;

    /**
     * 图标样式
     */
    @ApiModelProperty("图标样式")
    private String icon;

    /**
     * 是否可见
     */
    @ApiModelProperty("是否可见")
    private String visible;

    /**
     * 类型 0、目录；1、菜单；2、按钮
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 链接类型 0、系统页面；1、外链
     */
    @ApiModelProperty("链接类型")
    private String target;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String permission;

    /**
     * 排序号
     */
    @ApiModelProperty("排序号")
    private Integer sort;

    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private String parentId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人id")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人id")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @ApiModelProperty("描述")
    private String remark;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private String delFlag;

    /**
     * 子菜单
     */
    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<SysMenu> children;

    @ApiModelProperty("直接父菜单")
    @TableField(exist = false)
    private SysMenu parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public SysMenu getParent() {
        return parent;
    }

    public void setParent(SysMenu parent) {
        this.parent = parent;
    }
}
