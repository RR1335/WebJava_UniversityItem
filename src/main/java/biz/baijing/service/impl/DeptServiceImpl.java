package biz.baijing.service.impl;

import biz.baijing.mapper.DeptMapper;
import biz.baijing.pojo.Dept;
import biz.baijing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
部门接口的实现类
 */

@Service
public class DeptServiceImpl implements DeptService {

    // Service 层调用 DAO层 需要 Mapper 的 IOC 注入
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private DeptService deptService;

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

        deptMapper.insert(dept);

    }
}
