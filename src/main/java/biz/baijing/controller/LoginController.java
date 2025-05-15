package biz.baijing.controller;


import biz.baijing.pojo.Emp;
import biz.baijing.pojo.Result;
import biz.baijing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录：{}",emp);
        Emp e = empService.login(emp);

        if (e == null) {
            return Result.error("用户名或密码错误。");
        }
        return Result.success(e);
        // return e != null?Result.success(e):Result.error("用户名密码错误.")
    }




}
