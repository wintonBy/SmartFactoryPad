package com.af.smartfactorypad.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.ButterKnife
import com.af.smartfactorypad.R
import kotlinx.android.synthetic.main.item_work_data.view.*

/**
 * @author: winton
 * @time: 2018/6/13 15:34
 * @package: com.af.smartfactorypad.adapter
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 生产页的适配器
 */
class WorkDataAdapter :IRVBaseAdapter<String,WorkDataAdapter.ViewHolder>{
    constructor(mContext: Context, mSource: List<String>) : super(mContext, mSource)


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.item_work_data,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = mSource[position]
        
    }

    class ViewHolder:RecyclerView.ViewHolder{
        var img:ImageView

        constructor(itemView: View):super(itemView){
            img = itemView.iv_img
        }
    }
}