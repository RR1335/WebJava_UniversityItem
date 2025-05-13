package biz.baijing.mapper;

import biz.baijing.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
员工的 DAO
 */

@Mapper
public interface EmpMapper {

    /**
     * 获取总记录数
     * @return
     */
    @Select("select count(*) from Emp")
    public Long count();

    /**
     * 分页查询获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 通过 pagehelper 进行员工信息查询
     */
    @Select("select * from emp")
    public List<Emp> list();



}
