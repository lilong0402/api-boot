package top.lilong.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysRoleMenuEntity;


/**
 * 角色与菜单对应关系 dao
 *
 * @author
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
