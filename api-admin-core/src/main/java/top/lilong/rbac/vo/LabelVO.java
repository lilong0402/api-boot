package top.lilong.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2023/4/25 14:00
 * @注释
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "分类统计标签")
public class LabelVO implements Serializable {

 @Serial
 private static final  long serialVersionUID = 1L;

 @Schema(description = "标签名",requiredMode = Schema.RequiredMode.REQUIRED)
 private String label;

 @Schema(description = "标签值",requiredMode = Schema.RequiredMode.REQUIRED)
 private Integer value;
}
