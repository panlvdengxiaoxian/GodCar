package net.lidongdong.godcar.model.bean;

/**
 * Created by dllo on 16/9/10.
 * 设置页
 */
public class SettingBean  {
    private String title;
    private String  icon;

    public SettingBean() {
    }

    public SettingBean(String title, String icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
