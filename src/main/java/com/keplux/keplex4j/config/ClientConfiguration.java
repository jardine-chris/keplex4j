package com.keplux.keplex4j.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Getter
@Setter
@NoArgsConstructor
@Configuration
public class ClientConfiguration {
    @Value("${plex.config.host}")
    private String host;

    @Value("${plex.config.port}")
    private String port;

    @Value("${plex.config.token}")
    private String token;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(String.format("http://%s:%s", host, port))
                .defaultHeader(HttpHeaders.ACCEPT,
                        MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
