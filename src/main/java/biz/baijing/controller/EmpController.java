package biz.baijing.controller;

import biz.baijing.pojo.PageBean;
import biz.baijing.pojo.Result;
import biz.baijing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
员工管理 Controller
 */

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     *
     * @param page           // 和前端一致，默认： 1
     * @param pageSize      //  和前端一致，默认： 10
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询，参数：{},{}", page, pageSize);
        // 调用 service 分页查询
        PageBean pageBean = empService.page(page,pageSize);

        return Result.success(pageBean);
    }
}
