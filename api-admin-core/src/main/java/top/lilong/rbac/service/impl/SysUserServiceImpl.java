package top.lilong.rbac.service.impl;
import lombok.AllArgsConstructor;
import top.lilong.mybatis.service.impl.BaseServiceImpl;
import top.lilong.rbac.dao.SysUserDao;
import top.lilong.rbac.entity.SysUserEntity;
import top.lilong.rbac.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 系统用户业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

}
