package com.fds.v1.lib;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class ExternalAPI {
    @Value("${hypixel.api-key}")
    private String hypixelApiKey;

    public Map<String, Object> getHypixelPlayer(String uuid) throws IOException {
        String url = "https://api.hypixel.net/player?key=" + hypixelApiKey + "&uuid=" + uuid;
        JsonNode responseJson = sendRequest(url);
        return Common.jsonNodeToMap(responseJson.path("player"));
    }

    public Map<String, Object> getMojangUser(String name) throws IOException {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + name;
        JsonNode responseJson = sendRequest(url);
        return Common.jsonNodeToMap(responseJson);
    }

    public Map<String, Object> getScrimsPlayer(String name) throws IOException {
        String url = "https://api.bridgescrims.net/player?username=" + name;
        JsonNode responseJson = sendRequest(url);
        return Common.jsonNodeToMap(responseJson);
    }

    public JsonNode sendRequest(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "application/json");
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String responseBody = EntityUtils.toString(entity);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(responseBody);
    }

}
