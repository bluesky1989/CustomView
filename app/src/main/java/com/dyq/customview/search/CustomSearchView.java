package com.dyq.customview.search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dyq.customview.R;

/**
 * author:duyongqiang
 * mail: duyongqiang09@126.com
 * date:2022/7/26
 * Description:
 */
public class CustomSearchView extends LinearLayout implements View.OnClickListener {

    private EditText etInput;
    private ImageView iv_back;
    private ImageView iv_search_icon;
    private TextView tv_cancel;
    private LinearLayout ll_search;
    private View view_line_bg;
    private View view_line_space;
    private Context mContext;
    private boolean isCanDirectSearch;

    private BeforeTextChangedListener beforeTextChangedListener;
    private OnTextChangedListener onTextChangedListener;
    private AfterTextChangedListener afterTextChangedListener;
    private SearchListener searchListener;
    private BackListener backListener;
    private CancelListener cancelListener;
    private EditTextClickListener editTextClickListener;

    /**
     * 设置 默认输入显示内容
     * @param hintText
     */
    public void setHintText(String hintText){
        if (hintText != null){
            etInput.setHint(hintText);
        }
    }

    /**
     * 是否直接在当前界面搜索(只对带左边返回按钮的样式生效)
     * @param isCanDirectSearch
     */
    public void setIsCanDirectSearch(boolean isCanDirectSearch){
        this.isCanDirectSearch=isCanDirectSearch;
        updateViewDisplay();
    }

    /**
     * 设置输入前调接口
     *
     * @param beforeTextChangedListener
     */
    public void setOnBeforeTextChanged(BeforeTextChangedListener beforeTextChangedListener) {
        this.beforeTextChangedListener = beforeTextChangedListener;
    }

    /**
     * 设置输入中调接口
     *
     * @param onTextChangedListener
     */
    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.onTextChangedListener = onTextChangedListener;
    }

    /**
     * 设置输入完成调接口
     *
     * @param afterTextChangedListener
     */
    public void setOnAfterTextChanged(AfterTextChangedListener afterTextChangedListener) {
        this.afterTextChangedListener = afterTextChangedListener;
    }

    /**
     * 设置 搜索 回调接口
     * @param searchListener
     */
    public void setOnSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }
    /**
     * 设置 返回 回调接口
     * @param backListener
     */
    public void setOnBackListener(BackListener backListener) {
        this.backListener = backListener;
        iv_back.setVisibility(View.VISIBLE);
        updateViewDisplay();
    }

    /**
     * 设置 取消 回调接口
     * @param cancelListener
     */
    public void setOnCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
        iv_back.setVisibility(View.GONE);
        updateViewDisplay();
    }

    /**
     * 设置 输入框 点击回调接口
     * @param editTextClickListener
     */
    public void setOnEditTextClickListener(EditTextClickListener editTextClickListener) {
        this.editTextClickListener = editTextClickListener;
    }

    public CustomSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.search_layout, this);
        initViews();
    }

    private void initViews() {
        ll_search = findViewById(R.id.ll_search);
        etInput = findViewById(R.id.search_et_input);
        iv_back = findViewById(R.id.iv_back);
        iv_search_icon = findViewById(R.id.iv_search_icon);
        tv_cancel = findViewById(R.id.tv_cancel);
        view_line_bg = findViewById(R.id.view_line_bg);
        view_line_space = findViewById(R.id.view_line_space);
    }

    /**
     * 点击键盘 搜索 按钮 开始搜索
     *
     * @param inputSearchText 输入的文本
     */
    private void notifyStartSearching(String inputSearchText) {
        if (searchListener != null) {
            searchListener.onSearch(inputSearchText);
        }
        hideKeyboard();
    }

    /**
     * 隐藏软键盘
     */
    private void  hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 更新自定义搜索框中控件的显示
     */
    private void updateViewDisplay(){
        if (iv_back.getVisibility() == View.VISIBLE){//左边返回按钮的样式
            tv_cancel.setVisibility(View.GONE);
            view_line_bg.setVisibility(View.GONE);
            view_line_space.setVisibility(View.GONE);
            ll_search.setBackground(getResources().getDrawable(R.drawable.shape_bg_search_edit));
            iv_search_icon.setBackground(getResources().getDrawable(R.mipmap.search_icon));
            iv_back.setOnClickListener(this);
            if (isCanDirectSearch){
                editTextSetting();
            }else {
                etInput.setFocusable(false);
                etInput.setOnClickListener(this);
            }
        }else {//右边取消文字按钮的样式
            tv_cancel.setVisibility(View.VISIBLE);
            view_line_bg.setVisibility(View.VISIBLE);
            view_line_space.setVisibility(View.VISIBLE);
            ll_search.setBackground(null);
            iv_search_icon.setBackground(getResources().getDrawable(R.mipmap.weight_color_search_icon));
            tv_cancel.setOnClickListener(this);
            editTextSetting();
        }
    }

    /**
     * 输入框的设置
     */
    private void editTextSetting(){
        //自动获取焦点显示光标
        etInput.setFocusable(true);
        etInput.setFocusableInTouchMode(true);
        etInput.requestFocus();
        etInput.addTextChangedListener(new EditChangedListener());
        etInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    notifyStartSearching(etInput.getText().toString());
                }
                return true;
            }
        });
    }

    private class EditChangedListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (beforeTextChangedListener != null) {
                beforeTextChangedListener.beforeTextChanged(charSequence);
            }
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (onTextChangedListener != null) {
                onTextChangedListener.onTextChanged(charSequence);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (afterTextChangedListener != null) {
                afterTextChangedListener.afterTextChanged(editable);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel://取消
                if (cancelListener != null) {
                    cancelListener.onCancel();
                }
                break;
            case R.id.iv_back://返回
                if (backListener != null) {
                    backListener.onGoBack();
                }
                break;
            case R.id.search_et_input://搜索框
                if (editTextClickListener != null){
                    editTextClickListener.onEditTextClickListener();
                }
                break;
        }
    }


    /**
     * 搜索 事件监听
     */
    public interface SearchListener {
        void onSearch(String inputSearchText);
    }

    /**
     * 输入框输入前 事件监听
     */
    public interface BeforeTextChangedListener {
        void beforeTextChanged(CharSequence charSequence);
    }

    /**
     * 输入框输入中 事件监听
     */
    public interface OnTextChangedListener {
        void onTextChanged(CharSequence charSequence);
    }

    /**
     * 输入框输入完成 事件监听
     */
    public interface AfterTextChangedListener {
        void afterTextChanged(Editable editable);
    }

    /**
     * 返回 事件监听
     */
    public interface BackListener {
        void onGoBack();
    }

    /**
     * 取消 事件监听
     */
    public interface CancelListener {
        void onCancel();
    }

    /**
     * 输入框点击事件监听
     */
    public interface EditTextClickListener {
        void onEditTextClickListener();
    }

}
