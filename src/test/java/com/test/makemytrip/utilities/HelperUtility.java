package com.test.makemytrip.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperUtility {

    public static void doWait(long miliseconds) throws InterruptedException{
        Thread.sleep(miliseconds);
    }
    public static  String  getPlusDateFromNow(int numberOfDays){

        Date todayDate=new Date();
        Date tomorrowDate=new Date(todayDate.getTime() + (1000 * 60 * 60 * 24*numberOfDays));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd MMMM yyyy");
        String currentDate=simpleDateFormat.format(tomorrowDate);
        return  currentDate.trim();


    }



}
