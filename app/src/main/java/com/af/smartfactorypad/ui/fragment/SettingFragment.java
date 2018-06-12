package com.af.smartfactorypad.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.af.smartfactorypad.MyApplication;
import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.network.BaseSubscriber;
import com.af.smartfactorypad.network.RetrofitClient;
import com.af.smartfactorypad.network.response.BaseResponse;
import com.af.smartfactorypad.view.DialogEx;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/5 23:52
 * @package: com.sf.smartfactory.ui.fragment
 * @project: SmartFactory
 * @mail:
 * @describe: 设置页面
 */
public class SettingFragment extends BaseFragment{

    private DialogEx logoutDialog;
    TextView tvUpdateFrequency;
    /**
     * 获取该类的实例
     * @param params
     * @return
     */
    public static SettingFragment newInstance(Bundle params){
        SettingFragment instance = new SettingFragment();
        if(params != null){
            instance.setArguments(params);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_setting,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.tv_logout)
    public void clickLogout(View view){
        if(logoutDialog == null){
            logoutDialog = new DialogEx(getActivity(),"确认退出当前账号?",R.string.confirm,R.string.cancel){
                @Override
                public void confirm() {
                    doLogout();
                    cancel();
                }
            };
        }
        logoutDialog.show();
    }


    /**
     * 注销登录
     */
    private void doLogout(){
//        RetrofitClient.getInstance().logout(new BaseSubscriber<BaseResponse>(){
//
//            @Override
//            public void onSuccess(BaseResponse baseResponse) {
//                if(baseResponse.isSuccess()){
//                    cleanUserInfo();
//                    MyApplication.INSTANCE.toLogin();
//                    return;
//                }
//                ToastUtils.showShort("注销失败");
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                ToastUtils.showShort("注销失败");
//            }
//
//        });
    }

    /**
     * 注销登录时清除用户信息
     */
    private void cleanUserInfo(){
        SPUtils.getInstance().remove(Constant.SP_TOKEN);
        SPUtils.getInstance().remove(Constant.SP_USER_NAME);
        SPUtils.getInstance().remove(Constant.SP_USER_GENDER);
        SPUtils.getInstance().remove(Constant.SP_USER_PHONE);
        SPUtils.getInstance().remove(Constant.SP_USER_USERNAME);
        SPUtils.getInstance().remove(Constant.SP_PASSWORD);
        SPUtils.getInstance().put(Constant.SP_IS_FIRST_OPEN,true);
    }

}
