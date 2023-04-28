package top.lilong.rbac.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;
import top.lilong.common.constant.Constant;
import top.lilong.common.excel.ExcelFinishCallBack;
import top.lilong.common.utils.DateUtils;
import top.lilong.common.utils.ExcelUtils;
import top.lilong.common.utils.PageResult;
import top.lilong.mybatis.service.impl.BaseServiceImpl;
import top.lilong.rbac.convert.SysUserConvert;
import top.lilong.rbac.dao.SysUserDao;
import top.lilong.rbac.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lilong.rbac.enums.SuperAdminEnum;
import top.lilong.rbac.query.SysUserQuery;
import top.lilong.rbac.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lilong.rbac.vo.SysUserExcelVO;
import top.lilong.rbac.vo.SysUserVO;

import java.rmi.ServerError;
import java.rmi.ServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 系统用户业务实现类
 *
 * @author
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        // 查询参数
        Map<String, Object> params = getParams(query);
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE,page);
        List<SysUserEntity> list = baseMapper.getList(params);
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list), page.getTotal());

    }
    private Map<String,Object> getParams(SysUserQuery query){
        Map<String, Object> params = new HashMap<>();
        params.put("username",query.getUsername());
        params.put("mobile",query.getMobile());
        params.put("gender",query.getGender());
        return params;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) throws ServerException {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());

        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null){
            throw new ServerException("用户名已经存在");
        }
        baseMapper.insert(entity);
    }

    @Override
    public void update(SysUserVO vo) throws ServerException {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);

        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user !=null && !user.getId().equals(entity.getId())){
            throw new ServerException("用户名已经存在");
        }
        updateById(entity);

    }

    @Override
    public void delete(List<Long> ids) {
        removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importByExcel(MultipartFile file, String password) {
        ExcelUtils.readAnalysis(file, SysUserExcelVO.class, new ExcelFinishCallBack<SysUserExcelVO>() {
            @Override
            public void doAfterAllAnalysed(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            @Override
            public void doSaveBatch(List<SysUserExcelVO> result) {
                saveUser(result);
            }

            private void  saveUser(List<SysUserExcelVO> result){
                ExcelUtils.parseDict(result);

                List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertListEtity(result);

                sysUserEntities.forEach(user -> user.setPassword(password));

                saveBatch(sysUserEntities);
            }
        });
    }

    @Override
    @SneakyThrows
    public void export() {
        List<SysUserEntity> list = list(Wrappers.lambdaQuery(SysUserEntity.class).eq(SysUserEntity::getSuperAdmin,
                SuperAdminEnum.NO.getValue()));
        List<SysUserExcelVO> userExcelVOList = SysUserConvert.INSTANCE.convert2List(list);
        ExcelUtils.excelExport(SysUserExcelVO.class,"system_user_excel" + DateUtils.format(new Date(), "sheet1" ,userExcelVOList));
    }


}
