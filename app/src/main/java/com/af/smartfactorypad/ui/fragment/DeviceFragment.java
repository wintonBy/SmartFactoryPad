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
 * @time: 2018/5/26 15:05
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 设备页
 */
public class DeviceFragment extends BaseFragment {

    public static DeviceFragment newInstance(Bundle params){
        DeviceFragment fragment = new DeviceFragment();
        if(params != null){
            fragment.setArguments(params);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_device,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
