package com.af.smartfactorypad.constant

import java.text.SimpleDateFormat

/**
 * @author: winton
 * @time: 2018/5/26 22:26
 * @package: com.af.smartfactorypad.constant
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 常量类
 */
object Constant{
    @JvmField  val  DATE_FORMAT = SimpleDateFormat("yyyy年MM月dd日");

    @JvmField val TIME_FORMAT = SimpleDateFormat("HH:mm:ss");

    @JvmField val SP_TOKEN = "token"
    @JvmField val SP_USER_NAME = "name"
    @JvmField val SP_USER_GENDER = "gender"
    @JvmField val SP_USER_PHONE = "phone"
    @JvmField val SP_USER_USERNAME = "username"
    @JvmField val SP_USER_IMG = "user_img"
    @JvmField val SP_PASSWORD = "password"
    @JvmField val SP_IS_FIRST_OPEN = "first_open"

    /*统一的版本号*/
    @JvmField val VERSION_CODE = 20180502
    @JvmField val APK_DOWNLOAD_NAME = "release.apk"
}