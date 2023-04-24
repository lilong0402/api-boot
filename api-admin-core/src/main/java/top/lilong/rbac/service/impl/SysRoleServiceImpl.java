package top.lilong.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.example.mybatis.service.impl.BaseServiceImpl;
import org.example.rbac.dao.SysRoleDao;
import org.example.rbac.entity.SysRoleEntity;
import org.example.rbac.service.SysRoleService;
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
