package net.lidongdong.godcar.model.bean;

import java.io.Serializable;

/**
 * Created by dllo on 16/9/18.
 * 最新页的头布局
 */
public class NewestHandBean implements Serializable {
    private int imagId;
    private String imgUrl;

    public NewestHandBean() {
    }

    public NewestHandBean(int imagId) {
        this.imagId = imagId;
    }

    public NewestHandBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public NewestHandBean(int imagId, String imgUrl) {
        this.imagId = imagId;
        this.imgUrl = imgUrl;
    }

    public int getImagId() {
        return imagId;
    }

    public void setImagId(int imagId) {
        this.imagId = imagId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
