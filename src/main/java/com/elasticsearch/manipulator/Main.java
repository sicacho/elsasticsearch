package com.elasticsearch.manipulator;

import okhttp3.*;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

/**
 * Created by tnkhang on 9/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<String> entityName = JsonConverter.dataFromJson("C:\\Users\\tnkhang\\Desktop\\jsontest.json");
        entityName.stream().forEach(s -> insertData("http://127.0.0.1:9200/dictionary/entity",s));
    }

    public static void insertData(String elasticUrl,String data) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, data);
        Request request = new Request.Builder()
                .url(elasticUrl)
                .post(body)
                .addHeader("accept", "application/vnd.twitchtv.v3+json")
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "ef38b56b-9aa9-7633-ff3e-93de2d19e6fb")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
