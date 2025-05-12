package biz.baijing.service;

/*
部门管理
 */

import biz.baijing.pojo.Dept;

import java.util.List;

public interface DeptService {

    /*
     查询全部部门数据
     */
    List<Dept> list();
}
