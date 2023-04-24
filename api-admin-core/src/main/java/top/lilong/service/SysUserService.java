package top.lilong.service;
import org.example.mybatis.service.BaseService;
import org.example.rbac.entity.SysUserEntity;
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
}
