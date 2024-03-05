package com.shortener.url.services;

import com.shortener.url.DTOs.CreateShortUrl;
import com.shortener.url.entities.ShortUrl;
import com.shortener.url.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository repo;

    public List<ShortUrl> getAllURLs() {
        return repo.findAll();
    }

    public Optional<ShortUrl> getShortUrl(String shortUrl) {
        var url = repo.findByShortUrl(shortUrl);
        if (url.isEmpty()) return Optional.empty();

        var existingUrl = url.get();
        existingUrl.setClicks(existingUrl.getClicks() + 1);

        return Optional.of(repo.save(existingUrl));
    }

    public ShortUrl createShortUrl(CreateShortUrl urlToCreate) {
        ShortUrl newUrl = new ShortUrl();
        newUrl.setUrl(urlToCreate.getUrl());

        return repo.save(newUrl);
    }
}
