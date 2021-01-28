package cn.javayuli.cloud.system.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户角色值传递类
 *
 * @author hanguilin
 */
@ApiModel("用户角色值传递类")
public class UserRoleVo {

    /**
     * 主id
     */
    @ApiModelProperty("主id")
    private String id;

    /**
     * 从id,可多个
     */
    @ApiModelProperty("从id")
    private String ids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
