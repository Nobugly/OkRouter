package com.github.richyeoh.okrouter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void doClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("ok", "age = 18");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
