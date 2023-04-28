package top.lilong.rbac.convert;

import top.lilong.rbac.entity.SysUserEntity;
import top.lilong.rbac.vo.SysUserExcelVO;
import top.lilong.rbac.vo.SysUserVO;
import top.lilong.security.user.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * 系统用户实体转换
 *
 * @author
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);
    SysUserVO convert(UserDetail userDetail);

    UserDetail convertDetail(SysUserEntity entity);

    List<SysUserVO> convertList(List<SysUserEntity> list);

    List<SysUserExcelVO> convert2List(List<SysUserEntity> list);

    List<SysUserEntity> convertListEtity(List<SysUserExcelVO> list);
}
