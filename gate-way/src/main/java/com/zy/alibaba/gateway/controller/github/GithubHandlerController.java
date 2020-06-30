package com.zy.alibaba.gateway.controller.github;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.alibaba.gateway.conf.AssesTokenProperties;
import com.zy.alibaba.gateway.conf.GitHubProvider;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.MapUtils;

import java.io.IOException;

/**
 * @AUTHOR zhangy
 * 2020-06-30  20:47
 */
@RestController
@RequestMapping("/api/github")
public class GithubHandlerController {

    @Autowired
    private AssesTokenProperties assesTokenProperties;


    @GetMapping("/callback")
    public String githubCallback(String code, String state) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        AssesTokenProperties properties = new AssesTokenProperties();
        properties.setClient_secret(assesTokenProperties.getClient_secret());
        properties.setClient_id(assesTokenProperties.getClient_id());
        properties.setState(state);
        properties.setCode(code);


        RequestBody body = RequestBody.create(mediaType, JSONObject.toJSONString(properties));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (
                Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);//access_token=c231d1e359bed82f6f98b2a2d86eb916478b56d1&scope=user&token_type=bearer
            String token = string.split("&")[0].split("=")[1];


            return this.getUser(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用okhttp根据传过来的accessToken向https://api.github.com/user发送请求获得user
     *
     * @param accessToken
     * @return
     */
    public String getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try (
                Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
