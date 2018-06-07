package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.af.smartfactorypad.ui.fragment.CallFragment;
import com.af.smartfactorypad.ui.fragment.DeviceFragment;
import com.af.smartfactorypad.ui.fragment.SignInFragment;
import com.af.smartfactorypad.ui.fragment.WorkDataFragment;
import com.blankj.utilcode.util.TimeUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: winton
 * @time: 2018/5/26 14:29
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 应用首页
 */
public class IndexActivity extends BaseActivity {

    @BindView(R.id.rg)
    RadioGroup mRG;

    static UIHandler mUIHandler;
    private FragmentManager fm;
    private List<Fragment> fragments;

    static class UIHandlerId{
        public static final int UPDATE_TIME = 0x0001;
    }

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
        setContentView(R.layout.act_index);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_sign:
                        changeFragment(0);
                        break;
                    case R.id.rb_work:
                        changeFragment(1);
                        break;
                    case R.id.rb_device:
                        changeFragment(2);
                        break;
                    case R.id.rb_call:
                        changeFragment(3);
                        break;
                }
            }
        });
    }

    private void changeFragment(int index){
      FragmentTransaction ft = fm.beginTransaction();
      ft.replace(R.id.fl_content,fragments.get(index));
      ft.commit();
    }




    @Override
    protected void initData() {
        super.initData();
        mUIHandler = new UIHandler(this);
        fragments = new ArrayList<>();
        fragments.add(SignInFragment.newInstance(null));
        fragments.add(WorkDataFragment.newInstance(null));
        fragments.add(DeviceFragment.newInstance(null));
        fragments.add(CallFragment.newInstance(null));
        mRG.check(R.id.rb_sign);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUIHandler = null;
    }

    private static class UIHandler extends Handler{

        private WeakReference<IndexActivity> mActivity;

        public UIHandler(IndexActivity activity){
            mActivity = new WeakReference<IndexActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
