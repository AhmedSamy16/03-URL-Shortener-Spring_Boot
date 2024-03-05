package com.shortener.url.controllers;

import com.shortener.url.DTOs.CreateShortUrl;
import com.shortener.url.services.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class URLController {
    private final UrlService urlService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUrls() {
        var urls = urlService.getAllURLs();
        return ResponseEntity.ok(urls);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> getShortUrl(@PathVariable String shortUrl) {
        var url = urlService.getShortUrl(shortUrl);
        if (url.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(url.get());
    }

    @PostMapping("/")
    public ResponseEntity<?> createShortUrl(@RequestBody CreateShortUrl urlToCreate) {
        var url = urlService.createShortUrl(urlToCreate);
        return ResponseEntity.ok(url);
    }
}
