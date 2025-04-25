package com.chwltd.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    public static boolean saveData(Context context, String name, String key, String value) {
        // 存储
        SharedPreferences prefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getValue(Context context,String name, String key) {
        //读取
        SharedPreferences prefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    public static boolean removeKey(Context context,String name, String key) {
        // 清除
        SharedPreferences prefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        return editor.commit();
    }

    /**
     * 处理时间
     * @param inputTime 输入时间
     * @return 处理后的时间
     */
    @SuppressLint("SimpleDateFormat")
    public static String processTime(String inputTime) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = inputFormat.parse(inputTime);

            SimpleDateFormat outputFormat;
            String output;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(new Date());

            if (calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_YEAR) == currentCalendar.get(Calendar.DAY_OF_YEAR)) {
                outputFormat = new SimpleDateFormat("HH:mm");
                output = outputFormat.format(date);
            } else if (calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR) &&
                    calendar.get(Calendar.DAY_OF_YEAR) == currentCalendar.get(Calendar.DAY_OF_YEAR) - 1) {
                outputFormat = new SimpleDateFormat("昨天 HH:mm");
                output = outputFormat.format(date);
            } else if (calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR) &&
                    currentCalendar.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) <= 7) {
                outputFormat = new SimpleDateFormat("EEEE");
                output = outputFormat.format(date);
            } else if (calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)) {
                outputFormat = new SimpleDateFormat("MM/dd");
                output = outputFormat.format(date);
            } else {
                outputFormat = new SimpleDateFormat("yyyy/MM/dd");
                output = outputFormat.format(date);
            }

            return output;
        } catch (ParseException e) {
            e.printStackTrace();
            return inputTime;
        }
    }



    public static boolean isJson(String jsonString) {
        try (JsonReader jsonReader = new JsonReader(new StringReader(jsonString))) {
            JsonToken token = jsonReader.peek();
            return token != JsonToken.END_DOCUMENT;
        } catch (Exception e) {
            return false;
        }
    }
}
