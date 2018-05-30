package com.af.smartfactorypad.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.af.smartfactorypad.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/28 21:25
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 一句话描述
 */
public class WorkNumInputFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getContext(),R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_input_worker_num);
        dialog.setCanceledOnTouchOutside(false);

        // 设置宽度为屏宽, 靠近屏幕底部。
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        // 紧贴底部
        lp.gravity = Gravity.BOTTOM;
        // 宽度持平
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        ButterKnife.bind(this,dialog);
        return dialog;
    }

    @OnClick(R.id.num_1)
    public void clickOne(){

    }
    @OnClick(R.id.num_2)
    public void clickTwo(){

    }
    @OnClick(R.id.num_3)
    public void clickThree(){

    }
    @OnClick(R.id.num_4)
    public void clickFour(){

    }
    @OnClick(R.id.num_5)
    public void clickFive(){

    }
    @OnClick(R.id.num_6)
    public void clickSix(){

    }
    @OnClick(R.id.num_7)
    public void clickSeven(){

    }
    @OnClick(R.id.num_8)
    public void clickEight(){

    }
    @OnClick(R.id.num_9)
    public void clickNine(){

    }
    @OnClick(R.id.num_0)
    public void clickZero(){

    }

    public void clickConfirm(){

    }

}
