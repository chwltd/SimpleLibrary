package com.chwltd.simplelibrary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chwltd.api.ApiConfig;
import com.chwltd.api.ApiUtils;
import com.chwltd.api.AppConfig;
import com.chwltd.utils.SystemUtils;
import com.chwltd.view.statuslayout.SimpleStatusLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ApiConfig.setAppid("4");
        ApiConfig.setKey("Y2bbiZcIsCop7oaO");
        ApiConfig.setAdmin("http://zjapp.cxovo.cn");
        ApiConfig.setDevice(SystemUtils.getAndroidId(this));
        ApiConfig.setUserToken("");

        AppConfig.setTheme(true,"#2196F3","#666666");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        SystemUtils.changeStatusBarTextColor(this,true);
        SimpleStatusLayout statusLayout = findViewById(R.id.statusLayout);
        SimpleStatusLayout statusLayout1 = new SimpleStatusLayout(getApplicationContext());
        System.out.println(statusLayout1);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            //statusLayout.showLoading(true);
            //statusLayout.showEmpty();
            statusLayout.showError();
        });

        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(v -> {
            SystemUtils.CHToast(MainActivity.this,ApiUtils.getEmailVerificationCode("1504364233@qq.com",1));
        });
        EditText editText = findViewById(R.id.et);
        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(v -> {
            String s = editText.getText().toString();
            SystemUtils.CHToast(MainActivity.this,ApiUtils.register("test111","123456","1504364233@qq.com",s,"",0));
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
            public void onHideEvent() {
                SystemUtils.CHToast(MainActivity.this,"关闭了");
            }
        });
    }
}