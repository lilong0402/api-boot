package top.lilong.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dao.BaseDao;
import org.example.rbac.entity.SysRoleEntity;


/**
 * 角色管理 dao
 *
 * @author
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
