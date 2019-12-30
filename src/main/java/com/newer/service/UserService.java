package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.MailUtils;
import com.newer.util.SqlSessionUtil;
import com.newer.util.UuidUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    private SqlSession sqlSession;
    private UserMapper userMapper;


    private void init() {
        sqlSession = SqlSessionUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }


    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public boolean regist(User user) {
        init();
        //1.根据用户名查询用户对象是否存在
        User u = userMapper.findByuname(user.getUname());
        //判断u是否为null
        if (u != null){
            //用户名存在  注册失败
            return  false;
        }

        //2.保存用户信息
        //2.1设置激活码
        user.setCode(UuidUtil.getUuid());

        //2.2设置激活状态
        user.setStatus("N");
        userMapper.save(user);
        System.out.println(user.getCode());
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

        //3.发送激活邮件
        String content = "<a href='http://localhost:8080/ticketmanager_war/activeUserServlet?code="+user.getCode()+"'>点击激活[梦田票务]</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }

    /**
     * 激活用户
     * @return
     */
    public boolean active(String code) {
        init();
        //1.根据激活码查询用户对象
        User user = userMapper.findByCode(code);
        if(user != null){
            //2.调用修改激活状态的方法
            userMapper.updateStatus(user);
            sqlSession.commit();
            SqlSessionUtil.close(sqlSession);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user) {
        init();

        return userMapper.findByUsernameAndPassword(user.getUname(),user.getPassword());
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    public int updateUser(User user) {
        int count = 0;
        init();

        count = userMapper.updateUser(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return count;
    }

    /**
     * 修改密码
     * @param uname
     * @param password
     * @return
     */
    public int updatePassword(String uname , String password){
        int count = 0;
        init();
        count = userMapper.updatePassword(uname,password);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);

        return count;
    }
}
