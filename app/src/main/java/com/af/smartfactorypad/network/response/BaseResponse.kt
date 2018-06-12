package com.af.smartfactorypad.network.response

import java.io.Serializable

/**
 * @author: winton
 * @time: 2018/6/12 12:56
 * @package: com.af.smartfactorypad.network.response
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 响应类基类
 */
open class BaseResponse:Serializable{
    val FAILED = 0
    val SUCCESS = 1

    var message: String? = null
    var result: Int = 0

    fun isSuccess(): Boolean {
        return result == SUCCESS
    }
}