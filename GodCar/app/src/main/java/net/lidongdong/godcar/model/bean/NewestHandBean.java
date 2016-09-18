package net.lidongdong.godcar.model.bean;

import java.io.Serializable;

/**
 * Created by dllo on 16/9/18.
 */
public class NewestHandBean implements Serializable {
    private int imgId;
    private String imgUrl;

    public NewestHandBean() {
    }

    public NewestHandBean(int imgId) {
        this.imgId = imgId;
    }

    public NewestHandBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public NewestHandBean(String imgUrl, int imgId) {
        this.imgUrl = imgUrl;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
