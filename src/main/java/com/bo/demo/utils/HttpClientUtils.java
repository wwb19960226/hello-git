package com.bo.demo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.InputStream;

public class HttpClientUtils {



    public static String get(String url,String param) throws Exception {
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        FileOutputStream out = null;
        InputStream is = null;
        String res = "";
        String var11;
        try{

            URIBuilder builer = new URIBuilder(url);
            builer.addParameter("json",param);
            httpClient = new DefaultHttpClient();
            httpGet = new HttpGet(builer.build());
            httpGet.setHeader("Content-type","application/octet-stream;charset=UTF-8");
            httpGet.setHeader("Expires","-1");

            HttpResponse response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();
            if(status != 200){
                throw new Exception("http返回异常"+status);
            }
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                res = EntityUtils.toString(resEntity,"utf-8");
            }
            var11 = res;
        }finally {
            if(out != null){
                ((FileOutputStream)out).close();
            }

            if(is != null){
                ((InputStream)is).close();
            }

            if(httpGet != null){
                httpGet.releaseConnection();
            }
        }
        return var11;
    }

}
