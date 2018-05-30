package com.af.smartfactorypad.ui.activity;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.presenter.BasePresenter;

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
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                IndexActivity.start(SplashActivity.this);
                SplashActivity.this.finish();
            }
        },2000);
    }
}
