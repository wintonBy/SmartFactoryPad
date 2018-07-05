package com.af.smartfactorypad.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.af.smartfactorypad.R;
import com.af.smartfactorypad.adapter.IndexViewPagerAdapter;
import com.af.smartfactorypad.presenter.BasePresenter;
import com.af.smartfactorypad.ui.fragment.CallFragment;
import com.af.smartfactorypad.ui.fragment.SignInFragment;
import com.af.smartfactorypad.ui.fragment.UserFragment;
import com.af.smartfactorypad.view.DiyScrollViewPager;
import com.winton.bottomnavigationview.NavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: winton
 * @time: 2018/6/18 17:25
 * @package: com.af.smartfactorypad.ui.activity
 * @project: SmartFactoryPad
 * @mail:
 * @describe: 维修版本首页
 */
public class SupportIndexActivity extends BaseActivity {

    @BindView(R.id.nv_bottom)
    NavigationView mNV;
    @BindView(R.id.vp_content)
    DiyScrollViewPager mVP;
    private IndexViewPagerAdapter mAdapter;
    private FragmentManager fm;
    private List<Fragment> fragments;


    /**
     * 进入详情页的方法
     * @param context
     */
    public static void start(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not null");
        }
        Intent intent = new Intent(context, SupportIndexActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.act_support_index);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initBottomNavigation();
        mVP.setCanScroll(false);
        mVP.setOffscreenPageLimit(4);
    }

    /**
     * 初始化底部导航栏
     */
    private void initBottomNavigation() {

        List<NavigationView.Model> nvItems = new ArrayList<>();
        nvItems.add(new NavigationView.Model.Builder(R.mipmap.ic_local_check,R.mipmap.ic_local).title(getResources().getString(R.string.sign_in)).build());
        nvItems.add(new NavigationView.Model.Builder(R.mipmap.ic_call_check,R.mipmap.ic_call).title(getResources().getString(R.string.call)).build());
        nvItems.add(new NavigationView.Model.Builder(R.mipmap.ic_me_check,R.mipmap.ic_me).title(getResources().getString(R.string.me)).build());

        mNV.setItems(nvItems);
        mNV.build();
        mNV.check(0);
    }


    @Override
    protected void initListener() {
        super.initListener();
        mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int index, NavigationView.Model model) {
                mVP.setCurrentItem(index,false);
            }

            @Override
            public void unselected(int index, NavigationView.Model model) {

            }
        });
    }
    @Override
    protected void initData() {
        super.initData();
        fragments = new ArrayList<>();
        fragments.add(SignInFragment.newInstance(null));
        fragments.add(CallFragment.newInstance(null));
        fragments.add(UserFragment.newInstance(null));
        mAdapter = new IndexViewPagerAdapter(fm,fragments);
        mVP.setAdapter(mAdapter);
    }

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }
}
