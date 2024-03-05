package com.shortener.url.repository;

import com.shortener.url.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<ShortUrl, Integer> {
    public Optional<ShortUrl> findByShortUrl(String shortUrl);
}
