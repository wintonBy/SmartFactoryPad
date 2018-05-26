package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.af.smartfactorypad.presenter.BasePresenter;

/**
 * @author: winton
 * @time: 2018/5/26 14:29
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 应用首页
 */
public class IndexActivity extends BaseActivity {

    /**
     * 进入详情页的方法
     * @param context
     */
    public static void start(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, IndexActivity.class);
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
