package top.lilong.rbac.service;


import top.lilong.mybatis.service.BaseService;
import top.lilong.rbac.entity.SysMenuEntity;
import top.lilong.rbac.vo.SysMenuVO;
import top.lilong.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * 系统菜单业务接口
 *
 * @author
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {
    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}
