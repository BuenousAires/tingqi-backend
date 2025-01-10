package com.haomu.reserve.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haomu.reserve.module.Reserve;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

@Mapper
public interface ReserveMapper extends BaseMapper<Reserve> {
    List<String> selectReservedDaysByYearWithMonth(
            @Param("year") String year,
            @Param("month") String month
    );

    List<Reserve> selectReserveByDay(@Param("date") String date);

    List<Reserve> getReservedList(
            @Param("start") String start,
            @Param("end") String end
    );
}
