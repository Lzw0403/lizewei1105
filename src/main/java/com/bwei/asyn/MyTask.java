package com.bwei.asyn;

import android.os.AsyncTask;

import com.bwei.util.HttpConn;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:8:59
 *@Description:${DESCRIPTION}
 **/public class MyTask extends AsyncTask<String,Void,String> {
    GetNnn getNnn;

    public MyTask(GetNnn getNnn) {
        this.getNnn = getNnn;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = HttpConn.getInstance().getData(strings[0]);
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.isEmpty()){
            getNnn.bAi("");
        }else {
            getNnn.chEng(s);
        }
    }
    public interface GetNnn{
        void chEng(String jsonStr);
        void bAi(String error);
    }
}
