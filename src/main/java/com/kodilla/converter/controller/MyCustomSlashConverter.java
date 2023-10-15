package com.kodilla.converter.controller;

import com.kodilla.converter.MyCustomClass;
import org.springframework.http.*;
import org.springframework.http.converter.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class MyCustomSlashConverter implements HttpMessageConverter<Object>
{

  @Override
  public boolean canRead(Class<?> clazz, MediaType mediaType)
  {
    return clazz.getName().equals("com.kodilla.converter.MyCustomClass") &&
      mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");  }

  @Override
  public boolean canWrite(Class<?> clazz, MediaType mediaType)
  {
    return clazz.getName().equals("com.kodilla.converter.MyCustomClass") &&
      mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");
  }

  @Override
  public List<MediaType> getSupportedMediaTypes()
  {
    return List.of(MediaType.ALL);
  }

  @Override
  public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException
  {
    StringBuilder builder = new StringBuilder();

    try (Reader reader = new BufferedReader(
      new InputStreamReader(
        inputMessage.getBody(),
        Charset.forName(StandardCharsets.UTF_8.name())))) {
      int c = 0;

      while ((c = reader.read()) != -1)
        builder.append((char) c);
    }

    String[] fields = builder.toString().split("/");

    return new MyCustomClass(fields[0], fields[1], fields[2]);
  }

  @Override
  public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
  {

  }
}
