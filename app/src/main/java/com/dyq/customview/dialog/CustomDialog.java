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
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.dyq.customview.R;

/**
 * author:duyongqiang
 * mail: duyongqiang09@126.com
 * date:2022/7/22
 * Description:自定义Dialog
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int theme) {
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
        private CharSequence thirdTypeContent;
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
        private int thirdTypeContentTextAlignment;

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
         * 设置内容类型2
         * @param secondTypeContent
         * @return
         */
        public Builder setSecondTypeContent(String secondTypeContent) {
            this.secondTypeContent = secondTypeContent;
            return this;
        }

        /**
         * 设置内容类型2的对齐方式
         * @param secondTypeContentTextAlignment
         * @return
         */
        public Builder setSecondTypeContentTextAlignment(int secondTypeContentTextAlignment) {
            this.secondTypeContentTextAlignment=secondTypeContentTextAlignment;
            return this;
        }

        /**
         * 设置内容3
         *显示位置和content一致
         * @param thirdTypeContent
         * @return
         */
        public Builder setThirdTypeContent(CharSequence thirdTypeContent) {
            this.thirdTypeContent = thirdTypeContent;
            return this;
        }

        /**
         * 设置内容3文本对齐方式
         * @param thirdTypeContentTextAlignment
         * @return
         */
        public Builder setThirdTypeContentTextAlignment(int thirdTypeContentTextAlignment) {
            this.thirdTypeContentTextAlignment = thirdTypeContentTextAlignment;
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
         * 设置自定义弹窗布局
         * @param contentView
         * @return
         */
        public Builder setContentView(View contentView) {
            this.contentView = contentView;
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
         * 设置取消按钮
         *
         * @param negativeButtonText
         * @param listener
         * @return
         */
        public Builder setNegativeButton(String negativeButtonText,OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
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
        public CustomDialog create() {
            LayoutInflater inflater = LayoutInflater.from(context);
            final CustomDialog dialog = new CustomDialog(context, R.style.DialogStyle);

            View layout;
            if (contentView != null) {
                layout = contentView;
            } else {
                layout = inflater.inflate(R.layout.layout_alert_dialog, null);
            }

            View view_space_bottom=layout.findViewById(R.id.view_space_bottom);
            View view_space_top=layout.findViewById(R.id.view_space_top);
            View view_space_center=layout.findViewById(R.id.view_space_center);
            View line_space = layout.findViewById(R.id.line_space);

            // 设置顶部图标
            ImageView top_image = layout.findViewById(R.id.top_image);
            if (topImageId == 0) {
                top_image.setVisibility(View.GONE);
                line_space.setVisibility(View.VISIBLE);
            } else {
                top_image.setImageResource(topImageId);
                line_space.setVisibility(View.GONE);
            }

            // 设置标题
            TextView titleView = layout.findViewById(R.id.title);
            if (title == null) {
                titleView.setVisibility(View.GONE);
                line_space.setVisibility(View.GONE);
            } else {
                if (drawable != null) {
                    titleView.setCompoundDrawables(drawable, null, null, null);
                }
                titleView.setText(title);
            }

            // 设置内容
            TextView tv_content = layout.findViewById(R.id.tv_content);
            if (content == null && thirdTypeContent == null) {
                tv_content.setVisibility(View.GONE);
            } else {
                if (contentTextAlignment == View.TEXT_ALIGNMENT_TEXT_START || thirdTypeContentTextAlignment == View.TEXT_ALIGNMENT_TEXT_START){//左对齐
                    tv_content.setText(Html.fromHtml(content));
                }else {
                    if (content != null){
                        tv_content.setText(content);
                    }else {
                        tv_content.setText(thirdTypeContent);
                    }
                }
            }

            //设置内容文本对齐方式
            if (contentTextAlignment == 0 ||thirdTypeContentTextAlignment == 0) {
                tv_content.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            } else {
                tv_content.setTextAlignment(contentTextAlignment);
            }

            // 设置内容2
            TextView tv_second_type_content = layout.findViewById(R.id.tv_second_type_content);

            if (secondTypeContent == null) {
                tv_second_type_content.setVisibility(View.GONE);
                view_space_bottom.setVisibility(View.GONE);
                view_space_center.setVisibility(View.GONE);
                view_space_top.setVisibility(View.VISIBLE);
            } else {
                tv_second_type_content.setText(secondTypeContent);
                if (topImageId != 0){
                    view_space_bottom.setVisibility(View.VISIBLE);
                    view_space_center.setVisibility(View.VISIBLE);
                    view_space_top.setVisibility(View.GONE);
                }else {
                    view_space_bottom.setVisibility(View.VISIBLE);
                    view_space_center.setVisibility(View.GONE);
                    view_space_top.setVisibility(View.VISIBLE);
                }
            }

            //设置内容2文本对齐方式
            if (secondTypeContentTextAlignment == 0) {
                tv_content.setGravity(View.TEXT_ALIGNMENT_CENTER);
            } else {
                tv_content.setGravity(secondTypeContentTextAlignment);
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

            // 设置"取消"按钮
            TextView tv_cancel = (TextView) layout.findViewById(R.id.tv_cancel);
            if (TextUtils.isEmpty(negativeButtonText) || negativeButtonClickListener == null) {
                tv_cancel.setVisibility(View.GONE);
            } else {
                tv_cancel.setText(negativeButtonText);
                tv_cancel.setVisibility(View.VISIBLE);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        negativeButtonClickListener.onClick(dialog,DialogInterface.BUTTON_NEGATIVE);
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
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            win.setAttributes(lp);
            win.setGravity(gravity);
            dialog.setContentView(layout, params);
            dialog.setContentView(layout);
            dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
            return dialog;
        }
    }
}

