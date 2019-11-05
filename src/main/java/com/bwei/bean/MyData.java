package com.bwei.bean;

import java.util.List;

/*
 *@auther:李泽炜
 *@Date: 2019/11/5
 *@Time:9:37
 *@Description:${DESCRIPTION}
 **/public class MyData {

    private String code;
    private List<BannerdataBean> bannerdata;
    private List<GriddataBean> griddata;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<BannerdataBean> getBannerdata() {
        return bannerdata;
    }

    public void setBannerdata(List<BannerdataBean> bannerdata) {
        this.bannerdata = bannerdata;
    }

    public List<GriddataBean> getGriddata() {
        return griddata;
    }

    public void setGriddata(List<GriddataBean> griddata) {
        this.griddata = griddata;
    }

    public static class BannerdataBean {
        /**
         * imageurl : http://blog.zhaoliang5156.cn/api/images/banner01.jpg
         */

        private String imageurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }

    public static class GriddataBean {
        /**
         * title : Yves Saint Laurent 圣罗兰黑管水光唇釉
         * price : 288
         * imageurl : http://blog.zhaoliang5156.cn/api/images/shop01.jpeg
         */

        private String title;
        private String price;
        private String imageurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
