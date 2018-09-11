package com.github.richyeoh.okrouter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class RouterImpl implements Router {
    @Override
    public Maybe<Result> route(@NonNull final FragmentActivity activity, @NonNull final TransferParameters parameters) {
        return Maybe.just(activity).map(new Function<FragmentActivity, ResultPublisher>() {
            @Override
            public ResultPublisher apply(FragmentActivity activity) {
                return createPublisher(parameters);
            }
        }).doOnSuccess(new Consumer<ResultPublisher>() {
            @Override
            public void accept(ResultPublisher resultPublisher) {
                ProxyFragment.route(activity, parameters);
            }
        }).flatMap(new Function<ResultPublisher, MaybeSource<Result>>() {
            @Override
            public MaybeSource<Result> apply(ResultPublisher publisher) {
                return publisher.get().lastElement();
            }
        }).doFinally(new Action() {
            @Override
            public void run() {
                PublishHolder.remove(parameters.magicNumber);
            }
        });
    }

    @Override
    public Maybe<Result> route(final FragmentActivity activity, final List<Firewall> firewalls, final TransferParameters parameters) {
        return Maybe.just(activity)
                .doOnSuccess(new Consumer<FragmentActivity>() {
                    @Override
                    public void accept(FragmentActivity activity) {
                        for (Firewall firewall : firewalls) {
                            if (!firewall.allow()) {
                                throw firewall.thrown();
                            }
                        }
                    }
                }).map(new Function<FragmentActivity, ResultPublisher>() {
                    @Override
                    public ResultPublisher apply(FragmentActivity activity) {
                        return createPublisher(parameters);
                    }
                }).doOnSuccess(new Consumer<ResultPublisher>() {
                    @Override
                    public void accept(ResultPublisher resultPublisher) {
                        ProxyFragment.route(activity, parameters);
                    }
                }).flatMap(new Function<ResultPublisher, MaybeSource<Result>>() {
                    @Override
                    public MaybeSource<Result> apply(ResultPublisher publisher) {
                        return publisher.get().lastElement();
                    }
                }).doFinally(new Action() {
                    @Override
                    public void run() {
                        PublishHolder.remove(parameters.magicNumber);
                    }
                });
    }

    private ResultPublisher createPublisher(TransferParameters parameters) {
        ResultPublisher publisher = new ResultPublisher();
        PublishHolder.put(parameters.magicNumber, publisher);
        return publisher;
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
