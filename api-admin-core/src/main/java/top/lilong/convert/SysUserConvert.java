package top.lilong.convert;

import org.example.rbac.entity.SysUserEntity;
import org.example.rbac.vo.SysUserVO;
import org.example.security.user.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



/**
 * 系统用户实体转换
 *
 * @author
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(UserDetail userDetail);

    UserDetail convertDetail(SysUserEntity entity);

}
