package com.af.smartfactorypad.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.ui.activity.ScanActivity;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/26 15:03
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 打卡签到页
 */
public class SignInFragment extends BaseFragment{

    @BindView(R.id.bt_sign)
    Button mBTSign;

    private static final int REQ_BIND = 0x0001;

    public static SignInFragment newInstance(Bundle params){
        SignInFragment fragment = new SignInFragment();
        if(params != null){
            fragment.setArguments(params);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_signin,null);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    @OnClick(R.id.bt_sign)
    public void clickSign(View v){
        Intent intent = new Intent(getContext(),ScanActivity.class);
        startActivityForResult(intent, REQ_BIND);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_BIND && resultCode == Activity.RESULT_OK){
            String str = data.getStringExtra(CodeUtils.RESULT_STRING);
            ToastUtils.showShort(str);
        }
    }

    /**
     * 加载数据
     */
    private void initData(){

    }


}
