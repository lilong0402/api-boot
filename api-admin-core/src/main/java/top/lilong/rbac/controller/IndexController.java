package top.lilong.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lilong.common.utils.Result;
import top.lilong.rbac.service.IndexService;
import top.lilong.rbac.vo.BarVO;
import top.lilong.rbac.vo.LabelVO;
import top.lilong.rbac.vo.PanelVO;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2023/4/25 14:17
 * @注释
 */
@RestController
@RequestMapping("/sys/index")
@AllArgsConstructor
public class IndexController {
 private final IndexService indexService;

 @GetMapping("statistics1")
 @Operation(summary = "统计组件1")
 public Result<List<PanelVO>> getStatistics1() {
  List<PanelVO> list = indexService . statistics1();
  return  Result.ok(list);
 }
 @GetMapping("statistics2")
 @Operation(summary = "统计组件2")
 public Result<BarVO> getStatistics(String type){
  BarVO barVO = indexService.statistics2(type);
  return Result.ok(barVO);
 }
 @GetMapping("statistics3")
 @Operation(summary = "统计组件2")
 public Result<Map<String,List<LabelVO>>> getStatistics3(){
  Map<String , List<LabelVO>> map =indexService.statistics3();
  return Result.ok(map);
 }
}
