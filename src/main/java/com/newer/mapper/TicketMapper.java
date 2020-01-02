package com.newer.mapper;

import com.newer.domain.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface TicketMapper {

    /**
     * 根据演唱会ID查找票务信息
     * @param id
     * @return
     */
    @Select("select * from ticket where c_id=#{cId}")
    List<Ticket> findTicketBycId(@Param("cId") int id);

    @Select("select * from ticket where t_id=#{tId}")
    Ticket findTicketBytId(@Param("tId") int id);
}
