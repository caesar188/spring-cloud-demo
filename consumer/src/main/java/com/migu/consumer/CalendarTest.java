package com.migu.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 * Created by wangxr on 2017/9/30.
 **/
public class CalendarTest {

    /*public static void main(String[] args) throws Exception{
        Date date = stringToDate("2018-07-31");
        System.out.println(dateToString(date));

        // Calendar calendar = new GregorianCalendar();
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(date);
        //calendar.add(calendar.DAY_OF_YEAR, 1);//增加一天,负数为减少一天
        //calendar.add(calendar.DAY_OF_MONTH, 1);//增加一天
        //calendar.add(calendar.DATE,1);//增加一天
        calendar.add(calendar.WEEK_OF_MONTH, 1);//增加一个礼拜
        //calendar.add(calendar.WEEK_OF_YEAR,1);//增加一个礼拜
        calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
        date = calendar.getTime();

        System.out.println(dateToString(date));
    }*/

    /**
     * @param date
     * @return
     * @Author: wangxer
     * @Description:将Date对象转为String 显示
     * @Date: Created in 10:24 on 2017/9/30.
     */
    public static String dateToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static Date stringToDate(String str) throws Exception{
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(str);
    }

}
