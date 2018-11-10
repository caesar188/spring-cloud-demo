package com.migu.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClient {
    static HttpClientBuilder builder;
    static CloseableHttpClient client ;
    static {
        builder = HttpClientBuilder.create();
        //builder.setProxy(new HttpHost("localhost",8888));
        builder.setMaxConnTotal(1);
        builder.setMaxConnPerRoute(1);
        builder.evictIdleConnections(5, TimeUnit.SECONDS);
        client = builder.build();
    }

    public static void doGet() throws IOException {
        //执行
        HttpUriRequest httpGet = new HttpGet("http://localhost:60001/hello/get/ss");
        CloseableHttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity!=null){
            String  entityStr= EntityUtils.toString(entity,"utf-8");
            System.out.println(entityStr);
        }
//        System.out.println(response.toString());
    }

    public static void main(String [] args) throws Exception{
        Thread thread = new HttpGetThread();
        thread.start();
    }

    public static class HttpGetThread extends Thread{
        public void run(){
            while (true){
                try {
                    doGet();
                    Thread.sleep(10000);
                }catch (Exception e){

                }
            }
        }
    }
}
