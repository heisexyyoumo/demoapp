package com.java.demo.ui;

/*
    动画展示界面
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.java.demo.R;
import com.java.demo.widgets.TestView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private LinearLayout ll_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
    }

    private void initView() {
        btn_add = (Button)findViewById(R.id.btn_add);
        ll_layout = (LinearLayout)findViewById(R.id.ll_layout);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                ll_layout.addView(new TestView(this),0);
                break;
        }
    }
}
