package com.github.richyeoh.okrouter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;

public class ProxyFragment extends Fragment {
    private static final String TAG_PROXY_FRAGMENT = "proxy_fragment";

    public static void route(FragmentActivity activity, TransferParameters parameters) {
        FragmentManager manager = activity.getSupportFragmentManager();
        route(manager, parameters);
    }

    public static void route(Fragment fragment, TransferParameters parameters) {
        FragmentManager manager = fragment.getChildFragmentManager();
        route(manager, parameters);
    }

    private static void route(FragmentManager manager, TransferParameters parameters) {
        ProxyFragment fragment = findFragment(manager);
        fragment.realRoute(parameters);
    }

    private static ProxyFragment findFragment(FragmentManager manager) {
        if (manager.isDestroyed()) {
            throw new IllegalStateException("Fragment manager been is destroyed.");
        }
        ProxyFragment fragment = (ProxyFragment) manager.findFragmentByTag(TAG_PROXY_FRAGMENT);
        if (fragment == null) {
            fragment = createFragment(manager);
        }
        return fragment;
    }

    private static ProxyFragment createFragment(FragmentManager manager) {
        ProxyFragment fragment = new ProxyFragment();
        manager.beginTransaction().add(fragment, TAG_PROXY_FRAGMENT).commitAllowingStateLoss();
        return fragment;
    }

    private void realRoute(TransferParameters parameters) {
        String url = parameters.getUrl();
        if (!TextUtils.isEmpty(url)) {
            routeUrl(url);
        }

        Class targetClass = parameters.getTargetClass();
        if (targetClass != null) {
            routeClass(targetClass);
        }
    }

    private void routeClass(Class targetClass) {

    }

    private void routeUrl(String url) {

    }
}
