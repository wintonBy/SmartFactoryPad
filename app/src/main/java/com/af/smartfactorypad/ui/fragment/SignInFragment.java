package com.af.smartfactorypad.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.af.smartfactorypad.R;

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

    @BindView(R.id.tv_work_num)
    TextView mTVWorkNum;
    @BindView(R.id.tv_worker_name)
    TextView mTVWorkerName;
    @BindView(R.id.tv_worker_num)
    TextView mTVWorkerNum;
    @BindView(R.id.tv_work_over_time)
    TextView mTVWorkOverTime;
    @BindView(R.id.bt_sign)
    Button mBTSign;

    private WorkNumInputFragment workNumDialog;

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
        if(workNumDialog == null){
            workNumDialog = new WorkNumInputFragment();
        }
        workNumDialog.show(getFragmentManager(),"workNumDialog");
    }

    /**
     * 加载数据
     */
    private void initData(){

    }


}
