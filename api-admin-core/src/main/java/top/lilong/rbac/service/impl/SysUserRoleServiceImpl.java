package top.lilong.rbac.service.impl;
import org.example.mybatis.service.impl.BaseServiceImpl;
import org.example.rbac.dao.SysUserRoleDao;
import org.example.rbac.entity.SysUserRoleEntity;
import org.example.rbac.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系业务实现类
 *
 * @author
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}
