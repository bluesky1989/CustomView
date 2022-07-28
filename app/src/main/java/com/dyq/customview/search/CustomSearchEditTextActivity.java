package com.dyq.customview.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dyq.customview.R;

public class CustomSearchEditTextActivity extends AppCompatActivity{
    private CustomSearchView customSearchView;
    private CustomSearchView searViewTypeSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_search_edittext);
        initViews();
    }

    private void initViews() {
        customSearchView = (CustomSearchView) findViewById(R.id.main_search_layout);
        searViewTypeSecond = (CustomSearchView) findViewById(R.id.main_search_layout_line);
        //设置hint
        customSearchView.setHintText("输入城市名、拼音或首字母");
        searViewTypeSecond.setHintText("输入城市名、拼音或首字母");
        customSearchView.setIsCanDirectSearch(false);
        //设置监听
        setListener();
    }

    private void setListener() {
        //返回
        customSearchView.setOnBackListener(new CustomSearchView.BackListener() {
            @Override
            public void onGoBack() {
                Toast.makeText(CustomSearchEditTextActivity.this,"点击了 返回 按钮",Toast.LENGTH_SHORT).show();
            }
        });
        //输入框点击
        customSearchView.setOnEditTextClickListener(new CustomSearchView.EditTextClickListener() {
            @Override
            public void onEditTextClickListener() {
                startActivity(new Intent(CustomSearchEditTextActivity.this,NewActivity.class));
            }
        });
//        searchView.setOnSearchListener(new SearchView.SearchListener() {
//            @Override
//            public void onSearch(String inputSearchText) {
//                Toast.makeText(TestTitleActivity.this,"开始搜索....",Toast.LENGTH_SHORT).show();
//            }
//        });


        //取消
        searViewTypeSecond.setOnCancelListener(new CustomSearchView.CancelListener() {
            @Override
            public void onCancel() {
                Toast.makeText(CustomSearchEditTextActivity.this,"点击了 取消 按钮",Toast.LENGTH_SHORT).show();
            }
        });

        //搜索
        searViewTypeSecond.setOnSearchListener(new CustomSearchView.SearchListener() {
            @Override
            public void onSearch(String inputSearchText) {
                Toast.makeText(CustomSearchEditTextActivity.this,"开始搜索....",Toast.LENGTH_SHORT).show();
            }
        });

    }


}