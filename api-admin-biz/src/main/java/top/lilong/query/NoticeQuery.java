package top.lilong.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lilong.common.query.Query;


/**
 * 通知管理查询参数
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {

    @Schema(description = "通知标题")
    private String title;

}
