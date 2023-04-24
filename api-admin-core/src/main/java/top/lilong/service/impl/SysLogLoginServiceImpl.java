package top.lilong.service.impl;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.servlet.http.HttpServletRequest;
import org.example.common.utils.AddressUtils;
import org.example.common.utils.HttpContextUtils;
import org.example.common.utils.IpUtils;
import org.example.common.utils.PageResult;
import org.example.mybatis.service.impl.BaseServiceImpl;
import org.example.rbac.controller.SysLogLoginConvert;
import org.example.rbac.dao.SysLogLoginDao;
import org.example.rbac.entity.SysLogLoginEntity;
import org.example.rbac.query.SysLogLoginQuery;
import org.example.rbac.service.SysLogLoginService;
import org.example.rbac.vo.SysLogLoginVO;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 登录日志业务实现类
 *
 * @author
 **/
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

    @Override
    public PageResult<SysLogLoginVO> page(SysLogLoginQuery query) {
        IPage<SysLogLoginEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<SysLogLoginEntity> list = page.getRecords();
        List<SysLogLoginVO> resList = SysLogLoginConvert.INSTANCE.converList(list);
        long count = page.getTotal();
        return new PageResult<>(resList, count);
    }

    private LambdaQueryWrapper<SysLogLoginEntity> getWrapper(SysLogLoginQuery query) {
        LambdaQueryWrapper<SysLogLoginEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(query.getUsername()), SysLogLoginEntity::getUsername, query.getUsername());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()), SysLogLoginEntity::getAddress, query.getAddress());
        wrapper.like(query.getStatus() != null, SysLogLoginEntity::getStatus, query.getStatus());
        wrapper.orderByDesc(SysLogLoginEntity::getId);
        return wrapper;
    }

    @Override
    public void save(String username, Integer status, Integer operation) {
        // 获得请求对象
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 从请求对象中获取请求地址、IP、UA 等信息
        assert request != null;
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);  // 要加 org.springframework.http.HttpHeaders
        String ip = IpUtils.getIpAddr(request);
        String address = AddressUtils.getAddressByIP(ip);

        SysLogLoginEntity entity = new SysLogLoginEntity();
        entity.setUsername(username);
        entity.setIp(ip);
        entity.setAddress(address);
        entity.setUserAgent(userAgent);
        entity.setStatus(status);
        entity.setOperation(operation);
        baseMapper.insert(entity);
    }
}
