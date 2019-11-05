package com.bwei.lizewei20191105;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.adapter.MyAdapter;
import com.bwei.presnter.Presenter;
import com.bwei.bean.MyData;
import com.bwei.contart.Icontart;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Icontart.Iview {
    private String url = "http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
    private XBanner x_banner;
    private GridView grid_view;
    private Icontart.IPresenter mpresenter;
    List<MyData.GriddataBean> mlist = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mpresenter = new Presenter();
        mpresenter.Attch(this);
        mpresenter.startRequest(url);
    }

    private void initView() {
        x_banner = (XBanner) findViewById(R.id.x_banner);
        grid_view = (GridView) findViewById(R.id.grid_view);
    }

    @Override
    public void onSccuess(String url) {
        MyData myData = new Gson().fromJson(url, MyData.class);
        myData.getGriddata();
        final List<MyData.BannerdataBean> bannerdata = myData.getBannerdata();
        myData.setBannerdata(bannerdata);
        x_banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(bannerdata.get(position).getImageurl()).into((ImageView) view);
            }
        });
        myAdapter = new MyAdapter(mlist, MainActivity.this);
        grid_view.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFaild(String url) {

    }
}
