package com.chwltd.view.statuslayout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.chwltd.api.AppConfig;
import com.chwltd.utils.ImageUtils;
import com.chwltd.utils.SystemUtils;

public class SimpleStatusLayout extends LinearLayout {
    //底部内边距
    private int bottomPadding = 0;
    //顶部内边距
    private int topPadding = 0;
    //状态布局监听
    public SimpleStatusListener listener;
    //状态布局根布局
    private RelativeLayout statusRootView;
    //加载中布局
    private LinearLayout loadingView;
    private ImageView loadingImageView;
    private TextView loadingTextView;
    private String loadingLottie = AppConfig.themeLoadingLottie;
    //空布局
    private LinearLayout emptyView;
    private ImageView emptyImageView;
    private TextView emptyTextView;
    private String emptyLottie = AppConfig.themeEmptyLottie;
    //错误布局
    private LinearLayout errorView;
    private ImageView errorImageView;
    private TextView errorTextView;
    private String errorLottie = AppConfig.themeErrorLottie;
    //网络错误布局
    private LinearLayout networkErrorView;
    private ImageView networkErrorImageView;
    private TextView networkErrorTextView;
    private String networkErrorLottie = AppConfig.themeNetworkErrorLottie;
    //无权限布局
    private LinearLayout noPermissionView;
    private ImageView noPermissionImageView;
    private TextView noPermissionTextView;
    private String noPermissionLottie = AppConfig.themeNoPermissionLottie;
    //无数据布局
    private LinearLayout noDataView;
    private ImageView noDataImageView;
    private TextView noDataTextView;
    //自定义布局
    private LinearLayout customView;
    //当前显示的布局
    private LinearLayout currentView;
    //屏幕数据
    private int screenWidth;
    private int screenHeight;

    public SimpleStatusLayout(Context context) {
        super(context);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public SimpleStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //获取屏幕数据
        screenWidth = SystemUtils.getScreenWidth(getContext());
        screenHeight = SystemUtils.getScreenHeight(getContext());
        //初始化布局
        statusRootView = new RelativeLayout(getContext());
        loadingView = new LinearLayout(getContext());
        emptyView = new LinearLayout(getContext());
        errorView = new LinearLayout(getContext());
        networkErrorView = new LinearLayout(getContext());
        noPermissionView = new LinearLayout(getContext());
        noDataView = new LinearLayout(getContext());
        customView = new LinearLayout(getContext());
        //设置布局参数
        statusRootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        loadingView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        emptyView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        errorView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        networkErrorView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        noPermissionView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        noDataView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        customView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //设置布局可视度
        statusRootView.setVisibility(GONE);
        loadingView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
        errorView.setVisibility(GONE);
        networkErrorView.setVisibility(GONE);
        noPermissionView.setVisibility(GONE);
        noDataView.setVisibility(GONE);
        customView.setVisibility(GONE);
        //添加布局
        statusRootView.addView(loadingView);
        statusRootView.addView(emptyView);
        statusRootView.addView(errorView);
        statusRootView.addView(networkErrorView);
        statusRootView.addView(noPermissionView);
        statusRootView.addView(noDataView);
        statusRootView.addView(customView);
        //设置背景颜色
        statusRootView.setBackgroundColor(Color.parseColor(AppConfig.themeBgColor));
        addView(statusRootView);
        //初始化子布局
        initSubView();
        statusRootView.setPadding(0, topPadding,0, bottomPadding);
        setSimpleStatusListener(new SimpleStatusListener() {
            @Override
            public void onStartEvent(String eventName) {

            }

            @Override
            public void onHide() {

            }
        });
    }

    public void initPadding() {
        statusRootView.setPadding(0, topPadding,0, bottomPadding);
    }

    private void initSubView(){
        //初始化加载中布局
        initLoadingView();
        //初始化空布局
        initEmptyView();
        //初始化错误布局
        initErrorView();
        //初始化网络错误布局
        initNetworkErrorView();
    }

