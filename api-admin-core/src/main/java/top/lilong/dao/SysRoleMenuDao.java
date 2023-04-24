package top.lilong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dao.BaseDao;
import org.example.rbac.entity.SysRoleMenuEntity;


/**
 * 角色与菜单对应关系 dao
 *
 * @author
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
