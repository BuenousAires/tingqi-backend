package com.haomu.reserve.service;

import com.haomu.reserve.module.Reserve;
import com.haomu.reserve.utils.result.Result;

public interface IReserveService {
    Result<String> saveReserve(Reserve reserve);

    Result<Object> getReserveList(String start, String end, String step);

    Result<Object> getReservedDay(String year, String month);

    Result<Object> getReserveByDay(String date);
}
