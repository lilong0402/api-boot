package top.lilong.rbac.service.impl;
import top.lilong.mybatis.service.impl.BaseServiceImpl;
import top.lilong.rbac.dao.SysUserRoleDao;
import top.lilong.rbac.entity.SysUserRoleEntity;
import top.lilong.rbac.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系业务实现类
 *
 * @author
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}
