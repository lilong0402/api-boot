package top.lilong.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.lilong.common.excel.DateConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2023/4/28 15:03
 * @注释
 */
@Data
public class SysUserExcelVO implements Serializable {

    @Serial
    private static final  long serialVersionUID =1L;

    @ExcelIgnore
    private Long id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty("性别")
    private Integer gender;

    @ExcelProperty("邮箱")
    private  String email;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("状态")
    private Integer ststus;

    @ExcelProperty(value = "创建时间",converter = DateConverter.class)
    private Date createTime;
}
