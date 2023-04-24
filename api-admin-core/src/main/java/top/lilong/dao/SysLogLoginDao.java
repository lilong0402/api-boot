package top.lilong.dao;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dao.BaseDao;
import org.example.rbac.entity.SysLogLoginEntity;


/**
 * 登录日志 dao
 *
 * @author mqxu
 **/
@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}
