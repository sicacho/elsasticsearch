package com.elasticsearch.manipulator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tnkhang on 9/20/2016.
 */
public class JsonConverter {
    public static List<String> dataFromJson(String url) {
        List<String> strings = new ArrayList<String>();
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader(url));
            JSONArray jsonArray = (JSONArray) obj;
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                strings.add(iterator.next().toJSONString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }
}
