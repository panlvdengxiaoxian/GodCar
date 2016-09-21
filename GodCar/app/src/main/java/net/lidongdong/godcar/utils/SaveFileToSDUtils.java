package net.lidongdong.godcar.utils;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dllo on 16/9/21.
 * 保存文件到sd卡的工具类
 */
public class SaveFileToSDUtils {
    private static SaveFileToSDUtils instance;
    private SaveFileToSDUtils(){}
    public  static SaveFileToSDUtils getInstance(){
        return instance;
    }
    private static final String DIR_NAME="sdcard/myapp/";//保存图片的文件夹的名字
    public void saveImage(String url, Bitmap bitmap){
        FileOutputStream fos=null;
        //创建文件夹
        File file=new File(DIR_NAME);
        if (!file.exists()){
            file.mkdir();
        }
        //将网址进行MD5解密
        String finalUrl=MD5Utils.getMD5Str(url);
        //创建图片文件
        //根据解密后的网址创建文件
        File imgFile=new File(DIR_NAME,finalUrl+".jpg");
        if (!imgFile.exists()){
            try {
                imgFile.createNewFile();
                //把Bitmap以输出流的方式写到该图片文件中
                fos=new FileOutputStream(imgFile);
                bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fos !=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
