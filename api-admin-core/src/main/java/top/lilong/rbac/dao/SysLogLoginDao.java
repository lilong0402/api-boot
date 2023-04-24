package top.lilong.rbac.dao;
import org.apache.ibatis.annotations.Mapper;
import top.lilong.mybatis.dao.BaseDao;
import top.lilong.rbac.entity.SysLogLoginEntity;


/**
 * 登录日志 dao
 *
 * @author mqxu
 **/
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}
