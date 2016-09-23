package net.lidongdong.godcar.model.bean;

import java.io.Serializable;

/**
 * Created by 潘驴邓小娴 on 2016/9/18.
 * 轮播图相关
 */
public class NewFragmentRoateBean implements Serializable {
    private int imagId;
    private String imgUrl;

    public NewFragmentRoateBean() {
    }

    public NewFragmentRoateBean(int imagId) {
        this.imagId = imagId;
    }

    public NewFragmentRoateBean(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public NewFragmentRoateBean(int imagId, String imgUrl) {
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
