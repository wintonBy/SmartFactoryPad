package com.af.smartfactorypad.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.af.smartfactorypad.MyApplication;
import com.af.smartfactorypad.R;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.blankj.utilcode.util.PermissionUtils;

/**
 * @author: winton
 * @time: 2018/5/26 14:25
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 启动页
 */
public class SplashActivity extends BaseActivity {



    @Override
    protected void initView() {
        setContentView(R.layout.act_splash);
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        toNextView();
    }

    private void toNextView(){
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginActivity.start(SplashActivity.this);
                SplashActivity.this.finish();
            }
        },2000);
    }
}
