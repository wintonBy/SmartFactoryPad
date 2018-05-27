package com.af.smartfactorypad.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.af.smartfactorypad.R;

import butterknife.ButterKnife;

/**
 * @author: winton
 * @time: 2018/5/26 15:03
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 打卡签到页
 */
public class SignInFragment extends BaseFragment{

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
        return view;
    }

}
