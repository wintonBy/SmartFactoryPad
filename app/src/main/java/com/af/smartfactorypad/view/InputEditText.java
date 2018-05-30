package com.af.smartfactorypad.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

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

    private List<EditText> mInputs;

    private int inputNum = 6;

    private int editSize = 100;

    private int hintTextColor = Color.BLACK;

    private int textColor = Color.BLACK;

    private int textSize = 16;


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
        initInput();
    }

    private void initInput(){
        mInputs.clear();
        for(int i = 0;i<inputNum;i++){
            EditText et = new EditText(getContext());
            LayoutParams lp  = new LayoutParams(editSize,editSize);
            lp.leftMargin = 10;
            lp.rightMargin = 10;
            mInputs.add(et);
            et.setHint("-");
            et.setTextSize(textSize);
            et.setTextColor(textColor);
            et.setGravity(Gravity.CENTER);
            et.setHintTextColor(hintTextColor);
            et.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_sign_input_bg));
            this.addView(et,lp);
        }
    }


}
