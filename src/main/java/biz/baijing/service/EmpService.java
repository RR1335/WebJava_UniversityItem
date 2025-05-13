package biz.baijing.service;

/*
员工管理
 */

import biz.baijing.pojo.PageBean;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
