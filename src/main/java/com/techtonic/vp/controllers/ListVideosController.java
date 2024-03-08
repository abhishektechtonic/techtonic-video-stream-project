package com.techtonic.vp.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ListVideosController {

    @Value("${libraryId}")
    private String libraryId;

    @Value("${accessKey}")
    private String accessKey;

    @GetMapping("videos")
    public ResponseEntity<?> getAllVideos(@RequestParam int page,@RequestParam int itemsPerPage,@RequestParam String search ,@RequestParam String collection,@RequestParam(defaultValue = "date",required = false) String orderBy) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                            "https://video.bunnycdn.com/library/212379/videos?page=1&itemsPerPage=100&orderBy=date"))
                    .header("accept", "application/json")
                    .header("AccessKey", accessKey)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return ResponseEntity.ok(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
