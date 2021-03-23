package com.example.demo;

import com.example.demo.controller.CallbackTemplate;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.JsonParseException;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {
    private static JSONParser json;

    public static JSONParser getJson() {
        return json;
    }

    public static void setJson(JSONParser json) {
        Post.json = json;
    }

    public static void POSTRequest(String campaign) throws IOException {

        URL obj = new URL("https://ezetap.verloop.io/api/v1/Campaign/SendMessage");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(campaign.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //System.out.println(response);
        try {
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                try {
                    json = new JSONParser(response.toString());
                } catch (JsonParseException e) {
                    e.printStackTrace();
                }

            } else {
                String Ps = "{\n" +
                        "    \"success\": false" +
                        "}";
                try {
                    json = new JSONParser(Ps);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error in reading");
        }


    }
}