package com.af.smartfactorypad.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.zxing.activity.CaptureFragment;
import com.zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/6/9 22:20
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 二维码扫描页
 */
public class ScanActivity extends BaseActivity {

    private CaptureFragment captureFragment;
    @BindView(R.id.bt_light_switch)
    Button mBTSwitch;

    private boolean isOpenLight;

    /**
     * 启动扫码页
     * @param context
     * @param requestCode
     * @param params
     */
    public static void start(Activity context, int requestCode, Bundle params){
        Intent intent = new Intent(context,ScanActivity.class);
        intent.putExtras(params);
        context.startActivityForResult(intent,requestCode);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.act_scan);
        ButterKnife.bind(this);
        findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iv_back)
    public void clickBack(View v){
        this.finish();
    }

    @OnClick(R.id.bt_light_switch)
    public void clickLightSwitch(View v){
        if(isOpenLight){
            CodeUtils.isLightEnable(false);
            isOpenLight = false;
            mBTSwitch.setBackground(getResources().getDrawable(R.mipmap.ic_light_off));
        }else {
            CodeUtils.isLightEnable(true);
            mBTSwitch.setBackground(getResources().getDrawable(R.mipmap.ic_light_open));
            isOpenLight = true;
        }
    }

    @Override
    protected void initData() {
        super.initData();
        captureFragment = new CaptureFragment();
        CodeUtils.setFragmentArgs(captureFragment,R.layout.layout_scan);
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container,captureFragment).commit();
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            ScanActivity.this.setResult(RESULT_OK, resultIntent);
            ScanActivity.this.finish();
        }
    };
}
