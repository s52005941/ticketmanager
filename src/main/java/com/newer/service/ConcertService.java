package com.newer.service;

import com.newer.domain.Concert;
import com.newer.mapper.ConcertMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ConcertService {
    private ConcertMapper concertMapper;
    private SqlSession sqlSession;

    public void init(){
        sqlSession = SqlSessionUtil.getSqlSession();
        concertMapper = sqlSession.getMapper(ConcertMapper.class);
    }

    public List<Concert> findConcertAll(){
        init();
        List<Concert> concerts = concertMapper.findConcertAll();
        SqlSessionUtil.close(sqlSession);
        return concerts;
    }

    public Concert findConcertById(int id){
        init();
        Concert concert = concertMapper.findConcertById(id);
        SqlSessionUtil.close(sqlSession);
        return concert;
    }
}
