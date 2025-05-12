package biz.baijing.controller;

import biz.baijing.pojo.Dept;
import biz.baijing.pojo.Result;
import biz.baijing.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
部门管理 Controller
 */

@Slf4j
@RestController
public class DeptController {

    // slf4j Logger
    // private static final Logger logger = LoggerFactory.getLogger(DeptController.class);

    // 限定请求方式 GET
     // @RequestMapping(value = "/depts",method = RequestMethod.GET)

    // Controller 层调用 service 层，需要 service 层的 IOC 注入
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据。");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }
}
