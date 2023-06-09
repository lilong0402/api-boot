package top.lilong.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import top.lilong.common.utils.PageResult;
import top.lilong.common.utils.Result;
import top.lilong.convert.NoticeConvert;
import top.lilong.entity.NoticeEntity;
import top.lilong.query.NoticeQuery;
import top.lilong.service.NoticeService;
import top.lilong.vo.NoticeVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 通知模块接口
 *
 * @author
 **/
@RestController
@RequestMapping("/sys/notice")
@Tag(name = "通知管理")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/page")
    @Operation(summary = "通知分页")
    @PreAuthorize("hasAuthority('sys:notice:page')")
    public Result<PageResult<NoticeVO>> page(@ParameterObject @Valid NoticeQuery query) {
        PageResult<NoticeVO> page = noticeService.page(query);
//        System.out.println(page);
        return Result.ok(page);
    }

    @GetMapping("/list")
    @Operation(summary = "通知列表")
    public Result<List<NoticeVO>> list() {
        List<NoticeVO> list = noticeService.getList();
        return Result.ok(list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "通知信息")
    @PreAuthorize("hasAuthority('sys:notice:info')")
    public Result<NoticeVO> get(@PathVariable("id") Long id) {
        NoticeEntity entity = noticeService.getById(id);
        return Result.ok(NoticeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增通知")
    @PreAuthorize("hasAuthority('sys:notice:save')")
    public Result<String> save(@RequestBody NoticeVO vo) {
        noticeService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改通知")
    @PreAuthorize("hasAuthority('sys:notice:update')")
    public Result<String> update(@RequestBody @Valid NoticeVO vo) {
        noticeService.update(vo);
        return Result.ok();
    }

//    @DeleteMapping("{id}")
//    @Operation(summary = "删除通知")
//    @PreAuthorize("hasAuthority('sys:notice:delete')")
//    public Result<String> delete(@PathVariable Long id) {
//        noticeService.delete(id);
//        return Result.ok();
//    }

    @PostMapping("/delete")
    @Operation(summary = "批量删除通告")
    @PreAuthorize("hasAnyAuthority('sys:notice:delete')")
    public Result<String> delete (@RequestBody(required = false) List<Long> ids){
        System.out.println(ids);
        noticeService.delete(ids);
        return Result.ok("删除成功");
    }

}
