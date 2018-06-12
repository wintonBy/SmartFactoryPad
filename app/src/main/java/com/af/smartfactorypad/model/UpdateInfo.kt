package com.af.smartfactorypad.model

import com.af.smartfactorypad.mvp.IModel

/**
 * @author: winton
 * @time: 2018/6/12 11:28
 * @package: com.af.smartfactorypad.model
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 升级信息
 */
class UpdateInfo:IModel{
    val force: Int = 0
    val id: Int = 0
    val url: String? = null
    val info: String? = null

    override fun toString(): String {
        return "UpdateInfo(force=$force, id=$id, url=$url, info=$info)"
    }


}