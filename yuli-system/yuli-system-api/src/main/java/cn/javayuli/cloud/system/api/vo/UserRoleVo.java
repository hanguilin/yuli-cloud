package cn.javayuli.cloud.system.api.vo;

/**
 * 用户角色值传递类
 *
 * @author hanguilin
 */
public class UserRoleVo {

    /**
     * 主id
     */
    private String id;

    /**
     * 从id,可多个
     */
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
