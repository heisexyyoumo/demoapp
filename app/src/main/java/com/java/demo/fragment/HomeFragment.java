package com.java.demo.fragment;



import android.util.Log;
import com.java.demo.R;


public class HomeFragment extends LazyLoadFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void lazyLoad() {
        String message = "HomeFragment" + (isInit
                ? "已经初始并已经显示给用户可以加载数据"
                : "没有初始化不能加载数据") + ">>>>>>>>>>>>>>>>>>>";
        Log.d(TAG, message);
    }

    @Override
    protected void stopLoad() {
        Log.d(TAG, "HomeFragment" + "已经对用户不可见，可以停止加载数据");
    }
}
