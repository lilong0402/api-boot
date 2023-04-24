package top.lilong.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dao.BaseDao;
import org.example.rbac.entity.SysUserRoleEntity;


/**
 * 用户角色关系 dao
 *
 * @author mqxu
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

}
