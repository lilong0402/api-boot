package top.lilong.rbac.convert;

import top.lilong.rbac.entity.SysLogLoginEntity;
import top.lilong.rbac.vo.SysLogLoginVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 登录日志实体转换
 *
 * @author moqi
 */
@Mapper
public interface SysLogLoginConvert {
    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);

    SysLogLoginEntity convert(SysLogLoginVO vo);

    SysLogLoginVO convert(SysLogLoginEntity entity);

    List<SysLogLoginVO> converList(List<SysLogLoginEntity> list);

}
