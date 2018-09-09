package com.java.demo.ui;

/*
    将图片保存在本地
 */
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.java.demo.R;
import com.java.demo.utils.ImageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SaveImgActivity extends AppCompatActivity {

    @BindView(R.id.mSaveBtn)
    Button mSaveBtn;
    @BindView(R.id.mDemoImg)
    ImageView mDemoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_img);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.mSaveBtn)
    public void saveImg() {
        Bitmap bmp = ((BitmapDrawable) mDemoImg.getDrawable()).getBitmap();
        Boolean isSuccess = ImageUtils.saveImgToGallery(this, bmp);
        if (isSuccess)
            Toast.makeText(this, "save success", Toast.LENGTH_LONG).show();
    }
}
