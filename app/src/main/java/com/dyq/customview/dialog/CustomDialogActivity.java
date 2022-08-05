package com.dyq.customview.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dyq.customview.R;

public class CustomDialogActivity extends AppCompatActivity {
    private TextView tv_test_dialog_type1;
    private TextView tv_test_dialog_type2;
    private TextView tv_test_dialog_type3;
    private TextView tv_test_dialog_type4;
    private TextView tv_test_dialog_type5;
    private TextView tv_test_dialog_type6;
    private TextView tv_test_dialog_type7;
    private TextView tv_test_dialog_type8;

    private TextView tv_test_picture_dialog_type1;
    private TextView tv_test_picture_dialog_type2;
    private TextView tv_test_picture_dialog_type3;

    private CustomDialog customDialog;
    private CustomPictureDialog customPictureDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        tv_test_dialog_type1=findViewById(R.id.tv_test_dialog_type1);
        tv_test_dialog_type2=findViewById(R.id.tv_test_dialog_type2);
        tv_test_dialog_type3=findViewById(R.id.tv_test_dialog_type3);
        tv_test_dialog_type4=findViewById(R.id.tv_test_dialog_type4);
        tv_test_dialog_type5=findViewById(R.id.tv_test_dialog_type5);
        tv_test_dialog_type6=findViewById(R.id.tv_test_dialog_type6);
        tv_test_dialog_type7=findViewById(R.id.tv_test_dialog_type7);
        tv_test_dialog_type8=findViewById(R.id.tv_test_dialog_type8);

        tv_test_picture_dialog_type1=findViewById(R.id.tv_test_picture_dialog_type1);
        tv_test_picture_dialog_type2=findViewById(R.id.tv_test_picture_dialog_type2);
        tv_test_picture_dialog_type3=findViewById(R.id.tv_test_picture_dialog_type3);

        tv_test_dialog_type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType1();
            }
        });

        tv_test_dialog_type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType2();
            }
        });
        tv_test_dialog_type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType3();
            }
        });
        tv_test_dialog_type4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType4();
            }
        });
        tv_test_dialog_type5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType5();
            }
        });
        tv_test_dialog_type6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType6();
            }
        });
        tv_test_dialog_type7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType7();
            }
        });
        tv_test_dialog_type8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialogType8();
            }
        });
        tv_test_picture_dialog_type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customPictureDialogType1();
            }
        });
        tv_test_picture_dialog_type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customPictureDialogType2();
            }
        });
        tv_test_picture_dialog_type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customPictureDialogType3();
            }
        });
    }

    private void customDialogType1() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTopImage(R.mipmap.icon_tanchuang_tanhao);
        builder.setTitle("弹窗标题");
        builder.setContent("1.第一行文字第一行文字,1.第一行文字第一行文字,1.第一行文字第一行文字,1.第一行文字第一行文字");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("请前往【我的】-我的积分查看");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }


    private void customDialogType2() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("弹窗标题");
        builder.setContent("<p style=\"text-align:start;\">\n" +
                "\t1.第一行文字第一行文字\n" +
                "</p>\n" +
                "<p style=\"text-align:start;\">\n" +
                "\t2.第二行文字第二行文字\n" +
                "</p>\n" +
                "<p style=\"text-align:start;\">\n" +
                "\t3.第三行文字第三行文字\n" +
                "</p>");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("按钮名称", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType3() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("弹窗标题");
        builder.setContent("段落文本段落文本段落文本段落文本段落文本段落文本段落文本");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("按钮名称", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType4() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("弹窗标题");
        builder.setContent("段落文本段落文本段落文本段落文本段落文本段落文本段落文本");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("说明文字说明文字说明文字");
        builder.setSecondTypeContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("按钮名称", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType5() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("弹窗标题");
        builder.setContent("弹窗内容弹窗内容弹窗内容");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType6() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("吸底弹窗标题");
        builder.setContent("段落文本段落文本段落文本段落文本段落文本段落文本段落文本段落文本段落文本");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.BOTTOM);
        builder.setNegativeButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType7() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setTitle("弹窗标题");
        builder.setThirdTypeContent("弹窗内容弹窗内容弹窗内容");
        builder.setThirdTypeContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("请前往【我的】-我的积分查看");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("按钮", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customDialogType8() {
        CustomDialog.Builder builder=new CustomDialog.Builder(CustomDialogActivity.this);
        builder.setContent("账号已失效，请重新登入！");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        customDialog=builder.create();
        customDialog.show();
    }

    private void customPictureDialogType1() {
        CustomPictureDialog.Builder builder=new CustomPictureDialog.Builder(CustomDialogActivity.this);
        builder.setTopImage(R.mipmap.top_picture);
        builder.setTitle("这里是标题建议一行以内");
        builder.setContent("有图，有标题，有描述的情况下建议文字最多不超过两行");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setTips("XX小时内不再提示");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("了解更多", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setCloseDialogClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        customPictureDialog=builder.create();
        customPictureDialog.show();
    }

    private void customPictureDialogType2() {
        CustomPictureDialog.Builder builder=new CustomPictureDialog.Builder(CustomDialogActivity.this);
        builder.setTopImage(R.mipmap.top_picture);
        builder.setContent("有图，无标题，有描述的情况下建议文字最多不超过2行");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setTips("XX小时内不再提示");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("了解更多", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setCloseDialogClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        customPictureDialog=builder.create();
        customPictureDialog.show();
    }

    private void customPictureDialogType3() {
        CustomPictureDialog.Builder builder=new CustomPictureDialog.Builder(CustomDialogActivity.this);
        builder.setTopImage(R.mipmap.top_picture);
        builder.setTitle("这里是标题，\n" +
                "建议2行以内，不要太多");
        builder.setTips("XX小时内不再提示");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("了解更多", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setCloseDialogClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (customPictureDialog != null){
                    customPictureDialog.dismiss();
                }
            }
        });
        builder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        customPictureDialog=builder.create();
        customPictureDialog.show();
    }
}