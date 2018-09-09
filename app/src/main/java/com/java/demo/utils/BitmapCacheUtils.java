package com.java.demo.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.java.demo.threecache.LocalCacheUtils;
import com.java.demo.threecache.MemoryCacheUtils;
import com.java.demo.threecache.NetCacheUtils;


public class BitmapCacheUtils {

    static final String TAG = "BitmapCacheUtils";

    private NetCacheUtils netCacheUtils;
    private LocalCacheUtils localCacheUtils;
    private MemoryCacheUtils memoryCacheUtils;

    public BitmapCacheUtils() {
        memoryCacheUtils = new MemoryCacheUtils();
        localCacheUtils = new LocalCacheUtils();
        netCacheUtils = new NetCacheUtils(localCacheUtils, memoryCacheUtils);
    }

    public void setBitmap(ImageView img, String url) {
        //设置初始默认图片
        //img.setImageResource(R.drawable.demo);
        Bitmap bitmap;
        //从内存获取图片
        bitmap = memoryCacheUtils.getBitmapFromMemory(url);
        if (bitmap != null) {
            img.setImageBitmap(bitmap);
            Log.d(TAG, "com from memory");
            return;
        }
        //从本地获取图片
        bitmap = localCacheUtils.getBitmapFromLocal(url);
        if (bitmap != null) {
            img.setImageBitmap(bitmap);
            Log.d(TAG, "com from local");
            return;
        }
        //从网络获取图片
        netCacheUtils.getBitmapFromNet(img, url);
    }


}


