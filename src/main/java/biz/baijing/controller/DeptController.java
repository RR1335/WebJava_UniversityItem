package biz.baijing.controller;

import biz.baijing.pojo.Dept;
import biz.baijing.pojo.Result;
import biz.baijing.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 查询部门列表
     * @return
     */
    @GetMapping("/depts")
    public Result list() {
        log.info("查询全部部门数据。");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门，根据 id
     * @param id
     * @return
     */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门：{}", id);
        // 调用 service 删除部门
        deptService.delete(id);

        return Result.success();
    }

    /**
     * 增加部门
     * @param dept
     * @return
     */
    // 增加部门，前端传递的是 JSON 格式数据，通过 @RequestBody 接收 JSON 数据
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }


}
