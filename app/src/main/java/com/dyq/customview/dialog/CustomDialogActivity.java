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
        builder.setTitle("????????????");
        builder.setContent("1.??????????????????????????????,1.??????????????????????????????,1.??????????????????????????????,1.??????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("?????????????????????-??????????????????");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("????????????");
        builder.setContent("<p style=\"text-align:start;\">\n" +
                "\t1.??????????????????????????????\n" +
                "</p>\n" +
                "<p style=\"text-align:start;\">\n" +
                "\t2.??????????????????????????????\n" +
                "</p>\n" +
                "<p style=\"text-align:start;\">\n" +
                "\t3.??????????????????????????????\n" +
                "</p>");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("????????????");
        builder.setContent("????????????????????????????????????????????????????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("????????????");
        builder.setContent("????????????????????????????????????????????????????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("????????????????????????????????????");
        builder.setSecondTypeContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("????????????");
        builder.setContent("????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("??????????????????");
        builder.setContent("????????????????????????????????????????????????????????????????????????????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.BOTTOM);
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("????????????");
        builder.setThirdTypeContent("????????????????????????????????????");
        builder.setThirdTypeContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setSecondTypeContent("?????????????????????-??????????????????");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
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
        builder.setContent("????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setNegativeButton("????????????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if (customDialog != null){
                    customDialog.dismiss();
                }
            }
        });
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("?????????????????????????????????");
        builder.setContent("???????????????????????????????????????????????????????????????????????????");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setTips("XX?????????????????????");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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
        builder.setContent("?????????????????????????????????????????????????????????????????????2???");
        builder.setContentTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        builder.setTips("XX?????????????????????");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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
        builder.setTitle("??????????????????\n" +
                "??????2????????????????????????");
        builder.setTips("XX?????????????????????");
        builder.setCanceledOnTouchOutside(true);
        builder.setGravity(Gravity.CENTER);
        builder.setPositiveButton("????????????", new DialogInterface.OnClickListener() {
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