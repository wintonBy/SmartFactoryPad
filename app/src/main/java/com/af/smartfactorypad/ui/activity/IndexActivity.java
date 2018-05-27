package com.af.smartfactorypad.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.blankj.utilcode.util.TimeUtils;

import java.lang.ref.WeakReference;
import java.util.Date;

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

    @BindView(R.id.tv_date)
    TextView mTVDate;
    @BindView(R.id.tv_time)
    TextView mTVTime;
    static UIHandler mUIHandler;

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
    }

    @Override
    protected void initData() {
        super.initData();
        mUIHandler = new UIHandler(this);
        ((TextView)findViewById(R.id.tv_date)).setText(TimeUtils.getString(new Date(), Constant.DATE_FORMAT ,0,0));
        updateTime();
    }

    private void updateTime(){
        mTVDate.setText(TimeUtils.getString(System.currentTimeMillis(), Constant.DATE_FORMAT ,0,0));
        mTVTime.setText(TimeUtils.getString(System.currentTimeMillis(),Constant.TIME_FORMAT,0,0));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mUIHandler.sendEmptyMessageDelayed(UIHandlerId.UPDATE_TIME,1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mUIHandler.removeMessages(UIHandlerId.UPDATE_TIME);
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
            switch (msg.what){
                case UIHandlerId.UPDATE_TIME:
                    mActivity.get().updateTime();
                    mUIHandler.sendEmptyMessageDelayed(UIHandlerId.UPDATE_TIME,1000);
                    break;
            }
            super.handleMessage(msg);
        }
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
