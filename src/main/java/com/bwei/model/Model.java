package com.bwei.model;

import com.bwei.asyn.MyTask;
import com.bwei.contart.Icontart;
import com.bwei.util.HttpConn;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:9:10
 *@Description:${DESCRIPTION}
 **/public class Model implements Icontart.Imodel {
    @Override
    public void getInfo(String url, final Icontart.MyCallBack myCallBack) {
        new MyTask(new MyTask.GetNnn() {
            @Override
            public void chEng(String jsonStr) {
                myCallBack.Success(jsonStr);
            }

            @Override
            public void bAi(String error) {
                myCallBack.error(error);
            }
        }).execute(url);
    }

    @Override
    public void postInfo(String url, Icontart.MyCallBack myCallBack) {

    }
}
