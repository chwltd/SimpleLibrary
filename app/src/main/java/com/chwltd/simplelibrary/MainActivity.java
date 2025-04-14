package com.chwltd.simplelibrary;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.chwltd.utils.SystemUtils;
import com.chwltd.view.statuslayout.SimpleStatusLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        SystemUtils.changeStatusBarTextColor(this,true);
        SimpleStatusLayout statusLayout = findViewById(R.id.statusLayout);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            statusLayout.showLoading(true);
            statusLayout.listener.onStartLoadEvent();
        });

        statusLayout.setSimpleStatusListener(new SimpleStatusLayout.SimpleStatusListener() {
            @Override
            public void onStartLoadEvent() {
                SystemUtils.CHToast(MainActivity.this,"加载中...");
            }

            @Override
            public void onHide() {
            }
        });
    }
}