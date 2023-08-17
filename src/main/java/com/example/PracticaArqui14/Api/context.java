package com.example.PracticaArqui14.Api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

@Configuration
public class context {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
