package com.github.richyeoh.okrouter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import io.reactivex.Maybe;

public class RouterImpl implements Router {
    @Override
    public Maybe<Result> route(FragmentActivity activity, TransferParameters parameters) {
        return null;
    }

    @Override
    public Maybe<Result> route(Fragment fragment, TransferParameters parameters) {
        return null;
    }

    @Override
    public Maybe<Result> route(Context context, TransferParameters parameters) {
        return null;
    }
}
