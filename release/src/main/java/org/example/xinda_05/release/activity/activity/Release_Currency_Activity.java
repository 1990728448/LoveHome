package org.example.xinda_05.release.activity.activity;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.example.xinda_05.release.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Currency_Activity extends Activity {
    private LinearLayout item_back;
    private TextView StartTime, Endtime;
    private ImageView Cameracurrency;
    private ImageView img;
    private File uploadFile;
    //  拍照               相册选择              取消
    private TextView ReleasePhotograph,ReleaseAlbumselection,Releasecancel;
    PopupWindow pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_currency_layout);
        initView();
    }

    public void initView() {
        item_back = (LinearLayout) findViewById(R.id.Release_item_layout_back);
        item_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//营业时间-开始
        StartTime = (TextView) findViewById(R.id.start_time);
        StartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(Release_Currency_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(Release_Currency_Activity.this, "回调被触发", Toast.LENGTH_SHORT).show();
                    }
                }, 11, 3, true);
                dialog.show();
            }
        });
        //营业时间-结束
        Endtime = (TextView) findViewById(R.id.End_time);
        Endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(Release_Currency_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(Release_Currency_Activity.this, "回调被触发2", Toast.LENGTH_SHORT).show();
                    }
                }, 11, 3, true);
                dialog.show();
            }
        });
        Cameracurrency= (ImageView) findViewById(R.id.Camera_currency);

        Cameracurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view = LayoutInflater.from(Release_Currency_Activity.this).inflate(R.layout.release_camera_layout, null);
                pop = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setBackgroundDrawable(new BitmapDrawable());//设置背景....
                pop.setFocusable(true);//调焦
                pop.setOutsideTouchable(true);//触摸
                pop.showAtLocation(view, Gravity.BOTTOM, 0, 0);//距离控件位置
                ReleasePhotograph = (TextView) view.findViewById(R.id.Release_Photograph);
                ReleasePhotograph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1000);
                        pop.dismiss();
                    }
                });
                img = (ImageView) findViewById(R.id.img);

                ReleaseAlbumselection = (TextView) view.findViewById(R.id.Release_Albumselection);
                ReleaseAlbumselection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(it2, 1001);
                        pop.dismiss();
                    }
                });
                Releasecancel = (TextView) view.findViewById(R.id.Release_cancel);
                Releasecancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop.dismiss();
                    }
                });
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.i("TestFile", "SD card is not avaiable/writeable right now.");
                return;
            }
            new DateFormat();
            String name = DateFormat.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Toast.makeText(this, name, Toast.LENGTH_LONG).show();
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

            FileOutputStream b = null;
            File file = new File("/sdcard/Image/");
            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/Image/"+name;

            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try
            {
                img.setImageBitmap(bitmap);// 将图片显示在ImageView里
            }catch(Exception e)
            {
                Log.e("TAG","error"+ e.getMessage());
            }

        }
    }
}