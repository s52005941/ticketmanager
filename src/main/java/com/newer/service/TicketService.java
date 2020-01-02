package com.newer.service;

import com.newer.domain.Ticket;
import com.newer.mapper.TicketMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class TicketService {
    private TicketMapper ticketMapper;
    private SqlSession sqlSession;

    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession();
        ticketMapper = sqlSession.getMapper(TicketMapper.class);
    }

    public List<Ticket> findTicketByCid(int id){
        init();
        List<Ticket> tickets = ticketMapper.findTicketBycId(id);
        SqlSessionUtil.close(sqlSession);
        return tickets;
    }

    public Ticket findTicketBytId(int id){
        init();
        Ticket tic = ticketMapper.findTicketBytId(id);
        SqlSessionUtil.close(sqlSession);
        return tic;
    }


}
