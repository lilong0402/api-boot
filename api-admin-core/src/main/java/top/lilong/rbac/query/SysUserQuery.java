package top.lilong.rbac.query;

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
@Schema(description = "用户管理查询")
public class SysUserQuery extends Query {

    @Schema(description = "通知标题")
    private String title;


    public Object getMobile() {
    }

    public Object getUsername() {
    }
    public Object getParams() {
    }

    public Object getGender() {
    }
}
