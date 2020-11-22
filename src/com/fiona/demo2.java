package com.fiona;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//多线程下载图片
public class demo2 extends Thread{

    private String url;
    private String file;

    //constructor
    public demo2(String url, String file){
        this.file = file;
        this.url = url;
    }
    //线程执行体
    public void run(){
        webDownload wd = new webDownload();
        try {
            wd.downloader(url, file);
            System.out.println("下载了文件 " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

//下载器
class webDownload{
    public void downloader(String url, String file) throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File(file));
    }
}
