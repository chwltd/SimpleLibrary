package com.chwltd.simplelibrary;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.chwltd.api.AppConfig;
import com.chwltd.utils.SystemUtils;
import com.chwltd.view.statuslayout.SimpleStatusLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppConfig.setTheme(true,"#2196F3","#666666");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        SystemUtils.changeStatusBarTextColor(this,true);
        SimpleStatusLayout statusLayout = findViewById(R.id.statusLayout);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            //statusLayout.showLoading(true);
            //statusLayout.showEmpty();
            statusLayout.showError();
        });
        statusLayout.setSimpleStatusListener(new SimpleStatusLayout.SimpleStatusListener() {
            @Override
            public void onStartEvent(String eventName) {
                if(eventName.equals("showLoading")){
                    SystemUtils.CHToast(MainActivity.this,"开始加载了");
                }else if(eventName.equals("showEmpty")){
                    SystemUtils.CHToast(MainActivity.this,"显示了空布局");
                }
            }

            @Override
            public void onHide() {
                SystemUtils.CHToast(MainActivity.this,"关闭了");
            }
        });
    }
}