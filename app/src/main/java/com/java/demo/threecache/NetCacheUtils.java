package com.java.demo.threecache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import android.widget.ImageView;

import com.java.demo.base.BaseObserver;
import com.java.demo.factory.RetrofitFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;


public class NetCacheUtils {
    private LocalCacheUtils localCacheUtils;
    private MemoryCacheUtils memoryCacheUtils;

    public NetCacheUtils(LocalCacheUtils mLocalCacheUtils, MemoryCacheUtils mMemoryCacheUtils) {
        this.localCacheUtils = mLocalCacheUtils;
        this.memoryCacheUtils = mMemoryCacheUtils;
    }

    public void getBitmapFromNet(final ImageView imageView, final String url) {
        RetrofitFactory.getInstance()
                .downloadPicFromNet(url)
                .subscribeOn(Schedulers.newThread())
                .map(new Function<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap apply(ResponseBody responseBody) throws Exception {
//                        BitmapFactory.Options options = new BitmapFactory.Options();
//
//                        options.inJustDecodeBounds = true;
//                        BitmapFactory.decodeStream(responseBody.byteStream(),
//                                null, options);
//                        options.inJustDecodeBounds = false;
//                        options.inSampleSize = 2;
//                        Bitmap bitmap = BitmapFactory.decodeStream(responseBody.byteStream(),
//                                null, options);

                        Bitmap bitmap = BitmapFactory.decodeStream(responseBody.byteStream());
                        memoryCacheUtils.setBitmapToMemory(url, responseBody.byteStream());
                        localCacheUtils.setBitmapToLocal(url, bitmap);
                        return bitmap;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Bitmap>() {
                    @Override
                    public void onNext(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);

                    }
                });
    }
}
