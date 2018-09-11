package com.github.richyeoh.okrouter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.lang.Exception;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("CheckResult")
    public void doClick(View view) {
        OkRouter.of(this)
                .with("name", "richyeoh")
                .setFirewall(new LoginFirewall())
                .routeByTargetClass(SecondActivity.class)
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) {
                        Log.e("accept", "" + result.getData());
                        Toast.makeText(getApplicationContext(), "result=" + result.getResultCode() + "resultData" + result.getData(), Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
