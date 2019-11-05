package com.bwei.contart;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:9:03
 *@Description:${DESCRIPTION}
 **/
// 契约类
    public interface Icontart {
    interface Imodel{
        void getInfo(String url,MyCallBack myCallBack);
        void postInfo(String url,MyCallBack myCallBack);
    }
    interface Iview{
        void onSccuess(String url);
        void onFaild(String url);
    }
    interface IPresenter{
        void Attch(Iview iview);
        void startRequest(String url);
        void unAttch();
    }
    interface MyCallBack{
        void Success(String json);
        void error(String err);
    }
}
