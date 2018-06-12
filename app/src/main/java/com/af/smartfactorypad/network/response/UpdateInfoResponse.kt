package com.af.smartfactorypad.network.response

import com.af.smartfactorypad.model.UpdateInfo
import com.af.smartfactorypad.network.BaseSubscriber

/**
 * @author: winton
 * @time: 2018/6/12 12:53
 * @package: com.af.smartfactorypad.network.response
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 升级响应基类
 */
class UpdateInfoResponse : BaseResponse(){

    var data:UpdateInfo? = null

    companion object {
        fun loadUpdateInfo(subscriber: BaseSubscriber<UpdateInfoResponse>){

        }
    }

}