package com.github.richyeoh.okrouter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import io.reactivex.Maybe;

public interface Router {
    Maybe<Result> route(FragmentActivity activity);

    Maybe<Result> route(Fragment fragment);

    Maybe<Result> route(Context context);
}
