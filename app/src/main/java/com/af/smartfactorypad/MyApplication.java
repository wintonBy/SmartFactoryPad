package com.af.smartfactorypad;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import com.af.smartfactorypad.aspectj.annotation.DebugTrace;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.zxing.activity.ZXingLibrary;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winton on 2017/6/25.
 */

public class MyApplication extends Application {

    public static MyApplication INSTANCE;

    private List<WeakReference<Activity>> mActivitys;

    public static PermissionUtils permissionInstance;

    @DebugTrace
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initUtils();
        initPermission();
        ZXingLibrary.initDisplayOpinion(this);
    }

    /**
     * 初始化工具类
     */
    @DebugTrace
    private void initUtils(){
        /*初始化工具类*/
        Utils.init(this);
    }

    public void addActivity(@NonNull WeakReference<Activity> activity){
        if(mActivitys == null){
            mActivitys = new ArrayList<>();
        }
        mActivitys.add(activity);
    }

    public void removeActivity(@NonNull WeakReference<Activity> activity){
        if(mActivitys == null){
            return;
        }
        if(mActivitys.contains(activity)){
            mActivitys.remove(activity);
        }
    }

    /**
     * 初始化程序需要的权限
     */
    private void initPermission(){
        permissionInstance = PermissionUtils.permission(Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.VIBRATE);
    }

    /**
     * 安全退出应用
     */
    public void exit(){
        if(mActivitys != null){
            for (WeakReference<Activity> activityWeakReference : mActivitys){
                activityWeakReference.get().finish();
            }
        }
    }

}
