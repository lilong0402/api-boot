package top.lilong.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dao.BaseDao;
import org.example.rbac.entity.SysUserEntity;


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
