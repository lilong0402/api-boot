package top.lilong.rbac.service.impl;
import lombok.AllArgsConstructor;
import org.example.rbac.convert.SysUserConvert;
import org.example.rbac.entity.SysUserEntity;
import org.example.rbac.enums.UserStatusEnum;
import org.example.rbac.service.SysMenuService;
import org.example.rbac.service.SysUserDetailsService;
import org.example.security.user.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;


/**
 * 用户详细信息接口实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserDetailsServiceImpl implements SysUserDetailsService {
    private final SysMenuService sysMenuService;

    @Override
    public UserDetails getUserDetails(SysUserEntity userEntity) {
        // 转换成UserDetail对象
        UserDetail userDetail = SysUserConvert.INSTANCE.convertDetail(userEntity);

        // 账号不可用
        if (userEntity.getStatus() == UserStatusEnum.DISABLE.getValue()) {
            userDetail.setEnabled(false);
        }

        // 用户权限列表
        Set<String> authoritySet = sysMenuService.getUserAuthority(userDetail);
        userDetail.setAuthoritySet(authoritySet);

        return userDetail;
    }
}
