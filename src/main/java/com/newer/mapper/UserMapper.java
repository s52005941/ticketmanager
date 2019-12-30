package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    //根据用户名查询用户对象
    @Select("select * from user where uname = #{uname}")
    public User findByuname(@Param("uname") String uname);

    //注册
    @Insert(" insert into user(uname,password,name,sex,email,phone,birthday,status,code)  " +
            " values (#{uname},#{password},#{name},#{sex},#{email},#{phone},#{birthday},#{status},#{code})")
    public void save(User user);

    //根据激活码查询用户对象
    @Select("select * from user where code = #{code}")
    User findByCode(String code);

    //修改指定用户激活状态
    @Update(" update user set status = 'Y' where uid=#{uid}")
    void updateStatus(User user);

    //根据账号密码查询用户
    @Select("select * from user where uname=#{username} and password=#{password}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //修改个人信息
    @Update("UPDATE user SET name=#{name},sex=#{sex},area=#{area},address=#{address},coding=#{coding}" +
            " , identity=#{identity},phone=#{phone} WHERE uname = #{uname} " )
    int updateUser(User user);

    //修改密码
    @Update("update user set password=#{password} where uname=#{uname} ")
    int updatePassword(@Param("uname") String uname,@Param("password") String password);
}
