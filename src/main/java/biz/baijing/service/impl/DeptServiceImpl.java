package biz.baijing.service.impl;

import biz.baijing.mapper.DeptMapper;
import biz.baijing.pojo.Dept;
import biz.baijing.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
部门接口的实现类
 */
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    // Service 层调用 DAO层 需要 Mapper 的 IOC 注入
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询部门列表
     * @return
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    /**
     * 删除部门
     * @param id
     */
    @Override
    public void delete(Integer id) {
        // 判断 id 是否存在，存在继续；不存在，输出不存在，报错结束
        deptMapper.deleteById(id);
    }


    /**
     * 新增部门
     */
    @Override
    public void add(Dept dept) {
        // 前端传递的部门信息 — 部门名称 ；需要补全信息
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        // 判断 新增部门的名称是否存在，存在则结束 —— 返回一个错误信息（部门已存在请重新输入）
//        Integer c = deptMapper.getByName(dept);
//        if( c > 0 ){
//            log.info("查询结果 {}",c);
//            System.out.println("已存在，请重新输入：");
//        }

        deptMapper.insert(dept);

    }


    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }


}
