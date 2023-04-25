package top.lilong.rbac.service;

import top.lilong.rbac.vo.BarVO;
import top.lilong.rbac.vo.LabelVO;
import top.lilong.rbac.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author 李龙
 * @Date 2023/4/25 14:03
 * @注释
 */
public interface IndexService {
 List<PanelVO> statistics1();

 BarVO statistics2();

 Map<String ,List<LabelVO>> statistics3();
}
