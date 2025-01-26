package com.url.shortener.service.impl;

import com.url.shortener.domain.Url;
import com.url.shortener.dto.UrlRequestDto;
import com.url.shortener.dto.UrlResponseDto;
import com.url.shortener.exception.UrlNotFoundException;
import com.url.shortener.repository.UrlRepository;
import com.url.shortener.service.UrlShortenerService;
import com.url.shortener.util.HashingUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final UrlRepository urlRepository;

    public UrlShortenerServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public UrlResponseDto shortenUrl(UrlRequestDto urlRequestDto) {
        String hash = HashingUtil.generateHash(urlRequestDto.getOriginalUrl());
        
        Url url = Url.builder()
                .originalUrl(urlRequestDto.getOriginalUrl())
                .shortUrl(hash)
                .build();
        
        urlRepository.save(url);
        
        return new UrlResponseDto(hash);
    }

    @Override
    public String getOriginalUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new UrlNotFoundException("URL not found"))
                .getOriginalUrl();
    }
}
