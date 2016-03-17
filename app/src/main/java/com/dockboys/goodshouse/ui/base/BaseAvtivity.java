package com.dockboys.goodshouse.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dockboys.goodshouse.ui.AppManager;

import butterknife.ButterKnife;

/**
 * Desc : 基础的activity
 * Author : jiangcheng
 * Date : on 2016/3/9 0009
 */
public class BaseAvtivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        ButterKnife.bind(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
}
