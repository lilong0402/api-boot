package top.lilong.rbac.service.impl;

import lombok.AllArgsConstructor;
import top.lilong.mybatis.service.impl.BaseServiceImpl;
import top.lilong.rbac.dao.SysRoleDao;
import top.lilong.rbac.entity.SysRoleEntity;
import top.lilong.rbac.service.SysRoleService;
import org.springframework.stereotype.Service;


/**
 * 系统角色业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}
