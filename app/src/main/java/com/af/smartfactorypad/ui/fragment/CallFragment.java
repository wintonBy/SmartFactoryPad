package com.af.smartfactorypad.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.model.Caller;
import com.zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/26 15:05
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 呼叫页
 */
public class CallFragment extends BaseFragment {

    @BindView(R.id.iv_my_code)
    ImageView mIVCode;
    @BindView(R.id.tv_title)
    TextView mTVTitle;


    private CallListDialog callListDialog;
    private List<Caller> mCallers;
    private int dialogId = -1;

    public static CallFragment newInstance(Bundle params){
        CallFragment fragment = new CallFragment();
        if(params != null){
            fragment.setArguments(params);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_call_service,null);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    private void initData(){
       mIVCode.post(new Runnable() {
           @Override
           public void run() {
               Bitmap codeImage = CodeUtils.createImage("12134",mIVCode.getHeight(),mIVCode.getHeight(),null);
               mIVCode.setImageBitmap(codeImage);
           }
       });
       mTVTitle.setText("呼叫");

    }

    @OnClick({R.id.call_manager,R.id.call_tech,R.id.call_logistics,R.id.call_quality,R.id.call_support})
    public void clickCall(View view){
        String sID = "";
        switch (view.getId()){
            case R.id.call_manager:
                break;
            case R.id.call_logistics:
                break;
            case R.id.call_tech:
                break;
            case R.id.call_support:
                break;
            case R.id.call_quality:
                break;
        }
        if(dialogId == view.getId()){
            showCallListDialog(sID,false);
        }else {
            showCallListDialog(sID,true);
            dialogId = view.getId();
        }

    }

    private void showCallListDialog(String id,boolean recreate){
        if(recreate){
            callListDialog = null;
            callListDialog = CallListDialog.createInstance(id);
        }else {
            if(callListDialog == null){
                callListDialog = CallListDialog.createInstance(id);
            }
        }
        callListDialog.show(getFragmentManager(),"callList");
    }


}
