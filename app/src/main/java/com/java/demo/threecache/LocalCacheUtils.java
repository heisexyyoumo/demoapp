package com.java.demo.threecache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LocalCacheUtils {
    public Bitmap getBitmapFromLocal(String url) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "luozhigangtest";
        String fileName = url.substring(url.lastIndexOf("/"));
        File file = new File(path, fileName);
        try {
            return BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBitmapToLocal(String url, Bitmap bitmap) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "luozhigangtest";
        String fileName = url.substring(url.lastIndexOf("/"));
        File file = new File(path, fileName);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
