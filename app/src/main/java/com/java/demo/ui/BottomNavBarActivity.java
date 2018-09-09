package com.java.demo.ui;

/*
    实现viewpage懒加载，及viewpager与bottomnavigationbar的绑定
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.java.demo.R;
import com.java.demo.fragment.CartFragment;
import com.java.demo.fragment.CategoryFragment;
import com.java.demo.fragment.HomeFragment;
import com.java.demo.fragment.MsgFragment;
import com.java.demo.fragment.UserFragment;
import com.java.demo.widgets.BottomNavBar;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavBarActivity extends AppCompatActivity {

    @BindView(R.id.mBtnNavBar)
    BottomNavBar mBtnNavBar;

    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

//    @BindView(R.id.mContainerFl)
//    FrameLayout mContainerFl;

    List<Fragment> list = new ArrayList<>();

    HomeFragment homeFragment = new HomeFragment();
    CategoryFragment categoryFragment = new CategoryFragment();
    CartFragment cartFragment = new CartFragment();
    MsgFragment msgFragment = new MsgFragment();
    UserFragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_bar);
        ButterKnife.bind(this);

        loadFragment();
        initViewPager();
        initBottomNav();
        //显示第一个
        changeFragement(0);

    }


    private void loadFragment() {
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.mContainerFl, homeFragment);
//        transaction.add(R.id.mContainerFl, categoryFragment);
//        transaction.add(R.id.mContainerFl, cartFragment);
//        transaction.add(R.id.mContainerFl, msgFragment);
//        transaction.add(R.id.mContainerFl, userFragment);
//        transaction.commit();

        list.add(homeFragment);
        list.add(categoryFragment);
        list.add(cartFragment);
        list.add(msgFragment);
        list.add(userFragment);

    }

    private void initViewPager() {
        //ViewPager的滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBtnNavBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //ViewPager设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    //监听事件
    private void initBottomNav() {
        mBtnNavBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mViewPager.setCurrentItem(position);
                changeFragement(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void changeFragement(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : list)
            transaction.hide(fragment);

        transaction.show(list.get(position));
        transaction.commit();
    }


}