    //初始化加载中布局
    private void initLoadingView() {
        loadingView.setOrientation(VERTICAL);
        loadingView.setGravity(Gravity.CENTER);
        //初始化布局
        loadingImageView = new ImageView(getContext());
        loadingTextView = new TextView(getContext());
        loadingView.addView(loadingImageView);
        loadingView.addView(loadingTextView);
        //设置布局参数
        loadingImageView.setLayoutParams(new LayoutParams(screenWidth/3, ViewGroup.LayoutParams.WRAP_CONTENT));
        loadingTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        //加载动画
        ImageUtils.playLottie(loadingImageView,loadingLottie);
    }

    //初始化空布局
    private void initEmptyView() {
        emptyView.setOrientation(VERTICAL);
        emptyView.setGravity(Gravity.CENTER);
        //初始化布局
        emptyImageView = new ImageView(getContext());
        emptyTextView = new TextView(getContext());
        emptyTextView.setText("空空如也");
        emptyTextView.setTextSize(14);
        emptyTextView.setTextColor(Color.parseColor(AppConfig.themeContentColor));
        emptyTextView.setMaxLines(1);
        emptyTextView.setEllipsize(TextUtils.TruncateAt.END);
        emptyTextView.setTypeface(AppConfig.themeTypeface);
        emptyView.addView(emptyImageView);
        emptyView.addView(emptyTextView);
        //设置布局参数
        emptyImageView.setLayoutParams(new LayoutParams(screenWidth/3, ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int margin = SystemUtils.dp2px(5);
        params.setMargins(margin, margin, margin, margin);
        emptyTextView.setLayoutParams(params);
        //加载动画
        ImageUtils.playLottie(emptyImageView,emptyLottie);
    }

    //初始化错误布局
    private void initErrorView() {
        errorView.setOrientation(VERTICAL);
        errorView.setGravity(Gravity.CENTER);
        //初始化布局
        errorImageView = new ImageView(getContext());
        errorTextView = new TextView(getContext());
        errorTextView.setText("加载失败，点击重新加载");
        errorTextView.setTextSize(14);
        errorTextView.setTextColor(Color.parseColor(AppConfig.themeContentColor));
        errorTextView.setMaxLines(1);
        errorTextView.setEllipsize(TextUtils.TruncateAt.END);
        errorTextView.setTypeface(AppConfig.themeTypeface);
        errorView.addView(errorImageView);
        errorView.addView(errorTextView);
        //设置布局参数
        errorImageView.setLayoutParams(new LayoutParams(screenWidth/3, screenWidth/3));
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int margin = SystemUtils.dp2px(5);
        params.setMargins(margin, margin, margin, margin);
        errorTextView.setLayoutParams(params);
        //加载动画
        ImageUtils.playLottie(errorImageView,errorLottie);
    }

    //初始化网络错误布局
    private void initNetworkErrorView() {
        networkErrorView.setOrientation(VERTICAL);
        networkErrorView.setGravity(Gravity.CENTER);
        //初始化布局
        networkErrorImageView = new ImageView(getContext());
        networkErrorTextView = new TextView(getContext());
        networkErrorTextView.setText("网络错误，点击重新加载");
        networkErrorTextView.setTextSize(14);
        networkErrorTextView.setTextColor(Color.parseColor(AppConfig.themeContentColor));
        networkErrorTextView.setMaxLines(1);
        networkErrorTextView.setEllipsize(TextUtils.TruncateAt.END);
        networkErrorTextView.setTypeface(AppConfig.themeTypeface);
        networkErrorView.addView(networkErrorImageView);
        networkErrorView.addView(networkErrorTextView);
        //设置布局参数
        networkErrorImageView.setLayoutParams(new LayoutParams(screenWidth/3, screenWidth/3));
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int margin = SystemUtils.dp2px(5);
        params.setMargins(margin, margin, margin, margin);
        networkErrorTextView.setLayoutParams(params);
        //加载动画
        ImageUtils.playLottie(networkErrorImageView,networkErrorLottie);
    }

    //初始化无权限布局
    private void initNoPermissionView() {
        noPermissionView.setOrientation(VERTICAL);
        noPermissionView.setGravity(Gravity.CENTER);
        //初始化布局
        noPermissionImageView = new ImageView(getContext());
        noPermissionTextView = new TextView(getContext());
        noPermissionTextView.setText("无权限，点击申请权限");
        noPermissionTextView.setTextSize(14);
        noPermissionTextView.setTextColor(Color.parseColor(AppConfig.themeContentColor));
        noPermissionTextView.setMaxLines(1);
        noPermissionTextView.setEllipsize(TextUtils.TruncateAt.END);
        noPermissionTextView.setTypeface(AppConfig.themeTypeface);
        noPermissionView.addView(noPermissionImageView);
        noPermissionView.addView(noPermissionTextView);
        //设置布局参数
        noPermissionImageView.setLayoutParams(new LayoutParams(screenWidth/3, screenWidth/3));
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int margin = SystemUtils.dp2px(5);
        params.setMargins(margin, margin, margin, margin);
        noPermissionTextView.setLayoutParams(params);
        //加载动画
        ImageUtils.playLottie(noPermissionImageView,noPermissionLottie);
    }

    public void showLoading(boolean status) {
        if(currentView != null) {
            currentView.setVisibility(GONE);
        }
        if(status) {
            loadingView.setOnClickListener(view -> {
                hide();
            });
        }
        loadingView.setVisibility(VISIBLE);
        currentView = loadingView;
        showView(statusRootView);
        listener.onStartEvent("showLoading");
    }

    public void showEmpty() {
        if(currentView!= null) {
            currentView.setVisibility(GONE);
        }
        emptyView.setVisibility(VISIBLE);
        currentView = emptyView;
        showView(statusRootView);
        listener.onStartEvent("showEmpty");
    }

    public void showError() {
        if(currentView!= null) {
            currentView.setVisibility(GONE);
        }
        errorView.setOnClickListener(view -> {
            showLoading(false);
        });
        errorView.setVisibility(VISIBLE);
        currentView = errorView;
        showView(statusRootView);
        listener.onStartEvent("showError");
    }

    public void showNetworkError() {
        if(currentView!= null) {
            currentView.setVisibility(GONE);
        }
        networkErrorView.setOnClickListener(view -> {
            showLoading(false);
        });
        networkErrorView.setVisibility(VISIBLE);
        currentView = networkErrorView;
        showView(statusRootView);
        listener.onStartEvent("showNetworkError");
    }

    public void showNoPermission() {
        if(currentView!= null) {
            currentView.setVisibility(GONE);
        }
        noPermissionView.setOnClickListener(view -> {
            listener.onStartEvent("getPermission");
        });
        noPermissionView.setVisibility(VISIBLE);
        currentView = noPermissionView;
        showView(statusRootView);
        listener.onStartEvent("showNoPermission");
    }

    public void hide() {
        hideView();
    }

    private void hideView() {
        currentView.setVisibility(GONE);
        statusRootView.setVisibility(GONE);
        listener.onHide();
    }

    private void showView(ViewGroup view) {
        view.setVisibility(VISIBLE);
    }

    public void setSimpleStatusListener(SimpleStatusListener listener) {
        this.listener = listener;
    }

    public int getTopPadding() {
        return topPadding;
    }

    public void setTopPadding(int topPadding) {
        this.topPadding = topPadding;
        initPadding();
    }

    public void setTopMargin(ViewGroup viewGroup) {
        this.topPadding = viewGroup.getHeight();
        initPadding();
    }

    public void setTopMargin(View view) {
        this.topPadding = view.getHeight();
        initPadding();
    }

    public int getBottomPadding() {
        return bottomPadding;
    }

    public void setBottomPadding(int bottomPadding) {
        this.bottomPadding = bottomPadding;
        initPadding();
    }

    public void setBottomMargin(ViewGroup viewGroup) {
        this.bottomPadding = viewGroup.getHeight();
        initPadding();
    }

    public void setBottomMargin(View view) {
        this.bottomPadding = view.getHeight();
        initPadding();
    }

    public interface SimpleStatusListener {
        void onStartEvent(String eventName);
        void onHide();
    }
}
