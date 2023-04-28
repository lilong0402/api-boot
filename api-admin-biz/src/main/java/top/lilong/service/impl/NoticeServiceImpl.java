package top.lilong.service.impl;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import top.lilong.common.utils.PageResult;
import top.lilong.convert.NoticeConvert;
import top.lilong.dao.NoticeDao;
import top.lilong.entity.NoticeEntity;
import top.lilong.mybatis.service.impl.BaseServiceImpl;
import top.lilong.query.NoticeQuery;
import top.lilong.service.NoticeService;
import top.lilong.vo.NoticeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * NoticeService 实现类
 *
 * @author
 **/
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends BaseServiceImpl<NoticeDao, NoticeEntity> implements NoticeService {
    @Override
    public PageResult<NoticeVO> page(NoticeQuery query) {
        IPage<NoticeEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(NoticeConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    @Override
    public List<NoticeVO> getList() {
        NoticeQuery query = new NoticeQuery();
        List<NoticeEntity> entityList = baseMapper.selectList(getWrapper(query));
        return NoticeConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(NoticeVO vo) {
        NoticeEntity entity = NoticeConvert.INSTANCE.convert(vo);
        updateById(entity);
    }

    @Override
    public void delete(List<Long> id) {
        removeBatchByIds(id);
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void delete(List<Long> id) {
//        removeById(id);
//    }

    /**
     * 查询条件构造
     *
     * @param query 查询参数
     * @return 查询条件
     */

    private Wrapper<NoticeEntity> getWrapper(NoticeQuery query) {
        LambdaQueryWrapper<NoticeEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StrUtil.isNotBlank(query.getTitle()), NoticeEntity::getTitle, query.getTitle());
        return wrapper;
    }
}
