package com.migu.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleClient {

    public static void main(String[] args) throws Exception {
        sendGET();
        System.out.println("GET DONE");
        //sendPOST();
        //System.out.println("POST DONE");

    }

    private static void sendGET() throws Exception {
        //http请求


        while(true) {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://localhost:60001/hello/get/test");
            httpGet.setHeader("Connection", "keep-alive");
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            //HTTP响应头部显示
        /*int StatusCode = httpResponse.getStatusLine().getStatusCode();
        String StatusDescription = httpResponse.getStatusLine().getReasonPhrase();
        System.out.println("StatusCode: " + StatusCode);
        System.out.println("StatusDescription: " + StatusDescription);
        Header headers[] = httpResponse.getAllHeaders();
        for (Header h : headers) {
            System.out.println(h.getName() + ":" + h.getValue());
        }*/
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
            reader.close();
            // print result
            System.out.println(response.toString());


            Thread.sleep(100000);

        }


    }






}
