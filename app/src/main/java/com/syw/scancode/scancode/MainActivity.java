package com.syw.scancode.scancode;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SCAN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scan(View view) {
        startActivityForResult(new Intent(this, CaptureActivity.class), SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (SCAN == 1000 && data != null) {
            String result = data.getStringExtra("result");
            TextView content=findViewById(R.id.content);
            content.setText(result);
        }
    }
}
