package org.example.xinda_05.release.activity.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.example.xinda_05.release.R;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

import cz.msebera.android.httpclient.entity.mime.Header;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Meishi_Activity  extends Activity {
    private LinearLayout item_back;//返回
    private TextView StartTime ,Endtime,Takeout_Start_time,Takeout_End_time;
    private ImageButton ChoiceNoChoiceHook;//是否选择外卖
    private ImageView MeishiCamera;//照相机
    private ImageView img;
    private File uploadFile;

                        //  拍照               相册选择              取消
    private TextView ReleasePhotograph,ReleaseAlbumselection,Releasecancel;
    PopupWindow pop;
    //图片点击次数
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_meishi_layout);

        initView();
    }
    //初始化控件
     public void  initView(){
         item_back= (LinearLayout) findViewById(R.id.Release_item_layout_back);
         item_back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 finish();

             }
         });
//营业时间-开始
         StartTime= (TextView) findViewById(R.id.start_time);
         StartTime.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 TimePickerDialog dialog=new TimePickerDialog(Release_Meishi_Activity.this, new TimePickerDialog.OnTimeSetListener() {

                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         Toast.makeText(Release_Meishi_Activity.this, "回调被触发", Toast.LENGTH_SHORT).show();

                     }
                 }, 11, 3, true);
                 dialog.show();

             }
         });
         //营业时间-结束
         Endtime= (TextView) findViewById(R.id.End_time);
         Endtime.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 TimePickerDialog dialog=new TimePickerDialog(Release_Meishi_Activity.this, new TimePickerDialog.OnTimeSetListener() {

                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         Toast.makeText(Release_Meishi_Activity.this, "回调被触发2", Toast.LENGTH_SHORT).show();
                     }
                 }, 11, 3, true);
                 dialog.show();
             }
         });
         //外卖时间-开始
         Takeout_Start_time= (TextView) findViewById(R.id.takeout_start_time);
         Takeout_Start_time.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 TimePickerDialog dialog=new TimePickerDialog(Release_Meishi_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         Toast.makeText(Release_Meishi_Activity.this, "回调被触发2", Toast.LENGTH_SHORT).show();
                     }
                 }, 11, 3, true);
                 dialog.show();
             }
         });
         //外卖时间-结束
         Takeout_End_time = (TextView) findViewById(R.id.takeout_End_time);
         Takeout_End_time.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 TimePickerDialog dialog=new TimePickerDialog(Release_Meishi_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         Toast.makeText(Release_Meishi_Activity.this, "回调被触发2", Toast.LENGTH_SHORT).show();
                     }
                 }, 11, 3, true);
                 dialog.show();
             }
         });
         //外卖钩选框
         ChoiceNoChoiceHook= (ImageButton) findViewById(R.id.Choice_NoChoice_Hook);
         //外卖隐藏，点击更换图片，并弹出相应线性
         final LinearLayout linearLayout= (LinearLayout) findViewById(R.id.waimai);
         ChoiceNoChoiceHook.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 i++;
                 if(i%2!=0) {
                     ChoiceNoChoiceHook.setImageResource(R.mipmap.checkbox_bg_fouse);
                    linearLayout.setVisibility(View.VISIBLE);
                 }else {
                     ChoiceNoChoiceHook.setImageResource(R.mipmap.checkbox_bg_default);
                     linearLayout.setVisibility(View.GONE);
                 }
             }
         });
         MeishiCamera= (ImageView) findViewById(R.id.Meishi_Camera);
         MeishiCamera.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 view = LayoutInflater.from(Release_Meishi_Activity.this).inflate(R.layout.release_camera_layout, null);
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
                img.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        AlertDialog.Builder builder=new AlertDialog.Builder(Release_Meishi_Activity.this);
                        builder .setTitle("提示");
                        builder.setMessage("您确定要删除当前照片吗");
                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Toast.makeText(Release_Meishi_Activity.this, "被点击了", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.setNegativeButton("取消",null);
                        builder.show();
                        return true;
                    }

                });

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1000){
                //拍照
                Bundle b = data.getExtras();
                Bitmap bm = (Bitmap) b.get("data");
                img.setImageBitmap(bm);
                saveImg(bm);
            }else if(requestCode == 1001){
                //打开图库
                //1.获取图库uri
                Uri uri = data.getData();
                //2.查询列：图片路径
                String[] pro = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(uri , pro , null , null , null);
                c.moveToFirst();
                //3.获取路径
                String path = c.getString(0);
                uploadFile = new File(path);
                //4.获取图片的Bitmap对象
                Bitmap bm = BitmapFactory.decodeFile(path);
                img.setImageBitmap(bm);
            }
        }
    }
    private void saveImg(Bitmap bitmap) {
        //将本应的图片同意保存一个文件夹中
        String root = Environment.getExternalStorageDirectory() + "/http_img";
        try {
            File saveFile = new File(root);
            if (!saveFile.exists()) {
                saveFile.mkdir();
            }
            //UUID.randomUUID()   根据当前时间生成一个长字符串，并且保证永不重复
            String path = root +"/" +  UUID.randomUUID() + ".jpg";

            uploadFile = new File(path);

            FileOutputStream fos = new FileOutputStream(path);

            //参数1：格式
            //参数2：压缩率，0-100，0表示完全压缩
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}