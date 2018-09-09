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


public class MsgFragment extends LazyLoadFragment {

    @Override
    protected int setContentView() {
        return R.layout.fragment_msg;
    }

    @Override
    protected void lazyLoad() {
        String message = "MsgFragment" + (isInit
                ? "已经初始并已经显示给用户可以加载数据"
                : "没有初始化不能加载数据") + ">>>>>>>>>>>>>>>>>>>";
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "MsgFragment" + "已经对用户不可见，可以停止加载数据");
    }
}
