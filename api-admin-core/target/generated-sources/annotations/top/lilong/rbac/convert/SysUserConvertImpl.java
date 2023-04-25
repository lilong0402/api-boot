package top.lilong.rbac.convert;

import javax.annotation.processing.Generated;
import top.lilong.rbac.entity.SysUserEntity;
import top.lilong.rbac.vo.SysUserVO;
import top.lilong.security.user.UserDetail;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T10:48:48+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserVO convert(UserDetail userDetail) {
        if ( userDetail == null ) {
            return null;
        }

        SysUserVO sysUserVO = new SysUserVO();

        sysUserVO.setId( userDetail.getId() );
        sysUserVO.setUsername( userDetail.getUsername() );
        sysUserVO.setPassword( userDetail.getPassword() );
        sysUserVO.setRealName( userDetail.getRealName() );
        sysUserVO.setAvatar( userDetail.getAvatar() );
        sysUserVO.setGender( userDetail.getGender() );
        sysUserVO.setEmail( userDetail.getEmail() );
        sysUserVO.setMobile( userDetail.getMobile() );
        sysUserVO.setStatus( userDetail.getStatus() );
        sysUserVO.setSuperAdmin( userDetail.getSuperAdmin() );

        return sysUserVO;
    }

    @Override
    public UserDetail convertDetail(SysUserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetail userDetail = new UserDetail();

        userDetail.setId( entity.getId() );
        userDetail.setUsername( entity.getUsername() );
        userDetail.setPassword( entity.getPassword() );
        userDetail.setRealName( entity.getRealName() );
        userDetail.setAvatar( entity.getAvatar() );
        userDetail.setGender( entity.getGender() );
        userDetail.setEmail( entity.getEmail() );
        userDetail.setMobile( entity.getMobile() );
        userDetail.setStatus( entity.getStatus() );
        userDetail.setSuperAdmin( entity.getSuperAdmin() );

        return userDetail;
    }
}
