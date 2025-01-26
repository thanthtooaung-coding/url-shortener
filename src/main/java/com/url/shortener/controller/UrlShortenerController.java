package com.url.shortener.controller;

import com.url.shortener.dto.UrlRequestDto;
import com.url.shortener.dto.UrlResponseDto;
import com.url.shortener.service.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urls")
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {
        return ResponseEntity.ok(urlShortenerService.shortenUrl(urlRequestDto));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl) {
        return ResponseEntity.ok(urlShortenerService.getOriginalUrl(shortUrl));
    }
}
