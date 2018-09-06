package com.github.richyeoh.okrouter;

import android.content.Intent;

public final class Result {
    private int mResultCode;
    private Intent mData;

    public Result(int resultCode, Intent data) {
        mResultCode = resultCode;
        mData = data;
    }

    public int getResultCode() {
        return mResultCode;
    }

    public void setResultCode(int resultCode) {
        mResultCode = resultCode;
    }

    public Intent getData() {
        return mData;
    }

    public void setData(Intent data) {
        mData = data;
    }
}
