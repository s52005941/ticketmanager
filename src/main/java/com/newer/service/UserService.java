package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.SqlSessionUtil;
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
        userMapper.save(user);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return false;
    }
}
