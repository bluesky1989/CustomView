package com.dyq.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dyq.customview.dialog.CustomDialogActivity;
import com.dyq.customview.search.CustomSearchEditTextActivity;

public class MainActivity extends AppCompatActivity {
    private TextView btn_custom_dialog;
    private TextView btn_custom_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_custom_dialog=findViewById(R.id.btn_custom_dialog);
        btn_custom_search=findViewById(R.id.btn_custom_search);
        setListener();

    }

    private void setListener() {
        //跳转到自定义弹框
        btn_custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomDialogActivity.class));
            }
        });
        //跳转到自定义搜索框
        btn_custom_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomSearchEditTextActivity.class));
            }
        });
    }


}