package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;


import com.af.smartfactorypad.R;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.af.smartfactorypad.ui.fragment.CompanyInfoFragment;
import com.af.smartfactorypad.ui.fragment.DeveloperInfoFragment;
import com.af.smartfactorypad.ui.fragment.SettingFragment;
import com.af.smartfactorypad.ui.fragment.VersionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/5/2 23:15
 * @package: com.sf.smartfactory.ui.activity
 * @project: SmartFactory
 * @mail:
 * @describe: 一些公共页面的Activity，布局只有title加fragment
 */
public class CommonActivity extends BaseActivity {

    public final static int FT_DEVELOP_INFO = 0x01;
    public final static int FT_VERSION_INFO = 0x02;
    public final static int FT_SETTING = 0x03;
    public final static int FT_COMPANY_INFO = 0x04;

    @BindView(R.id.tv_title)
    TextView mTVTitle;

    private String title;
    private int fragmentType;

    /**
     *
     * @param context
     * @param title
     * @param type
     */
    public static void start(Context context, @NonNull String title, int type) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, CommonActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }


    @Override
    protected void initView() {
        setContentView(R.layout.act_common);
        ButterKnife.bind(this);
        findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData() {
        super.initData();
        title = getIntent().getStringExtra("title");
        fragmentType = getIntent().getIntExtra("type",-1);
        mTVTitle.setText(title);
        Fragment fragment = getFragment(fragmentType);
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,fragment).commit();
        }
    }


    private Fragment getFragment(int type){
        switch (type){
            case FT_DEVELOP_INFO:
                return DeveloperInfoFragment.newInstance(null);
            case FT_VERSION_INFO:
                return VersionFragment.newInstance(null);
            case FT_SETTING:
                return SettingFragment.newInstance(null);
            case FT_COMPANY_INFO:
                return CompanyInfoFragment.newInstance(null);
        }
        return null;
    }

    @OnClick(R.id.iv_back)
    public void clickBack(View view){
        this.finish();
    }


    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
