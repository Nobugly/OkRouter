package com.github.richyeoh.okrouter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.io.Serializable;

public final class OkRouter {
    private RouterImpl mRouter = new RouterImpl();
    private TransferParameters mParameters = new TransferParameters();

    private FragmentActivity mActivity;
    private Fragment mFragment;
    private Context mContext;

    private OkRouter() {
    }

    public static OkRouter of(FragmentActivity activity) {
        OkRouter okRouter = new OkRouter();
        okRouter.mActivity = activity;
        return okRouter;
    }

    public static OkRouter of(Fragment fragment) {
        OkRouter okRouter = new OkRouter();
        okRouter.mFragment = fragment;
        return okRouter;
    }

    public static OkRouter of(Context context) {
        OkRouter okRouter = new OkRouter();
        okRouter.mContext = context;
        return okRouter;
    }

    public OkRouter with(String key, byte value) {
        mParameters.getDataQueue().putByte(key, value);
        return this;
    }

    public OkRouter with(String key, byte[] value) {
        mParameters.getDataQueue().putByteArray(key, value);
        return this;
    }

    public OkRouter with(String key, short value) {
        mParameters.getDataQueue().putShort(key, value);
        return this;
    }

    public OkRouter with(String key, short[] value) {
        mParameters.getDataQueue().putShortArray(key, value);
        return this;
    }

    public OkRouter with(String key, int value) {
        mParameters.getDataQueue().putInt(key, value);
        return this;
    }

    public OkRouter with(String key, int[] value) {
        mParameters.getDataQueue().putIntArray(key, value);
        return this;
    }

    public OkRouter with(String key, long value) {
        mParameters.getDataQueue().putLong(key, value);
        return this;
    }

    public OkRouter with(String key, long[] value) {
        mParameters.getDataQueue().putLongArray(key, value);
        return this;
    }

    public OkRouter with(String key, float value) {
        mParameters.getDataQueue().putFloat(key, value);
        return this;
    }

    public OkRouter with(String key, float[] value) {
        mParameters.getDataQueue().putFloatArray(key, value);
        return this;
    }

    public OkRouter with(String key, double value) {
        mParameters.getDataQueue().putDouble(key, value);
        return this;
    }

    public OkRouter with(String key, double[] value) {
        mParameters.getDataQueue().putDoubleArray(key, value);
        return this;
    }

    public OkRouter with(String key, char value) {
        mParameters.getDataQueue().putChar(key, value);
        return this;
    }

    public OkRouter with(String key, char[] value) {
        mParameters.getDataQueue().putCharArray(key, value);
        return this;
    }

    public OkRouter with(String key, boolean value) {
        mParameters.getDataQueue().putBoolean(key, value);
        return this;
    }

    public OkRouter with(String key, boolean[] value) {
        mParameters.getDataQueue().putBooleanArray(key, value);
        return this;
    }

    public OkRouter with(String key, String value) {
        mParameters.getDataQueue().putString(key, value);
        return this;
    }

    public OkRouter with(String key, String[] value) {
        mParameters.getDataQueue().putStringArray(key, value);
        return this;
    }

    public OkRouter with(String key, Serializable value) {
        mParameters.getDataQueue().putSerializable(key, value);
        return this;
    }

    public OkRouter with(String key, Parcelable value) {
        mParameters.getDataQueue().putParcelable(key, value);
        return this;
    }

    public OkRouter with(String key, Bundle value) {
        mParameters.getDataQueue().putBundle(key, value);
        return this;
    }

    public OkRouter setFlags(int flags) {
        mParameters.setFlags(flags);
        return this;
    }

    public OkRouter setData(Uri data) {
        mParameters.setData(data);
        return this;
    }

    public OkRouter setType(String type) {
        mParameters.setType(type);
        return this;
    }
}
