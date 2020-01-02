package com.newer.service;

import com.newer.domain.Book;
import com.newer.mapper.BookMapper;
import com.newer.mapper.TicketMapper;
import com.newer.mapper.UserMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookService {
    private SqlSession sqlSession;
    private BookMapper bookMapper;
    private TicketMapper ticketMapper;


    private void init() {
        sqlSession = SqlSessionUtil.getSqlSession();
        bookMapper = sqlSession.getMapper(BookMapper.class);
        ticketMapper = sqlSession.getMapper(TicketMapper.class);
    }

    public List<Book> findAll(int uid){
        init();
        List<Book> list = bookMapper.findAll(uid);
        SqlSessionUtil.close(sqlSession);
        return list;
    }


    public int addBook( int tid, int num, int total, int cid, int uid){
        init();
        int i = bookMapper.addBook(tid, num, total, cid, uid);

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return i;
    }

}
