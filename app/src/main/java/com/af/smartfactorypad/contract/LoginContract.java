package com.af.smartfactorypad.contract;

/**
 * @author: winton
 * @time: 2018/6/11 22:08
 * @package: com.af.smartfactorypad.contract
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 登录页协议
 */
public interface LoginContract {

    interface View{
        /**
         * 控制Loading的显示
         * @param show
         */
        void showLoading(boolean show);

        /**
         * 登录成功之后View要做的事情
         */
        void doLoginSuccess();

        /**
         * 获取用户名
         * @return
         */
        String getUsername();

        /**
         * 获取密码
         * @return
         */
        String getPassword();

        /**
         * 显示错误信息
         * @param msg
         */
        void showError(String msg);
    }

    interface Presenter{
        /**
         * 执行登录
         */
        void doLogin();
    }
}
