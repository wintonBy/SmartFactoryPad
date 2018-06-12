package com.af.smartfactorypad.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.af.smartfactorypad.BuildConfig;
import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.model.UpdateInfo;
import com.af.smartfactorypad.network.BaseSubscriber;
import com.af.smartfactorypad.network.response.UpdateInfoResponse;
import com.af.smartfactorypad.view.DialogEx;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/2 23:54
 * @package: com.sf.smartfactory.ui.fragment
 * @project: SmartFactory
 * @mail:
 * @describe: 版本信息页
 */
public class VersionFragment extends BaseFragment {

    @BindView(R.id.tv_app_version)
    TextView tvVersion;
    private DialogEx mDialog = null;
    private UpdateApkDialog updateFragment;

    /**
     * 获取该类的实例
     * @param params
     * @return
     */
    public static VersionFragment newInstance(Bundle params){
        VersionFragment instance = new VersionFragment();
        if(params != null){
            instance.setArguments(params);
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_version_info,null);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }
    protected void initData() {
        tvVersion.setText(String.format(getResources().getString(R.string.version_p), BuildConfig.VERSION_NAME));
    }

    @OnClick(R.id.tv_call)
    public void clickCall(View view){
        if (mDialog != null) {
            mDialog.show();
            return;
        }
        mDialog = new DialogEx(getActivity(), getString(R.string.call_service), R.string.confirm,
                R.string.cancel) {
            @Override
            public void confirm() {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.call_num)));
                startActivity(intent);
                cancel();
            }
        };
    }

    @OnClick(R.id.check_update)
    public void clickCheckUpdate(View view){
        UpdateInfoResponse.Companion.loadUpdateInfo(new BaseSubscriber<UpdateInfoResponse>(){

            @Override
            public void onSuccess(UpdateInfoResponse updateInfoResponse) {
                if(!updateInfoResponse.isSuccess()){
                    LogUtils.eTag(TAG,updateInfoResponse.getMessage());
                    return;
                }
                if(hasNewVersion(updateInfoResponse.getData())){
                    showNewVersion(updateInfoResponse.getData());
                }else {
                    ToastUtils.showLong("当前已是最新版本");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    public void showNewVersion(UpdateInfo info) {
        if(updateFragment == null){
            String title = "新版本";
            String url = info.getUrl();
            String sInfo = info.getInfo();
            int force = info.getForce();
            Bundle param = new Bundle();
            param.putString("title",title);
            param.putString("downloadUrl",url);
            param.putString("info",sInfo);
            param.putInt("force",force);
            updateFragment = UpdateApkDialog.createInstance(param);
        }
        updateFragment.show(getActivity().getSupportFragmentManager(),"update");
    }

    /**
     * 判断是否有新版本
     * @param info
     * @return
     */
    private boolean hasNewVersion(UpdateInfo info){
        boolean result = false;
        if(info == null){
            return result;
        }
        int newVersion = info.getId();
        if(newVersion > Constant.VERSION_CODE){
            result = true;
        }
        return result;
    }

}
