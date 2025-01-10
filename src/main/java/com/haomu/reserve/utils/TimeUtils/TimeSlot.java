package com.haomu.reserve.utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSlot {
    private final String startTime;
    private final String endTime;

    public TimeSlot(String startTime, String endTime) {

        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
