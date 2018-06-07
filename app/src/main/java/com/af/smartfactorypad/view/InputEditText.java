package com.af.smartfactorypad.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.af.smartfactorypad.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: winton
 * @time: 2018/5/28 21:46
 * @package: com.af.smartfactorypad.view
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 输入框组件
 */
public class InputEditText extends LinearLayout {

    private List<TextView> mInputs;

    private int inputNum = 6;

    private int editSize = 100;

    private int textColor = Color.BLACK;

    private int textSize = 16;

    private char[] codes;

    private int currentIndex = 0;

    private InputListener mListener;

    public InputEditText(Context context) {
        this(context,null);
    }

    public InputEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public InputEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER_VERTICAL);
        mInputs = new ArrayList<>();
        codes = new char[inputNum];
        initInput();
    }

    private void initInput(){
        mInputs.clear();
        for(int i = 0;i<inputNum;i++){
            TextView et = new TextView(getContext());
            LayoutParams lp  = new LayoutParams(editSize,editSize);
            lp.leftMargin = 20;
            lp.rightMargin = 20;
            mInputs.add(et);
            et.setTextSize(textSize);
            et.setTextColor(textColor);
            et.setGravity(Gravity.CENTER);
            et.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_sign_input_bg));
            this.addView(et,lp);
        }
    }

    /**
     * 输入字符
     * @param num
     */
    public void input(char num){
        if(currentIndex>= inputNum){
            //超出长度不接受输入
            return;
        }else if(currentIndex  == inputNum -1){
            //当前位置是最后一个位置
            mInputs.get(currentIndex).setText(num+"");
            currentIndex ++;
            if(mListener != null){
                mListener.onInputOver();
            }
        }else {
            mInputs.get(currentIndex).setText(num+"");
            currentIndex++;
        }
    }

    /**
     * 删除输入
     */
    public void delete(){
        if(currentIndex == 0){
            //第一个位置不接收删除
            return;
        }
        currentIndex--;
        mInputs.get(currentIndex).setText("");
    }

    /**
     * 获取输入的内容
     * @return
     */
    public String getCodes(){
        StringBuilder codes = new StringBuilder();
        for(TextView tv: mInputs){
           codes.append(tv.getText());
        }
        return codes.toString();
    }


    public interface InputListener{
        /**
         * 输入完毕
         */
        void onInputOver();
    }


}
