package com.af.smartfactorypad.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author: winton
 * @time: 2018/6/13 14:18
 * @package: com.af.smartfactorypad.adapter
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 首页适配器
 */
class IndexViewPagerAdapter : FragmentPagerAdapter{

    var mSource:List<Fragment>

    constructor(fm:FragmentManager, mSource:List<Fragment>):super(fm){
        this.mSource = mSource

    }

    override fun getItem(position: Int): Fragment {
        return mSource[position]
    }

    override fun getCount(): Int {
        return mSource?.size?:0
    }
}