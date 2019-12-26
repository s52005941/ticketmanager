package com.newer.mapper;

import com.newer.domain.Concert;

import java.util.List;

public interface ConcertMapper {
    List<Concert> findConcertAll();
}
