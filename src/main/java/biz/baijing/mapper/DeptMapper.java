package biz.baijing.mapper;

import biz.baijing.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
部门管理 DAO
 */

@Mapper
public interface DeptMapper {

    /*
     查询全部部门数据
     */
    @Select("select * from dept")
    List<Dept> list();
}
