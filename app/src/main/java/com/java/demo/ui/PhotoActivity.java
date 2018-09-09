package com.java.demo.ui;

/*
    实现从相册选取图片和拍照获取图片
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.java.demo.R;

import java.io.File;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mPhotoBtn;
    private ImageView mTargetImg;
    private Uri uri;
    public static final int TAKE_PHOTO = 1;
    public static final int RESULT_REQUEST_CODE = 2;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        initView();
    }

    private void initView() {
        mTargetImg = (ImageView) findViewById(R.id.mTargetImg);
        mPhotoBtn = (Button) findViewById(R.id.mPhotoBtn);
        mPhotoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mPhotoBtn:
                finish();
//                createUri();
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//                startActivityForResult(intent, TAKE_PHOTO);
                break;
        }
    }

    private void createUri() {
        File file = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        filePath = file.getAbsolutePath();
        uri = Uri.fromFile(file);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                            System.currentTimeMillis() + ".jpg"));
                    cropPhoto(uri);
                    //Bitmap bitmap = BitmapFactory.decodeFile(filePath);
//                    Bundle bundle = data.getExtras();
//                    if(bundle != null){
//                        Bitmap bitmap = bundle.getParcelable("data");
//                        mTargetImg.setImageBitmap(bitmap);
//                    }
                    //mTargetImg.setImageBitmap(bitmap);
                }
                break;

            case RESULT_REQUEST_CODE:
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                mTargetImg.setImageBitmap(bitmap);
                break;
        }
    }

    private void cropPhoto(Uri uri) {
        if (uri == null) {
            return;
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        //设置裁剪
        intent.putExtra("crop", "true");
        //裁剪宽高比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //裁剪图片的质量
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        //发送数据
        intent.putExtra("return-data", true);
        startActivityForResult(intent, RESULT_REQUEST_CODE);
    }

}
