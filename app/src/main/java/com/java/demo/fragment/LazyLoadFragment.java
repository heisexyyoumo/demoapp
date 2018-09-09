package com.java.demo.fragment;

/*
    fragment的懒加载基类
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LazyLoadFragment extends Fragment {
    protected boolean isInit = false;
    protected boolean isLoad = false;
    protected final String TAG = "LazyLoadFragment";
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setContentView(), container, false);
        isInit = true;
        //初始化的时候加载数据
        isCanLoadData();
        return view;
    }

    //视图是否已经对用户可见
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    private void isCanLoadData() {
        //未初始化就不加载数据
        if (!isInit)
            return;

        if (getUserVisibleHint()) {
            //当初始化完成且视图可见就加载数据
            lazyLoad();
            isLoad = true;
        } else {
            //当视图不可见，就停止加载数据
            if (isLoad) {
                stopLoad();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    //返回布局id
    protected abstract int setContentView();

    //当初始化完成且视图可见就加载数据
    protected abstract void lazyLoad();

    //当视图已经对用户不可见并且加载过数据
    // 如果需要在切换到其他页面时停止加载数据，可以覆写此方法
    protected void stopLoad() {

    }
}
