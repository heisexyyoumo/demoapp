package com.java.demo.widgets;
/*
    自定义BottomNavigationBar
 */

import android.content.Context;
import android.util.AttributeSet;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.java.demo.R;

public class BottomNavBar extends BottomNavigationBar {

    private TextBadgeItem mCartBadge;
    private ShapeBadgeItem mMsgBadge;
    private BottomNavigationItem homeItem;
    private BottomNavigationItem categoryItem;
    private BottomNavigationItem cartItem;
    private BottomNavigationItem msgItem;
    private BottomNavigationItem userItem;

    public BottomNavBar(Context context) {
        this(context, null);
    }

    public BottomNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        //首页
        homeItem = new BottomNavigationItem(R.drawable.btn_nav_home_press, "Home")
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColorResource(R.color.colorAccent);

        //分类
        categoryItem = new BottomNavigationItem(R.drawable.btn_nav_category_press, "Category")
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColorResource(R.color.colorAccent);

        //订单
        cartItem = new BottomNavigationItem(R.drawable.btn_nav_cart_press, "Cart")
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColorResource(R.color.colorAccent);
//        mCartBadge = new TextBadgeItem();
//        cartItem.setBadgeItem(mCartBadge);


        //消息
        msgItem = new BottomNavigationItem(R.drawable.btn_nav_msg_press, "Msg")
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColorResource(R.color.colorAccent);
//        mMsgBadge = new ShapeBadgeItem();
//        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL);
//        msgItem.setBadgeItem(mMsgBadge);

        //用户
        userItem = new BottomNavigationItem(R.drawable.btn_nav_user_press, "User")
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setActiveColorResource(R.color.colorPrimary)
                .setInActiveColorResource(R.color.colorAccent);

        //设置模式 每个item对应名称，不选中也会显示
        setMode(BottomNavigationBar.MODE_FIXED);
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        setBarBackgroundColor("#ffffff");

        addItem(homeItem)
                .addItem(categoryItem)
                .addItem(cartItem)
                .addItem(msgItem)
                .addItem(userItem)
                .setFirstSelectedPosition(0)
                .initialise();

    }


}
