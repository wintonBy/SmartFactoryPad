package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.constant.Constant;
import com.af.smartfactorypad.contract.LoginContract;
import com.af.smartfactorypad.presenter.LoginPresenter;
import com.af.smartfactorypad.view.LoadingDialog;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SnackbarUtils;
import com.blankj.utilcode.util.StringUtils;

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
}
