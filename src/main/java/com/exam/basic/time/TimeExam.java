package com.exam.basic.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeExam {
    public static void main(String[] args) {
        TimeExam te = new TimeExam();
        te.timeEx1();
        // String[] arr = new String[]{"AM 10:10:10", "PM 10:10:10", "AM 00:00:01" , "PM 00:00:01"};
        // int[] num = new int[]{500, 300, 10, 200};

        // int idx = 0;
        
        // for(String str : arr){
        //     String result = te.to24H(str);
        //     result = te.plusSecond(result, num[idx++]);
        //     System.out.println("result : " + result);
        // }
    }

    public void timeEx1(){
        String date_pattern = "yyyy:MM:dd";

        LocalDate today = LocalDate.now();
        System.out.println("현재 시간 : " + today);
        System.out.println("getYear() : " + today.getYear());
        System.out.println("getMonth() : " + today.getMonth());
        System.out.println("getMonthValue() : " + today.getMonthValue());
        System.out.println("getDayOfYear() : " + today.getDayOfYear());
        System.out.println("getDayOfMonth(): " + today.getDayOfMonth());

        System.out.println();
        System.out.println("=========================");
        System.out.println("plus date()");
        System.out.println("getYear() + 70 : " + (today.getYear() + 70));
        System.out.println("plusYears(70) : " + today.plusYears(70).format(DateTimeFormatter.ofPattern(date_pattern)));
        System.out.println("getMonthValue() + 70 : " + (today.getMonthValue() + 70));
        System.out.println("plusMonths(70) : " + today.plusMonths(70).format(DateTimeFormatter.ofPattern(date_pattern)));
        System.out.println("getDayOfMonth() + 70 : " + (today.getDayOfMonth() + 70));
        System.out.println("plusDays(70) : " + today.plusDays(70).format(DateTimeFormatter.ofPattern(date_pattern)));


        String pattern = "HH:mm:ss";
        System.out.println();
        System.out.println("LocalDateTime");
        System.out.println("=========================");
        
        System.out.println("LocalDateTime.now() : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)));

        LocalDateTime localDateTime = LocalDateTime.now();

        //date는 위와 같음
        System.out.println("getHour() : " + localDateTime.getHour());
        System.out.println("getMinute() : " + localDateTime.getMinute());
        System.out.println("getSecond() : " + localDateTime.getSecond());

        System.out.println();
        System.out.println("=========================");
        System.out.println("plus time()");
        System.out.println("getHour() + 70 : " + (localDateTime.getHour() + 70));
        System.out.println("plusHours(70) : " + localDateTime.plusHours(70).format(DateTimeFormatter.ofPattern(pattern)));
        System.out.println("getMinute() + 70 : " + (localDateTime.getMinute() + 70));
        System.out.println("plusMinutes(70) : " + localDateTime.plusMinutes(70).format(DateTimeFormatter.ofPattern(pattern)));
        System.out.println("getSecond() + 60 : " + (localDateTime.getSecond() + 60));
        System.out.println("plusSeconds(100) : " + localDateTime.plusSeconds(100).format(DateTimeFormatter.ofPattern(pattern)));

        LocalDateTime customDateTime = LocalDateTime.now().withHour(10).withMinute(10).withSecond(10);
        
        System.out.println();
        System.out.println("customdate");
        System.out.println("=========================");
        System.out.println("customdate :: " + customDateTime.getHour() + ":" + customDateTime.getMinute() + ":" + customDateTime.getSecond());
    }

    // AP, PM 구분없이 24시간 타임으로 변경하기
    // ex) "AM 10:10:10", "PM 10:10:10", "AM 00:00:01" , "PM 12:00:01"....
    public String to24H(String time){
        String replace_time = time.replace("AM", "오전").replace("PM", "오후");

        String result = LocalTime.parse(replace_time, DateTimeFormatter.ofPattern("a hh:mm:ss")).toString();

        return result;
    }

    public String plusSecond(String time, int second){
        String result = LocalTime.parse(time).plusSeconds(second).format(DateTimeFormatter.ofPattern("hh:mm:ss"));

        return result;
    }
}
