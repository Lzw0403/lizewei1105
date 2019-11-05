package com.bwei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:8:49
 *@Description:${DESCRIPTION}
 **/public class HttpConn {
    //单例模式
    private static HttpConn httpConn;
    private int code;
    private InputStream stream;

    private HttpConn() {
    }
    public static synchronized HttpConn getInstance(){
        if (httpConn==null){
            httpConn = new HttpConn();
        }
            return httpConn;
    }
    //网络判断
    public boolean getNet(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return info.isConnected();
        }
            return false;
    }
    //请求数据
    public String getData(String str){
        try {
            URL url = new URL(str);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            code = conn.getResponseCode();
            if (code==200){
                stream = conn.getInputStream();
                String josn = streamToJson(stream);
                return josn;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }
    private String streamToJson(InputStream stream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String temp = "";
        StringBuilder builder = new StringBuilder();
        while ((temp=reader.readLine())!=null){
            builder.append(temp);
        }
            reader.close();
            return builder.toString();
    }
}
