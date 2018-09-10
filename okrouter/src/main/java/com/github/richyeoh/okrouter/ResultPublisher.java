package com.github.richyeoh.okrouter;

import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

public class ResultPublisher {
    private FlowableProcessor<Result> mResultPublishProcessor = PublishProcessor.create();

    public void onSuccess(Result result) {
        mResultPublishProcessor.onNext(result);
        mResultPublishProcessor.onComplete();
    }

    public FlowableProcessor<Result> get() {
        return mResultPublishProcessor;
    }
}
