package com.chwltd.function.toast;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class SimpleToast {
    private static Toast toast;

    public static void show(Context context,String message) {
        show(context,message,Gravity.CENTER,0,0);
    }

    public static void show(Context context,String message,int gravity) {
        show(context,message,gravity,0,0);
    }

    public static void show(Context context,String message,int gravity,int y,String toastColor) {
        show(context,message,gravity,0,y,getToastView(context,message,toastColor));
    }

    public static void show(Context context,String message,int gravity,int y) {
        show(context,message,gravity,0,y);
    }

    public static void show(Context context,String message,int gravity,int x,int y) {
        show(context,message,gravity,x,y,getToastView(context,message));
    }

    private static void show(Context context,String message,int gravity,int x,int y,View view) {
        if(toast == null) {
            toast = new Toast(context);
        }
        toast.setGravity(gravity, x, y);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private static View getToastView(Context context, String message) {
        return new SimpleToastView(context,message);
    }

    private static View getToastView(Context context, String message,String toastColor) {
        SimpleToastView view = new SimpleToastView(context,message);
        view.setToastColor(Color.parseColor(toastColor));
        return view;
    }
}
