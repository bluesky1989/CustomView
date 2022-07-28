package com.dyq.customview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyq.customview.R;

/**
 * author:duyongqiang
 * mail: duyongqiang09@126.com
 * date:2022/7/22
 * Description:自定义有图片的Dialog
 */
public class CustomPictureDialog extends Dialog {

    public CustomPictureDialog(Context context) {
        super(context);
    }

    public CustomPictureDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * 建造者类
     *
     * @author duyongqiang
     */
    public static class Builder {
        private Context context;
        private int topImageId;
        private String title;
        private String content;
        private String secondTypeContent;
        private Drawable drawable;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private OnClickListener positiveButtonClickListener;
        private OnClickListener negativeButtonClickListener;
        private boolean isCanceledOnTouchOutside;
        private int gravity;
        private int contentTextAlignment;
        private int secondTypeContentTextAlignment;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 设置顶部图标
         */
        public Builder setTopImage(int id) {
            this.topImageId = id;
            return this;
        }

        /**
         * 设置标题
         *
         * @param title
         * @return
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * 设置内容
         *
         * @param content
         * @return
         */
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        /**
         * 设置内容文本对齐方式
         * @param contentTextAlignment
         * @return
         */
        public Builder setContentTextAlignment(int contentTextAlignment) {
            this.contentTextAlignment=contentTextAlignment;
            return this;
        }



        /**
         * 设置标题图标
         * @param drawableId
         * @return
         */
        public Builder setDrawable(Drawable drawableId) {
            this.drawable = drawableId;
            return this;
        }



        /**
         * 设置确定按钮
         *
         * @param positiveButtonText
         * @param listener
         * @return
         */
        public Builder setPositiveButton(String positiveButtonText,OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }


        /**
         * 设置点击弹窗外部是否可取消
         * @param isCanceledOnTouchOutside
         * @return
         */
        public Builder setCanceledOnTouchOutside(boolean isCanceledOnTouchOutside) {
            this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
            return this;
        }

        /**
         * 设置弹窗显示位置
         * @param gravity
         * @return
         */
        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        /**
         * 创建自定义Dialog实例
         *
         * @return
         */
        public CustomPictureDialog create() {
            LayoutInflater inflater = LayoutInflater.from(context);
            final CustomPictureDialog dialog = new CustomPictureDialog(context, R.style.DialogStyle);

            View layout;
            if (contentView != null) {
                layout = contentView;
            } else {
                layout = inflater.inflate(R.layout.layout_picture_dialog, null);
            }


            // 设置顶部图标
            ImageView top_image = layout.findViewById(R.id.top_image);
            if (topImageId == 0) {
                top_image.setVisibility(View.GONE);
            } else {
                top_image.setImageResource(topImageId);
            }

            // 设置标题
            TextView titleView = layout.findViewById(R.id.title);
            if (title == null) {
                titleView.setVisibility(View.GONE);
            } else {
                if (drawable != null) {
                    titleView.setCompoundDrawables(drawable, null, null, null);
                }
                titleView.setText(title);
            }

            // 设置内容
            TextView tv_content = layout.findViewById(R.id.tv_content);
            if (content == null) {
                tv_content.setVisibility(View.GONE);
            } else {
                if (contentTextAlignment == View.TEXT_ALIGNMENT_TEXT_START){//左对齐
                    tv_content.setText(Html.fromHtml(content));
                }else {
                    tv_content.setText(content);
                }

            }

            //设置内容文本对齐方式
            if (contentTextAlignment == 0) {
                tv_content.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            } else {
                tv_content.setTextAlignment(contentTextAlignment);
            }


            // 设置"确定"按钮
            TextView tv_sure = layout.findViewById(R.id.tv_sure);
            if (TextUtils.isEmpty(positiveButtonText) || positiveButtonClickListener == null) {
                tv_sure.setVisibility(View.GONE);
            } else {
                tv_sure.setText(positiveButtonText);
                tv_sure.setVisibility(View.VISIBLE);
                tv_sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        positiveButtonClickListener.onClick(dialog,DialogInterface.BUTTON_POSITIVE);
                    }
                });
            }

            // 设置对话框的视图
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            Window win = dialog.getWindow();
            win.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = win.getAttributes();
            if (Gravity.BOTTOM == gravity){
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            }else {
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            lp.height = WindowManager.LayoutParams.MATCH_PARENT;
            win.setAttributes(lp);
            win.setGravity(gravity);
            dialog.setContentView(layout, params);
            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
            return dialog;
        }
    }
}

