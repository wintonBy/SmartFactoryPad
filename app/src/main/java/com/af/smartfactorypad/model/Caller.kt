package com.af.smartfactorypad.model

import com.af.smartfactorypad.mvp.IModel
import com.af.smartfactorypad.network.BaseSubscriber
import com.af.smartfactorypad.network.response.CallerResponse

/**
 * @author: winton
 * @time: 2018/6/17 13:11
 * @package: com.af.smartfactorypad.model
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 可以呼叫的对象
 */

class Caller:IModel{
    var name:String =""
    var number:String = ""

    constructor(name:String,number:String){
        this.name = name
        this.number = number
    }


    companion object {
        fun loadCallers(id:String,subscriber:BaseSubscriber<CallerResponse>){
            var response = CallerResponse()
            response.result = response.SUCCESS
            response.data = listOf(Caller("张三","15158035536"),
                    Caller("李四","15158064459"))
            response.data
            subscriber.onSuccess(response)
        }
    }

    override fun toString(): String {
        return "Caller(name='$name', number='$number')"
    }




}