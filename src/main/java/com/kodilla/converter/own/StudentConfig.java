package com.kodilla.converter.own;

import com.kodilla.converter.controller.MyCustomSlashConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
@Configuration
public class StudentConfig
{
  @Bean
  public HttpMessageConverter<Object> studentConverter() {
    return new StudentConverter();
  }
}
