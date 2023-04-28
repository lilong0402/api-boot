package top.lilong.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysUserEntity;

import java.util.List;
import java.util.Map;


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

    List<SysUserEntity> getList (Map<String,Object> params);

    SysUserEntity getById(@Param("id") Long id);

}
