package com.haomu.reserve.utils.TimeUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    public static int[] getIntTimeArray(String time){
        String[] timeArray = time.split(":");
        int[] intTimeArray = new int[timeArray.length];
        for (int i = 0; i < timeArray.length; i++) {
            intTimeArray[i] = Integer.parseInt(timeArray[i]);
        }
        return intTimeArray;
    }

    public static boolean isOverlapping(TimeSlot t1, TimeSlot t2){
        LocalDateTime t1Start = LocalDateTime.parse(t1.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime t1End = LocalDateTime.parse(t1.getEndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime t2Start = LocalDateTime.parse(t2.getStartTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime t2End = LocalDateTime.parse(t2.getEndTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        ZonedDateTime t1StartZoneDateTime = t1Start.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime t1EndZoneDateTime = t1End.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime t2StartZoneDateTime = t2Start.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime t2EndZoneDateTime = t2End.atZone(ZoneId.of("Asia/Shanghai"));

        Instant t1StartInstant = t1StartZoneDateTime.toInstant();
        Instant t1EndInstant = t1EndZoneDateTime.toInstant();
        Instant t2StartInstant = t2StartZoneDateTime.toInstant();
        Instant t2EndInstant = t2EndZoneDateTime.toInstant();

        long t1StartMillis = t1StartInstant.getEpochSecond();
        long t1EndMillis = t1EndInstant.getEpochSecond();
        long t2StartMillis = t2StartInstant.getEpochSecond();
        long t2EndMillis = t2EndInstant.getEpochSecond();
        return t1StartMillis < t2EndMillis && t1EndMillis > t2StartMillis;
    }
}
