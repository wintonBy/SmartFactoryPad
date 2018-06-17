package com.af.smartfactorypad.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * @author: winton
 * @time: 2018/6/13 15:21
 * @package: com.af.smartfactorypad.adapter
 * @project: SmartFactoryPad
 * @mail:
 * @describe: RecyclerView的适配器基类
 */
open  abstract class IRVBaseAdapter<S,T:RecyclerView.ViewHolder>:RecyclerView.Adapter<T>{
    var mContext:Context
    var mSource:List<S>

    constructor(mContext: Context, mSource: List<S>) : super() {
        this.mContext = mContext
        this.mSource = mSource
    }

    abstract override  fun onCreateViewHolder(parent: ViewGroup?, viewType: Int):T

    override fun getItemCount() = mSource?.size?:0

    abstract override fun onBindViewHolder(holder: T, position: Int)
}