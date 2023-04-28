package top.lilong.convert;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import top.lilong.entity.NoticeEntity;
import top.lilong.vo.NoticeVO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T14:12:19+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class NoticeConvertImpl implements NoticeConvert {

    @Override
    public NoticeVO convert(NoticeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        NoticeVO noticeVO = new NoticeVO();

        noticeVO.setId( entity.getId() );
        noticeVO.setTitle( entity.getTitle() );
        noticeVO.setContent( entity.getContent() );
        noticeVO.setCreateTime( entity.getCreateTime() );

        return noticeVO;
    }

    @Override
    public NoticeEntity convert(NoticeVO vo) {
        if ( vo == null ) {
            return null;
        }

        NoticeEntity noticeEntity = new NoticeEntity();

        noticeEntity.setId( vo.getId() );
        noticeEntity.setCreateTime( vo.getCreateTime() );
        noticeEntity.setTitle( vo.getTitle() );
        noticeEntity.setContent( vo.getContent() );

        return noticeEntity;
    }

    @Override
    public List<NoticeVO> convertList(List<NoticeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<NoticeVO> list1 = new ArrayList<NoticeVO>( list.size() );
        for ( NoticeEntity noticeEntity : list ) {
            list1.add( convert( noticeEntity ) );
        }

        return list1;
    }
}
