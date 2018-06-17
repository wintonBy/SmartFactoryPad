package com.af.smartfactorypad.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.af.smartfactorypad.R
import com.af.smartfactorypad.model.Caller
import kotlinx.android.synthetic.main.item_caller.view.*

/**
 * @author: winton
 * @time: 2018/6/17 13:28
 * @package: com.af.smartfactorypad.adapter
 * @project: SmartFactoryPad
 * @mail:
 * @describe: Caller列表
 */
class CallerListAdapter:IRVBaseAdapter<Caller,CallerListAdapter.ViewHolder>{
    constructor(mContext: Context, mSource: List<Caller>) : super(mContext, mSource)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(mContext).inflate(R.layout.item_caller,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = mSource[position]
        holder.name.text = item.name
    }

    class ViewHolder:RecyclerView.ViewHolder{
        var name:TextView

        constructor(itemView: View):super(itemView){
            name = itemView.tv_name
        }


    }
}