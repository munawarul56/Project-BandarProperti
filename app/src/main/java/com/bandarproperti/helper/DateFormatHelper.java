package com.bandarproperti.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by arief on 02-Sep-16.
 */
public class DateFormatHelper {

    Locale locale = Locale.getDefault();

    Date dateNow;
    Calendar calendarOneWeekEarlier = Calendar.getInstance();
    Calendar calendarOneDayEarlier = Calendar.getInstance();

    Calendar calendar7DaysEarlier = Calendar.getInstance();
    Calendar calendarThisMonth = Calendar.getInstance();

    SimpleDateFormat dayFormat, dateFormat, timeFormat, dateTimeFormat, dateDefaultFormat, dateMonthFormat, monthFormat;

    public DateFormatHelper(){
        dateNow = new Date();

        calendar7DaysEarlier.add(Calendar.DATE, -7);
        calendarOneWeekEarlier.add(Calendar.DATE, -6);
        calendarOneDayEarlier.add(Calendar.DATE, -1);

        calendarThisMonth.add(Calendar.MONTH, 0);
    }

    //Datetime Format
    public String dateNowDefaultView(){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        return dateFormat.format(dateNow);
    }

    public String dateNowDefaultView(Date date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        return dateFormat.format(date);
    }

    public String dateTimeNowDefaultView(){
        dateNow = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        return dateFormat.format(dateNow);
    }

    public String dateNowLocaleView(){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        return dateFormat.format(dateNow);
    }

    public String dateNowLocaleView(Date date){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        return dateFormat.format(date);
    }

    public String dateNowLocaleView(Calendar date){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        return dateFormat.format(date);
    }

    public String dateDayNowView(){
        dayFormat = new SimpleDateFormat("EEEE", locale);
        dateFormat = new SimpleDateFormat("dd MMMM yyyy", locale);

        return dayFormat.format(dateNow) + ", " + dateFormat.format(dateNow);
    }

    public String dateTimeDayNowView(){
        dayFormat = new SimpleDateFormat("EEEE", locale);
        dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:ss", locale);

        return dayFormat.format(dateNow) + ", " + dateFormat.format(dateNow);
    }

    public String dateTimeNowView(String date){
        dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:ss", locale);

        try{
            dateNow = dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return dateFormat.format(dateNow);
    }

    public String dateOfOneDayEarlier(){
        dateDefaultFormat = new SimpleDateFormat("yyyy-MM-dd", locale);

        return dateDefaultFormat.format(calendarOneDayEarlier.getTime());
    }

    public String dateOfOneDayEarlierView(){
        dateDefaultFormat = new SimpleDateFormat("dd-MM-yyyy", locale);

        return dateDefaultFormat.format(calendarOneDayEarlier.getTime());
    }

    public String dateOfOneWeekEarlier(){
        dateDefaultFormat = new SimpleDateFormat("yyyy-MM-dd", locale);

        return dateDefaultFormat.format(calendarOneWeekEarlier.getTime());
    }

    public String dateOfOneWeekEarlierView(){
        dateDefaultFormat = new SimpleDateFormat("dd-MM-yyyy", locale);

        return dateDefaultFormat.format(calendarOneWeekEarlier.getTime());
    }

    //Datetime Parse
    public String dateTimeParser(String date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        timeFormat = new SimpleDateFormat("HH:mm", locale);

        try{
            dateNow = dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return timeFormat.format(dateNow);
    }

    public String dateDefaultParser(String date){
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        dateDefaultFormat = new SimpleDateFormat("yyyy-MM-dd", locale);

        try{
           dateNow = dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return dateDefaultFormat.format(dateNow);
    }

    public String dateDefaultParser(Long date){
        dateDefaultFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        dateNow = new Date(date);

        return dateDefaultFormat.format(dateNow);
    }

    public String dateDefault1Parser(Long date){
        dateDefaultFormat = new SimpleDateFormat("dd-MM-yyyy", locale);
        dateNow = new Date(date);

        return dateDefaultFormat.format(dateNow);
    }

    public String dateMonthParser(String date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        dateMonthFormat = new SimpleDateFormat("dd/MMM", locale);

        try{
            dateNow = dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return dateMonthFormat.format(dateNow);
    }

    public String dateYearParser(String date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        dateMonthFormat = new SimpleDateFormat("dd/MMM/yyyy", locale);

        try{
            dateNow = dateFormat.parse(date);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return dateMonthFormat.format(dateNow);
    }

    public String dateTimeDayNowViewParser(String date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", locale);
        dayFormat = new SimpleDateFormat("EEEE", locale);
        dateTimeFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", locale);

        try {
            dateNow = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dayFormat.format(dateNow) + ", " + dateTimeFormat.format(dateNow);
    }

    public String dateTimeNowViewParser(String date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        dateTimeFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", locale);

        try {
            dateNow = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateTimeFormat.format(dateNow);
    }

    //Data Settings
    public String dataSettingTodayView(){
        dayFormat = new SimpleDateFormat("EEEE", locale);
        dateFormat = new SimpleDateFormat("dd MMM", locale);

        return dayFormat.format(dateNow) + ", " + dateFormat.format(dateNow);
    }

    public String dataSettingYesterdayView(){
        dayFormat = new SimpleDateFormat("EEEE", locale);
        dateFormat = new SimpleDateFormat("dd MMM", locale);

        return dayFormat.format(calendarOneDayEarlier.getTime()) + ", " + dateFormat.format(calendarOneDayEarlier.getTime());
    }

    public String dataSettingLast7DaysView(){
        dateFormat = new SimpleDateFormat("dd MMM", locale);

        return dateFormat.format(calendar7DaysEarlier.getTime()) + " - " + dateFormat.format(calendarOneDayEarlier.getTime());
    }

    public String dataSettingThisWeekView() {
        dateFormat = new SimpleDateFormat("dd MMM", locale);

        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, +i - 6);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();

        return dateFormat.format(start) + " - " + dateFormat.format(end);
    }

    public String dataSettingLastWeekView() {
        dateFormat = new SimpleDateFormat("dd MMM", locale);

        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();

        return dateFormat.format(start) + " - " + dateFormat.format(end);
    }

    public String monthDefaultView(){
        monthFormat = new SimpleDateFormat("MM", locale);

        return monthFormat.format(calendarThisMonth.getTime());
    }

    public String monthView(){
        monthFormat = new SimpleDateFormat("MMM", locale);

        return monthFormat.format(calendarThisMonth.getTime());
    }

    public String monthYearView(){
        monthFormat = new SimpleDateFormat("MMM yyyy", locale);

        return monthFormat.format(calendarThisMonth.getTime());
    }
}
