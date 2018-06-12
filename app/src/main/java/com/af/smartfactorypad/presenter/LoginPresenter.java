package com.af.smartfactorypad.presenter;

import com.af.smartfactorypad.contract.LoginContract;
import com.af.smartfactorypad.ui.activity.LoginActivity;

/**
 * @author: winton
 * @time: 2018/6/11 22:16
 * @package: com.af.smartfactorypad.presenter
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 登录Presenter
 */
public class LoginPresenter extends BasePresenter<LoginActivity> implements LoginContract.Presenter {
    @Override
    public void doLogin() {
        getView().doLoginSuccess();
    }
}
