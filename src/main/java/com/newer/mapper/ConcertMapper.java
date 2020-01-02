package com.newer.mapper;

import com.newer.domain.Concert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConcertMapper {

    /**
     * 查询所有演唱会信息
     * @return
     */
    @Select("select * from concert")
    List<Concert> findConcertAll();

    /**
     * 根据ID查找演唱会信息
     * @param id
     * @return
     */
    @Select("select * from concert where c_id=#{cId}")
    Concert findConcertById(@Param("cId") int id);
}
