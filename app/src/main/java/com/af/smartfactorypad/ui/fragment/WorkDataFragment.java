package com.af.smartfactorypad.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.af.smartfactorypad.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: winton
 * @time: 2018/5/26 15:04
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 工况页
 */
public class WorkDataFragment extends BaseFragment {

    @BindView(R.id.tv_title)
    TextView mTVTitle;

    public static WorkDataFragment newInstance(Bundle params){
        WorkDataFragment fragment = new WorkDataFragment();
        if(params != null){
            fragment.setArguments(params);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_work_data,null);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    private void initData(){
        mTVTitle.setText("生产");
    }
}
