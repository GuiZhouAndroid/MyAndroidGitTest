package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R2.id.tv)TextView tv;//绑定TextView 控件
    @BindView(R2.id.btn)Button btn;//绑定Button 控件
    @BindView(R2.id.btn1)Button btn1;//绑定Button 控件
    @BindView(R2.id.iv)ImageView iv;//绑定ImageView 控件
    @BindString(R2.string.app_name)String str;//绑定资源文件中string字符串
    @BindArray(R2.array.city)String[] strArray;//绑定资源文件中string字符串数组
    @BindBitmap(R.mipmap.ic_launcher)Bitmap bitmap;//绑定资源文件中mipmap中的ic_launcher图片
    @BindColor(R2.color.colorAccent)int BtnTextColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化ButterKnife注解
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.show,new Fragment()).commit();
        tv.setText(str);
        btn.setText(strArray[1]);
        btn.setTextColor(BtnTextColor);
        iv.setImageBitmap(bitmap);
    }

//    @OnClick(R2.id.btn)
//    public void onViewOneClicked(){
//        Toast.makeText(this, "我是单个Btn点击事件", Toast.LENGTH_SHORT).show();
//    }

    @OnClick({R2.id.btn,R2.id.tv})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.btn:
                Toast.makeText(this, "我是多个btn点击事件", Toast.LENGTH_SHORT).show();
            break;
            case R.id.tv:
                Toast.makeText(this, "我是多个tv点击事件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    //多个控件对应公共事件
    @OnClick({R2.id.btn,R2.id.btn1})
    public void sayHi(Button btn) {
        btn.setText("Success!");
    }


//    @OnLongClick(R2.id.btn)
//    public void onViewOneLongClicked(){
//        Toast.makeText(this, "我是单个Btn长按事件", Toast.LENGTH_SHORT).show();
//    }

    @OnLongClick({R2.id.btn,R2.id.tv})
    public void onViewLongClicked(View view){
        switch (view.getId()){
            case R.id.btn:
                Toast.makeText(this, "我是多个长按Btn事件", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv:
                Toast.makeText(this, "我是多个长按tv事件", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
