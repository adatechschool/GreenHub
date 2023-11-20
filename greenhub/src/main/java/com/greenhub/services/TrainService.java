package com.greenhub.services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TrainService {

    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.username}")
    private String username;
    @Value("${api.password}")
    private String password;

    public String fetchData() {
        WebClient webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Authorization", createBasicAuthHeader(username, password))
                .build();

        return webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private String createBasicAuthHeader(String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = java.util.Base64.getEncoder().encode(auth.getBytes());
        return "Basic " + new String(encodedAuth);
    }
}
