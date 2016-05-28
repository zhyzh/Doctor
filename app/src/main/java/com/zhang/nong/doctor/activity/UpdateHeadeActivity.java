package com.zhang.nong.doctor.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhang.nong.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by XCF on 2016/5/25.
 */
public class UpdateHeadeActivity extends Activity {

    private static int CAMERA_REQUEST_CODE = 1;
    private static int GALLERY_REQUEST_CODE = 2;
    private static int CROP_REQUEST_CODE = 3;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_updatehead);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (data == null) {
                return;
            } else {
                Bundle extres = data.getExtras();//从data中取出数据
                if (extres!=null){
                    Bitmap bm = extres.getParcelable("data");//保存用户拍摄的数据
                    //将照片上传到imageview中显示
                    ImageView imageView = (ImageView) findViewById(R.id.imageview);
                    imageView.setImageBitmap(bm);
                }
            }
        }
        if (requestCode == GALLERY_REQUEST_CODE){
            if (data == null){
                return;
            }
            Uri uri;
            uri = data.getData();
            Toast.makeText(UpdateHeadeActivity.this,uri.toString(),Toast.LENGTH_SHORT).show();


        }
    }
    //将bitmap的图片保存到SD卡中
    private Uri saveBitMap(Bitmap bm){
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/com.Doctor.avater");
        if (!tmpDir.exists()){
            tmpDir.mkdir();
        }
        File img = new File(tmpDir.getAbsolutePath() + "avater.png");
        try {
            FileOutputStream fos = new FileOutputStream(img);
            bm.compress(Bitmap.CompressFormat.PNG,85,fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //转换uri
    private Uri converUri(Uri uri){
        InputStream is = null;
        try {
            is = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return saveBitMap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void back1(View view) {
        //拍照
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }

    public void back2(View view) {
        //图库
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //设置选择文件类型
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void back3(View view) {
        finish();
    }

    public void back4(View view) {
    }

    public void back(View view) {
        finish();
    }
}
