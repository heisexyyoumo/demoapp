package com.java.demo.threecache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

import java.io.InputStream;

public class MemoryCacheUtils {
    public LruCache<String, Bitmap> mMemoryCache;

    public MemoryCacheUtils() {
        int cacheSize = 4 * 1024 * 1024; //4M的内存缓存大小
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public Bitmap getBitmapFromMemory(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        return bitmap;
    }

    public void setBitmapToMemory(String url, InputStream is) {
        if (getBitmapFromMemory(url) == null) {
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            mMemoryCache.put(url, bitmap);
        }

    }
}
