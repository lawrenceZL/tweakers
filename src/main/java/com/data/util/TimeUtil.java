package com.data.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Date dateToStamp(String s) throws Exception {
        String res;//设置时间格式，将该时间格式的时间转换为时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
//        long time = date.getTime();
//        res = String.valueOf(time);
        return date;
    }

    //获取几小时前的时间
    public static Date getnhTime(int num) {
        long time = new Date().getTime();
        long newTime = time - num*1000*60*60;
        return new Date(newTime);
    }
}
