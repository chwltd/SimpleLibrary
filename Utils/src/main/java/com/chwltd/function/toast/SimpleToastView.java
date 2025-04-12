package com.chwltd.function.toast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chwltd.api.AppConfig;
import com.chwltd.utils.SystemUtils;

public class SimpleToastView extends LinearLayout {
    private String TAG = "SimpleToastView";
    private String content = "";
    private String imageUrl;
    private int toastRadius = SystemUtils.dp2px(10);
    private int toastPadding = SystemUtils.dp2px(15);
    private int toastColor = Color.parseColor("#cc666666");
    private int textColor = Color.parseColor("#ffffff");
    private int textSize = 16;
    private int textMaxLines = 2;
    private Typeface typeface = AppConfig.themeTypeface;
    private int imageSize;

    private TextView textView;

    public SimpleToastView(Context context) {
        super(context);
        init();
    }
    public SimpleToastView(Context context,String content) {
        super(context);
        this.content = content;
        init();
    }

    public SimpleToastView(Context context,String content,@NonNull String toastColor,@NonNull String textColor,int textSize,int textMaxLines,int toastRadius,int toastPadding,@NonNull Typeface typeface) {
        super(context);
        if(toastColor != null) this.toastColor = Color.parseColor(toastColor);
        if(textColor!= null) this.textColor = Color.parseColor(textColor);
        if(textSize!= 0) this.textSize = textSize;
        if(textMaxLines!= 0) this.textMaxLines = textMaxLines;
        if(toastRadius!= 0) this.toastRadius = SystemUtils.dp2px(toastRadius);
        if(toastPadding!= 0) this.toastPadding = SystemUtils.dp2px(toastPadding);
        if(typeface!= null) this.typeface = typeface;
        this.content = content;
        init();
    }

    private void init() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setPadding(toastPadding,toastPadding,toastPadding,toastPadding);
        textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        addView(textView);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(toastColor);
        gradientDrawable.setCornerRadius(toastRadius);
        setBackground(gradientDrawable);
        initToastView();
    }

    public void initToastView() {
        textView.setText(content);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);
        textView.setTypeface(typeface);
        textView.setMaxLines(textMaxLines);
    }

    public void setContent(String content) {
        this.content = content;
        initToastView();
    }
    public void setTextColor(int textColor) {
        this.textColor = textColor;
        initToastView();
    }

    public void setTextColor(String textColor) {
        this.textColor = Color.parseColor(textColor);
        initToastView();
    }

    public void setToastColor(int toastColor) {
        this.toastColor = toastColor;
        initToastView();
    }

    public void setToastColor(String toastColor) {
        this.toastColor = Color.parseColor(toastColor);
        initToastView();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        initToastView();
    }

    public void setTextMaxLines(int textMaxLines) {
        this.textMaxLines = textMaxLines;
        initToastView();
    }

    public void setToastRadius(int toastRadius) {
        this.toastRadius = SystemUtils.dp2px(toastRadius);
        initToastView();
    }

    public void setToastPadding(int toastPadding) {
        this.toastPadding = SystemUtils.dp2px(toastPadding);
        initToastView();
    }
}
