package com.github.richyeoh.okrouter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public final class OkRouter {
    private RouterImpl mRouter = new RouterImpl();

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
}
