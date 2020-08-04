package com.bo.demo.client;

import com.bo.demo.utils.HttpClientUtils;

public class TestClient {

    public static void main(String[] args) throws Exception {
        String result = HttpClientUtils.get("http://localhost:8097/hello",null);
        System.out.println(result);
    }

}
