package com.techtonic.vp.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/")
@RestController
@Slf4j
@ApiOperation(value = "This api will create the collections")
public class CollectionsController {

    @Value("${accessKey}")
    private String accessKey;

    @PostMapping("collections")
    public ResponseEntity<?> createCollections() {
        log.info("Creating the collections..");
        String requestBody = "{\"name\":\"" + UUID.randomUUID().toString() + "\"}";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://video.bunnycdn.com/library/212379/collections"))
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .header("AccessKey", accessKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return ResponseEntity.ok("Collections creaeted");
    }
}
