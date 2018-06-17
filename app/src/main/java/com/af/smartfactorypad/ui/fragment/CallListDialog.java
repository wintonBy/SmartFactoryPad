package com.af.smartfactorypad.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.adapter.CallerListAdapter;
import com.af.smartfactorypad.contract.LoginContract;
import com.af.smartfactorypad.model.Caller;
import com.af.smartfactorypad.network.BaseSubscriber;
import com.af.smartfactorypad.network.response.CallerResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: winton
 * @time: 2018/6/17 11:43
 * @package: com.af.smartfactorypad.ui.fragment
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 呼叫列表
 */
public class CallListDialog extends DialogFragment{

    @BindView(R.id.rv)
    RecyclerView mRV;

    private CallerListAdapter mAdapter;

    public static CallListDialog createInstance(String id){
        CallListDialog instance = new CallListDialog();
        Bundle params = new Bundle();
        params.putString("id",id);
        instance.setArguments(params);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NO_TITLE;
        int theme =android.R.style.Theme_Holo_Light_Dialog;
        setStyle(style,theme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.layout_call_list_dialog,null);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    private void initData(){
        String id = getArguments().getString("id");
        Caller.Companion.loadCallers(id, new BaseSubscriber<CallerResponse>() {
            @Override
            public void onSuccess(CallerResponse callerResponse) {
                mAdapter = new CallerListAdapter(getContext(),callerResponse.getData());
                mRV.setLayoutManager(new LinearLayoutManager(getContext()));
                mRV.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

}
