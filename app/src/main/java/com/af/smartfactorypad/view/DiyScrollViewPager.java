package com.af.smartfactorypad.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author: winton
 * @time: 2018/6/13 14:12
 * @package: com.af.smartfactorypad.view
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 一句话描述
 */
public class DiyScrollViewPager extends ViewPager {

    private boolean canScroll;

    public DiyScrollViewPager(Context context) {
        super(context);
    }

    public boolean isCanScroll() {
        return canScroll;
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    public DiyScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return canScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canScroll && super.onTouchEvent(ev);
    }
}
