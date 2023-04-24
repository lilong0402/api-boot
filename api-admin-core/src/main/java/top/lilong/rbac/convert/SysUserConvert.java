package top.lilong.rbac.convert;

import top.lilong.rbac.entity.SysUserEntity;
import top.lilong.rbac.vo.SysUserVO;
import top.lilong.security.user.UserDetail;
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
