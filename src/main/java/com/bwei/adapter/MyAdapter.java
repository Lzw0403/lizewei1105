package com.bwei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.bean.MyData;
import com.bwei.lizewei20191105.R;

import java.util.List;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:10:11
 *@Description:${DESCRIPTION}
 **/public class MyAdapter extends BaseAdapter {
    List<MyData.GriddataBean> mlist;
    Context context;

    public MyAdapter(List<MyData.GriddataBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item_layout,null);
            holder = new Holder();
            holder.img = convertView.findViewById(R.id.img);
            holder.te = convertView.findViewById(R.id.te);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        Glide.with(context).load(mlist.get(position).getTitle()).into(holder.img);
        holder.te.setText(mlist.get(position).getTitle());
        return convertView;
    }
    class Holder{
        private ImageView img;
        private TextView te;
    }
}
