package com.kodilla.converter.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
@Configuration
public class ConverterConfiguration {

  @Bean
  public HttpMessageConverter<Object> customSlashConverter() {
    return new MyCustomSlashConverter();
  }

}
