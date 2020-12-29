package cn.javayuli.security.entity;

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

    public YuLiUser(String id, String account, String password, Collection<? extends GrantedAuthority> authorities) {
        super(account, password, authorities);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
