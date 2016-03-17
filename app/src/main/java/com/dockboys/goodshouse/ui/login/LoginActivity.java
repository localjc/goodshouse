package com.dockboys.goodshouse.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dockboys.goodshouse.R;
import com.dockboys.goodshouse.ui.base.BaseAvtivity;

import butterknife.Bind;

/**
 * Desc :
 * Author : jiangcheng
 * Date : on 2016/3/9 0009
 */
public class LoginActivity extends BaseAvtivity implements View.OnClickListener {

    @Bind(R.id.btn_register)
    Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onClick(View v) {

    }
}
