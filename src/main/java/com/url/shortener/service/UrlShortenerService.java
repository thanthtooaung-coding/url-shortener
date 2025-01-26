package com.url.shortener.service;


import com.url.shortener.dto.UrlRequestDto;
import com.url.shortener.dto.UrlResponseDto;

public interface UrlShortenerService {
    UrlResponseDto shortenUrl(UrlRequestDto urlRequestDto);
    String getOriginalUrl(String shortUrl);
}
