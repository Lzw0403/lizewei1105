package com.bwei.presnter;

import com.bwei.contart.Icontart;
import com.bwei.model.Model;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:9:15
 *@Description:${DESCRIPTION}
 **/public class Presenter implements Icontart.IPresenter {
    Icontart.Iview iview;
    Icontart.Imodel imodel;
    @Override
    public void Attch(Icontart.Iview iview) {
        this.iview = iview;
        imodel = new Model();
    }

    @Override
    public void startRequest(String url) {
        imodel.getInfo(url, new Icontart.MyCallBack() {
            @Override
            public void Success(String json) {
                iview.onSccuess(json);
            }

            @Override
            public void error(String err) {
                iview.onFaild(err);
            }
        });
    }

    @Override
    public void unAttch() {

    }
}
