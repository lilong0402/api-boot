package top.lilong.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysUserEntity;


/**
 * 系统用户管理 dao
 *
 * @author
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
}
