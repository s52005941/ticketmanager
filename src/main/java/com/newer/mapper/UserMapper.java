package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //根据用户名查询用户对象
    @Select("select * from user where uname = #{uname}")
    public User findByuname(@Param("uname") String uname);

    //注册
    @Insert(" insert into user(uname,password,name,sex,email,phone,birthday)  " +
            " values (#{uname},#{password},#{name},#{sex},#{email},#{phone},#{birthday}) ")
    public void save(User user);
}
