package top.lilong.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import top.lilong.common.utils.PageResult;
import top.lilong.common.utils.Result;
import top.lilong.rbac.query.SysLogLoginQuery;
import top.lilong.rbac.service.SysLogLoginService;
import top.lilong.rbac.vo.SysLogLoginVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录日志接口
 *
 * @author mqxu
 **/
@RestController
@RequestMapping("sys/log/login")
@Tag(name = "登录日志")
@AllArgsConstructor
public class SysLogLoginController {
    private final SysLogLoginService sysLogLoginService;

    @GetMapping("page")
    @Operation(summary = "登录日志分页")
    //授权
    public Result<PageResult<SysLogLoginVO>> page(@ParameterObject @Valid SysLogLoginQuery query) {
        PageResult<SysLogLoginVO> page = sysLogLoginService.page(query);
        return Result.ok(page);
    }
}
