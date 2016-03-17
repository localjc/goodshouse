package com.dockboys.goodshouse.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dockboys.goodshouse.R;
import com.dockboys.goodshouse.ui.base.BaseAvtivity;
import com.dockboys.goodshouse.ui.base.BaseFragmentPagerAdapter;
import com.dockboys.goodshouse.ui.base.BaseListFragment;

import butterknife.Bind;

public class MainActivity extends BaseAvtivity {

    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;

    private BaseFragmentPagerAdapter mFragmentPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(mToolbar);
        initViewPage();
        mTabLayout.setupWithViewPager(mViewPager);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "我要推荐", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     *
     */
    private void initViewPage() {
        mFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
        mFragmentPagerAdapter.addFragment(BaseListFragment.newFragment("hot"), "热门");
        mFragmentPagerAdapter.addFragment(BaseListFragment.newFragment("digital"), "数码");
        mFragmentPagerAdapter.addFragment(BaseListFragment.newFragment("clothing"), "服饰");
        mFragmentPagerAdapter.addFragment(BaseListFragment.newFragment("7days"), "7天热门");
        mFragmentPagerAdapter.addFragment(BaseListFragment.newFragment("30days"), "30天热门");
        mViewPager.setAdapter(mFragmentPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
