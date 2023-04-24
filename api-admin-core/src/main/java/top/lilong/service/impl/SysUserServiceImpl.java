package top.lilong.service.impl;
import lombok.AllArgsConstructor;
import org.example.mybatis.service.impl.BaseServiceImpl;
import org.example.rbac.dao.SysUserDao;
import org.example.rbac.entity.SysUserEntity;
import org.example.rbac.service.SysUserService;
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
