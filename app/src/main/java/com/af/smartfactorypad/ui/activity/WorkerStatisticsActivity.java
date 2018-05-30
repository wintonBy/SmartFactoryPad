package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.af.smartfactorypad.presenter.BasePresenter;

/**
 * @author: winton
 * @time: 2018/5/29 19:43
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 员工统计页面
 */
public class WorkerStatisticsActivity extends BaseActivity{

    /**
     * 进入详情页的方法
     * @param context
     */
    public static void start(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, WorkerStatisticsActivity.class);
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
