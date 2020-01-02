package com.newer.mapper;

import com.newer.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {


    List<Book> findAll(int uid);

    @Insert("insert into book (b_time,bk_id,b_num,b_total,c_id,u_id,state) values " +
            " ( now(),#{tid},#{num},#{total},#{cid},#{uid},1)")
    int addBook(@Param("tid") int tid,@Param("num") int num,@Param("total") int total,@Param("cid") int cid,@Param("uid") int uid);
}
