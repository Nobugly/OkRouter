package com.github.richyeoh.okrouter;

import android.net.Uri;
import android.os.Bundle;

import java.io.Serializable;

public class TransferParameters implements Serializable {
    private static final Bundle sDataQueue = new Bundle();

    public int magicNumber;

    TransferParameters() {
        magicNumber++;
    }

    private int mFlags;

    private Uri mData;
    private String mType;

    private String mUrl;

    private Class mTargetClass;

    public Bundle getDataQueue() {
        return sDataQueue;
    }

    public int getFlags() {
        return mFlags;
    }

    public void setFlags(int flags) {
        mFlags = flags;
    }

    public Uri getData() {
        return mData;
    }

    public void setData(Uri data) {
        mData = data;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Class getTargetClass() {
        return mTargetClass;
    }

    public void setTargetClass(Class targetClass) {
        mTargetClass = targetClass;
    }
}
