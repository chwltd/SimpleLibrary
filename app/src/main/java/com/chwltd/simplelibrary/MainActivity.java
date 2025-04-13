package com.chwltd.simplelibrary;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.chwltd.function.toast.SimpleToast;
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
        statusLayout.showLoading(true);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            statusLayout.showLoading(true);
        });
    }
}