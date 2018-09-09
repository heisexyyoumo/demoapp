package com.java.demo.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.java.demo.R;


public class CartFragment extends LazyLoadFragment {

    @Override
    protected int setContentView() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void lazyLoad() {
        String message = "CartFragment" + (isInit
                ? "已经初始并已经显示给用户可以加载数据"
                : "没有初始化不能加载数据") + ">>>>>>>>>>>>>>>>>>>";
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "CartFragment" + "已经对用户不可见，可以停止加载数据");
    }
}
