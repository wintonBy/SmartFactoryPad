package com.af.smartfactorypad.ui.activity;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.presenter.BasePresenter;

/**
 * @author: winton
 * @time: 2018/6/9 22:20
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 二维码扫描页
 */
public class ScanActivity extends BaseActivity {

    @Override
    protected void initView() {
        setContentView(R.layout.act_scan);
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
