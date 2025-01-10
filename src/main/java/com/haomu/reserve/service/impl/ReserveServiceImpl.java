package com.haomu.reserve.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.haomu.reserve.dao.ReserveMapper;
import com.haomu.reserve.module.Reserve;
import com.haomu.reserve.service.IReserveService;
import com.haomu.reserve.utils.TimeUtils.TimeSlot;
import com.haomu.reserve.utils.TimeUtils.TimeUtils;
import com.haomu.reserve.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReserveServiceImpl implements IReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    private static final String DATE_PATTERN = "MM月dd日";
    private static final String TIME_PATTERN = "HH:mm";
    private static final String RESERVE_DAY_PATTERN = "yyyy-MM-dd";
    private static final String RESERVE_TIME_PATTERN = "HH:mm:ss";
    private static final String RESERVE_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Result<String> saveReserve(Reserve reserve) {
        int res = reserveMapper.insert(reserve);
        if (res > 0) {
            return Result.success("reserve 保存成功");
        } else {
            return Result.error("reserve 保存失败");
        }
    }

    @Override
    public Result<Object> getReserveList(String start, String end, String step) {
        int[] startArray = TimeUtils.getIntTimeArray(start);
        int[] endArray = TimeUtils.getIntTimeArray(end);
        int[] stepArray = TimeUtils.getIntTimeArray(step);

        DateTimeFormatter reserveDayForm = DateTimeFormatter.ofPattern(RESERVE_DAY_PATTERN);
        DateTimeFormatter reserveTimeForm = DateTimeFormatter.ofPattern(RESERVE_TIME_PATTERN);
        DateTimeFormatter reserveDateTimeForm = DateTimeFormatter.ofPattern(RESERVE_DATETIME_PATTERN);

        LocalTime startTime = LocalTime.of(startArray[0], startArray[1]);
        LocalTime endTime = LocalTime.of(endArray[0], endArray[1]);

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(5);


        List<Reserve> reserveList = reserveMapper.getReservedList(
                startDate.format(reserveDayForm),
                endDate.format(reserveDayForm)
        );
        Duration duration = Duration
                .ofHours(stepArray[0])
                .plusMinutes(stepArray[1]);

        List<Object> allReserveList = new ArrayList<>();
        LocalDate date = startDate;
        Integer reserveListIndex = 0;

        if(reserveList.isEmpty()){
            return Result.success(allReserveList);
        }

        for (int i = 0; i < 5; i++) {
            LocalTime oneDayTime = startTime;
            while (oneDayTime.isBefore(endTime)) {
                if(reserveListIndex >= reserveList.size()){
                    break;
                }
                String startDateFormat = date.format(reserveDayForm) + " " + oneDayTime.format(reserveTimeForm);
                String endDateFormat = date.format(reserveDayForm) +
                        " " +oneDayTime.plus(duration).format(reserveTimeForm);
                TimeSlot currentTimeSlot = new TimeSlot(startDateFormat, endDateFormat);
                TimeSlot reserveTimeSlot = new TimeSlot(
                        reserveList.get(reserveListIndex).getStartTime(),
                        reserveList.get(reserveListIndex).getEndTime()
                );
                if (TimeUtils.isOverlapping(reserveTimeSlot, currentTimeSlot)) {
                    allReserveList.add(startDateFormat);
                    reserveListIndex++;
                }
                oneDayTime = oneDayTime.plus(duration);
            }
            date = date.plusDays(1);
        }

        return Result.success(allReserveList);
    }

    @Override
    public Result<Object> getReservedDay(String year, String month) {
        List<String> ReservedDays =  reserveMapper.selectReservedDaysByYearWithMonth(
                year, month
        );

        List<JSONObject> res = new ArrayList<>();
        for (String ReservedDay : ReservedDays) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("date",ReservedDay);
            res.add(jsonObject);
        }
        return Result.success(res);
    }

    @Override
    public Result<Object> getReserveByDay(String date) {
        List<Reserve> ReserveList = reserveMapper.selectReserveByDay(date);
        List<JSONObject> res = new ArrayList<>();
        for (Reserve reserve : ReserveList) {
            res.add(reserve.toJson());
        }
        return Result.success(res);
    }
}
