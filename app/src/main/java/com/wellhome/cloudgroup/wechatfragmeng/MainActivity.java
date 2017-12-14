package com.wellhome.cloudgroup.wechatfragmeng;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout mTabWeixin;
    private LinearLayout mTabadr;
    private LinearLayout mTabonekey;
    private LinearLayout mTabfrd;
    private LinearLayout mTabmine;


    private ImageButton mWeixinimg;
    private ImageButton mfrdimg;
    private ImageButton madrimg;
    private ImageButton mmineimg;
    private ImageButton monekeyimg;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;
    private Fragment mTab05;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
        setSelect(0);
    }

    private void initEvent() {

        mTabmine.setOnClickListener(this);
        mTabWeixin.setOnClickListener(this);
        mTabfrd.setOnClickListener(this);
        mTabadr.setOnClickListener(this);
        mTabonekey.setOnClickListener(this);

    }

    private void initView() {
        //tab
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabadr = (LinearLayout) findViewById(R.id.id_tab_adr);
        mTabonekey = (LinearLayout) findViewById(R.id.id_tab_onekey);
        mTabfrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabmine = (LinearLayout) findViewById(R.id.id_tab_mine);
        //imagebutton
        mWeixinimg = (ImageButton) findViewById(R.id.id_tab_winxinimg);
        madrimg = (ImageButton) findViewById(R.id.id_tab_adrmg);
        monekeyimg = (ImageButton) findViewById(R.id.id_tab_onekeyimg);
        mfrdimg = (ImageButton) findViewById(R.id.id_tab_frdimg);
        mmineimg = (ImageButton) findViewById(R.id.id_tab_mineimg);


        //不必要了
     /*   mTab01=new WeixinFragment();
        mTab01=new FreFragment();
        mTab01=new AdrFragment();
        mTab01=new OnekeyFragment();
        mTab01=new MineFragment();*/
    }

    @Override
    public void onClick(View v) {

        resetIimg();

        switch (v.getId()) {
            case R.id.id_tab_weixin:
               setSelect(0);
                break;
            case R.id.id_tab_adr:
              setSelect(1);
                break;
            case R.id.id_tab_onekey:
                setSelect(2);
                break;
            case R.id.id_tab_frd:
                setSelect(3);
                break;
            case R.id.id_tab_mine:
                setSelect(4);
                break;

        }
    }


    private void setSelect(int i) {
        // 把图片设置为亮的
        //设置内容区域
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fm.beginTransaction();
        hideFragment(fragmentTransaction);



        switch (i){

            case  0:
                if(mTab01==null){
                    mTab01=new WeixinFragment();
                    fragmentTransaction.add(R.id.id_content,mTab01);

                }else {
                    fragmentTransaction.show(mTab01);

                }
                mWeixinimg.setImageResource(R.drawable.icon_main_home_selected);

                break;
            case  1:
                if(mTab02==null){
                    mTab02=new AdrFragment();
                    fragmentTransaction.add(R.id.id_content,mTab02);
                }else {
                    fragmentTransaction.show(mTab02);

                }
                madrimg.setImageResource(R.drawable.icon_main_category_selected);

                break;
            case 2:
                if(mTab03==null){
                    mTab03=new OnekeyFragment();
                    fragmentTransaction.add(R.id.id_content,mTab03);
                }else {
                    fragmentTransaction.show(mTab03);

                }
                monekeyimg.setImageResource(R.drawable.icon_main_home_selected);

                break;
            case  3:
                if(mTab04==null){
                    mTab04=new FreFragment();
                    fragmentTransaction.add(R.id.id_content,mTab04);
                }else {
                    fragmentTransaction.show(mTab04);

                }
                mfrdimg.setImageResource(R.drawable.icon_main_service_selected);

                break;
            case  4:
                if(mTab05==null){
                    mTab05=new MineFragment();
                    fragmentTransaction.add(R.id.id_content,mTab05);
                }else {
                    fragmentTransaction.show(mTab05);

                }
                mmineimg.setImageResource(R.drawable.icon_main_mine_selected);
                break;
        }

    fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {

        if (mTab01!=null){
            fragmentTransaction.hide(mTab01);
        }
        if (mTab02!=null){
            fragmentTransaction.hide(mTab02);
        }
        if (mTab03!=null){
            fragmentTransaction.hide(mTab03);
        }
        if (mTab04!=null){
            fragmentTransaction.hide(mTab04);
        }
        if (mTab05!=null){
            fragmentTransaction.hide(mTab05);
        }
    }


    /**
     * //更换暗色图片
     */
    private void resetIimg() {
        mWeixinimg.setImageResource(R.drawable.icon_main_home_normal);
        madrimg.setImageResource(R.drawable.icon_main_category_normal);
        monekeyimg.setImageResource(R.drawable.icon_main_home_normal);
        mfrdimg.setImageResource(R.drawable.icon_main_service_normal);
        mmineimg.setImageResource(R.drawable.icon_main_mine_normal);


    }
}
