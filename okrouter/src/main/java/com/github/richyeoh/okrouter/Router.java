package com.github.richyeoh.okrouter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.List;

import io.reactivex.Maybe;

public interface Router {
    Maybe<Result> route(FragmentActivity activity, TransferParameters parameters);

    Maybe<Result> route(FragmentActivity activity, List<Firewall> firewalls, TransferParameters parameters);

    Maybe<Result> route(Fragment fragment, TransferParameters parameters);

    Maybe<Result> route(Context context, TransferParameters parameters);
}
