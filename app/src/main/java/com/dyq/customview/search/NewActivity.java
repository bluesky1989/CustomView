package com.dyq.customview.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.dyq.customview.R;

public class NewActivity extends AppCompatActivity {
    private CustomSearchView searViewTypeSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        searViewTypeSecond = (CustomSearchView) findViewById(R.id.main_search_layout_line);
        //设置hint
        searViewTypeSecond.setHintText("输入城市名、拼音或首字母");
        //设置监听
        setListener();
    }


    private void setListener() {
        //取消
        searViewTypeSecond.setOnCancelListener(new CustomSearchView.CancelListener() {
            @Override
            public void onCancel() {
                NewActivity.this.finish();
            }
        });

        //搜索
        searViewTypeSecond.setOnSearchListener(new CustomSearchView.SearchListener() {
            @Override
            public void onSearch(String inputSearchText) {
                Toast.makeText(NewActivity.this,"开始搜索....",Toast.LENGTH_SHORT).show();
            }
        });

    }
}