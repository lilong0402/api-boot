package top.lilong.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysRoleEntity;


/**
 * 角色管理 dao
 *
 * @author
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
