package biz.baijing.mapper;

import biz.baijing.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
部门管理 DAO
 */

@Mapper
public interface DeptMapper {

    /**
     * 查询部门列表
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);



    /**
     * 插入部门
     * @param dept
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    List<Dept> listById(Integer id);

    @Update("update dept set name = #{name} , update_time = #{updateTime} where id = #{id}  " )
    void update(Dept dept);
}
