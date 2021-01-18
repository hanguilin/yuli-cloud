package cn.javayuli.cloud.common.core.entity;

import cn.javayuli.cloud.common.core.constant.FlagConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

/**
 * 扩展用户信息
 *
 * @author hanguilin
 */
public class YuLiUser extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户是否启用
     */
    private String enabled;

    public YuLiUser(String id, String username, String password, String nickname, String enabled, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, FlagConstant.TRUE.equals(enabled), true, true, true, authorities);
        this.id = id;
        this.nickname = nickname;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
