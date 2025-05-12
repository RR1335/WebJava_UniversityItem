package biz.baijing.service.impl;

import biz.baijing.mapper.DeptMapper;
import biz.baijing.pojo.Dept;
import biz.baijing.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/*
部门接口的实现类
 */

@Service
public class DeptServiceImpl implements DeptService {

    // Service 层调用 DAO层 需要 Mapper 的 IOC 注入
    @Autowired
    private DeptMapper deptMapper;

    /*
     查询全部部门数据
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
