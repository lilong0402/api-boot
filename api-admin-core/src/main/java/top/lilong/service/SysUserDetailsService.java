package top.lilong.service;

import org.example.rbac.entity.SysUserEntity;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户详细信息接口
 * @author
 */
public interface SysUserDetailsService {
    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
