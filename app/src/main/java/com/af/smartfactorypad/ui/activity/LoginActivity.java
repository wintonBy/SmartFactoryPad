package com.af.smartfactorypad.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.contract.LoginContract;
import com.af.smartfactorypad.presenter.LoginPresenter;
import com.af.smartfactorypad.view.DialogEx;
import com.af.smartfactorypad.view.LoadingDialog;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SnackbarUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: winton
 * @time: 2018/6/11 22:16
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 登录页
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_username)
    EditText mETUsername;
    @BindView(R.id.et_password)
    EditText mETPassword;

    private  final int REQ_STORAGE = 0x0001;
    private LoadingDialog mLoading;

    /**
     * 启动登录页
     * @param context
     */
    public static void start(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
    }

    @Override
    protected LoginPresenter loadPresenter() {
        return new LoginPresenter();
    }

    @OnClick(R.id.bt_login)
    public void clickLogin(View view){
        if(mPresenter != null){
            mPresenter.doLogin();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        String userName = SPUtils.getInstance().getString(Constant.SP_USER_USERNAME);
        String password = SPUtils.getInstance().getString(Constant.SP_PASSWORD);
        if(!StringUtils.isTrimEmpty(userName)){
            mETUsername.setText(userName);
            if(!StringUtils.isTrimEmpty(password)){
                mETPassword.setText(password);
            }
        }
        checkStoragePermission();
    }

    @Override
    public void showLoading(boolean show) {
        if(show){
            if(mLoading == null){
                mLoading = new LoadingDialog(this);
            }
            mLoading.show();

        }else {
            if(mLoading != null && mLoading.isShowing()){
                mLoading.dismiss();
            }
        }
    }

    @Override
    public void doLoginSuccess() {
        IndexActivity.start(this);
        finish();
    }

    @Override
    public String getUsername() {
        if(mETUsername != null){
            return mETUsername.getText().toString();
        }
        return null;
    }

    @Override
    public String getPassword() {
        if(mETPassword != null){
            return mETPassword.getText().toString();
        }
        return null;
    }

    @Override
    public void showError(String msg) {
        if(StringUtils.isTrimEmpty(msg)){
            return;
        }
        SnackbarUtils.with(getWindow().getDecorView()).setMessage(msg).showError();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode ){
            case REQ_STORAGE:
                if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
                    checkStoragePermission();
                }
                break;
        }
    }

    /**
     * 程序必须保证存储权限 否则无法升级
     */
    public void checkStoragePermission(){
        int storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(storagePermission == PackageManager.PERMISSION_GRANTED){
            return;
        }
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            showError("拒绝存储权限将导致不可预知的错误！");
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQ_STORAGE);
        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQ_STORAGE);
        }
    }
}
