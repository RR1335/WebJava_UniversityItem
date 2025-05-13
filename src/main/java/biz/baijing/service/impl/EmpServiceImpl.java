package biz.baijing.service.impl;

import biz.baijing.mapper.EmpMapper;
import biz.baijing.pojo.Emp;
import biz.baijing.pojo.PageBean;
import biz.baijing.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
员工接口的实现类
 */

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 获取总记录数
        Long count = empMapper.count();
        // 分页查询的列表，结果
        Integer start = (page - 1) * pageSize;
        List<Emp> list = empMapper.page(start, pageSize);
        // 封装结果到 PageBean
        PageBean pageBean = new PageBean(count, list);
        return pageBean;
    }
}
