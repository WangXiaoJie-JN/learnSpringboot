package com.own.springboot.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.own.springboot.biz.systemUser.domain.SystemUser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class commonHttpConnec {


    OkHttpClient httpClient = new OkHttpClient();

    @Autowired
    private ObjectMapper objectMapper;

    public void PostRequest(SystemUser user){


        //发起请求
        try {
            //构造builder
            Request.Builder builder = new Request.Builder()
                    .url("")
                    .header("Content-Type","application/json");

            //构造请求体
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),objectMapper.writeValueAsString(user));
            //解析
            //objectMapper.readValue(result,Map.class);
            //构造请求
            Request req = builder.post(requestBody).build();
            Response response = httpClient.newCall(req).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
