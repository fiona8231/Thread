package com.fiona;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//多线程下载图片
public class ThreadPollTest implements Callable<Boolean> {

    private String url;
    private String file;

    //constructor
    public ThreadPollTest(String url, String file){
        this.file = file;
        this.url = url;
    }
    //线程执行体
    public Boolean call(){
        webDownload wd = new webDownload();
        try {
            wd.downloader(url, file);
            System.out.println("下载了文件 " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPollTest t1 = new ThreadPollTest("https://img.alicdn.com/tfs/TB1wqDaGa61gK0jSZFlXXXDKFXa-1125-350.jpg", "1.jpg");
        ThreadPollTest t2 = new ThreadPollTest("https://img.alicdn.com/tfs/TB1wqDaGa61gK0jSZFlXXXDKFXa-1125-350.jpg", "2.jpg");
        ThreadPollTest t3 = new ThreadPollTest("https://img.alicdn.com/tfs/TB1wqDaGa61gK0jSZFlXXXDKFXa-1125-350.jpg", "3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交服务 -> 返回三个结果
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
       //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        //关闭服务
        ser.shutdown();

    }


}



