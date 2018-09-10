package com.github.richyeoh.okrouter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view) {
        Disposable subscribe = OkRouter.of(this)
                .with("name", "richyeoh")
                .routeByTargetClass(SecondActivity.class)
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        Log.e("accept", "" + result.getData());
                        Toast.makeText(getApplicationContext(), "result=" + result.getResultCode() + "resultData" + result.getData(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
