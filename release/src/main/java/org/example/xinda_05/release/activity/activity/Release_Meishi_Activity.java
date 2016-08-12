package org.example.xinda_05.release.activity.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.example.xinda_05.release.R;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Meishi_Activity  extends Activity {
    private LinearLayout item_back;
    private TextView StartTime ,Endtime,Takeout_Start_time,Takeout_End_time;

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
     }
}
