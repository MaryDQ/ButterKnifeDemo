package com.feicui.butterknifedemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.tv1,R.id.tv2,R.id.tv3})
    List<TextView> textViewList;
    private Unbinder unbinder;

    static final ButterKnife.Action<TextView> showName=new ButterKnife.Action<TextView>() {
        @Override
        public void apply(@NonNull TextView view, int index) {
            if (index==0){
                view.setText("小学僧");
            }else{
                view.setText("高丽圣僧");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder=ButterKnife.bind(this);
        ButterKnife.apply(textViewList,showName);
    }

    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                Toast.makeText(this, "111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this, "222222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                Toast.makeText(this, "333333", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
