package com.github.richyeoh.okrouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class ProxyFragment extends Fragment {
    private static final String TAG_PROXY_FRAGMENT = "proxy_fragment";

    {
        setRetainInstance(true);
    }

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
        if (fragment != null) {
            fragment.realRoute(parameters);
        } else {
            createFragment(manager, parameters);
        }

    }

    private static ProxyFragment findFragment(FragmentManager manager) {
        if (manager.isDestroyed()) {
            throw new IllegalStateException("Fragment manager been is destroyed.");
        }
        return (ProxyFragment) manager.findFragmentByTag(TAG_PROXY_FRAGMENT);
    }

    private static ProxyFragment createFragment(FragmentManager manager, TransferParameters parameters) {
        ProxyFragment fragment = new ProxyFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("parameters", parameters);
        fragment.setArguments(bundle);
        manager.beginTransaction().add(fragment, TAG_PROXY_FRAGMENT).commitAllowingStateLoss();
        return fragment;
    }

    private void realRoute(TransferParameters parameters) {
        Class targetClass = parameters.getTargetClass();
        if (targetClass != null) {
            Intent intent = new Intent(getContext(), targetClass);
            intent.putExtra("data", parameters.getDataQueue());
            int requestCode = 0x0001;
            ParameterHolder.put(requestCode, parameters);
            startActivityForResult(intent, requestCode);
        }
    }

    private void routeClass(Class targetClass) {

    }

    private void routeUrl(String url) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int magicNumber = ParameterHolder.get(requestCode).magicNumber;
        if (data != null) {
            PublishHolder.get(magicNumber).onSuccess(new Result(resultCode, data));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("onCreate", "oh i'm been created");
        Bundle arguments = getArguments();
        if (arguments != null) {
            TransferParameters parameters = (TransferParameters) arguments.getSerializable("parameters");
            if (parameters != null) {
                realRoute(parameters);
            }
        }
    }
}
