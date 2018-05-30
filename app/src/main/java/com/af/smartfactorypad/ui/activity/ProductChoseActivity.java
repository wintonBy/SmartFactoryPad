package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.af.smartfactorypad.presenter.BasePresenter;

/**
 * @author: winton
 * @time: 2018/5/29 19:44
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 产品选择页
 */
public class ProductChoseActivity extends BaseActivity {

    /**
     * 进入详情页的方法
     * @param context
     */
    public static void start(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, ProductChoseActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
