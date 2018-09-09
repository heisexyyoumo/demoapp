package com.java.demo.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.java.demo.R;
import com.java.demo.base.BaseObserver;
import com.java.demo.constant.ConstantData;
import com.java.demo.factory.RetrofitFactory;
import com.java.demo.utils.BitmapCacheUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ThreeCacheActivity extends AppCompatActivity {

    @BindView(R.id.mThreeCacheIv)
    ImageView mThreeCacheIv;
    @BindView(R.id.mGetImgBtn)
    Button mGetImgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_cache);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.mGetImgBtn)
    public void load() {
        new BitmapCacheUtils().setBitmap(mThreeCacheIv, ConstantData.URL);
    }
}
