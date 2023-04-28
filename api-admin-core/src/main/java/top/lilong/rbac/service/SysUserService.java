package top.lilong.rbac.service;
import org.springframework.web.multipart.MultipartFile;
import top.lilong.common.utils.PageResult;
import top.lilong.mybatis.service.BaseService;
import top.lilong.rbac.entity.SysUserEntity;
import top.lilong.rbac.query.SysUserQuery;
import top.lilong.rbac.vo.SysUserVO;

import java.rmi.ServerException;
import java.util.List;

/**
 * 系统用户业务接口
 *
 * @author
 */
public interface SysUserService extends BaseService<SysUserEntity> {


    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    PageResult<SysUserVO> page(SysUserQuery query);

    void save(SysUserVO vo) throws ServerException;

    void update(SysUserVO vo) throws ServerException;

    void delete(List<Long> ids);

    void importByExcel(MultipartFile file,String password);

    void export();
}
