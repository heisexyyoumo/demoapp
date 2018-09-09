package com.java.demo.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    //将图片存储在本地
    public static boolean saveImgToGallery(Context context, Bitmap bitmap) {
        //获取路径
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "humorous";
        File dir = new File(storePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        //获得文件名
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(storePath, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //压缩图片
            boolean isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.flush();
            fos.close();

            //把文件插入到系统图库
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), fileName, null);

            //广播通知刷新
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            return isSuccess;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
