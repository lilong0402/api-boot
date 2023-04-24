package top.lilong.rbac.dao;


import org.apache.ibatis.annotations.Mapper;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysUserRoleEntity;


/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

}
