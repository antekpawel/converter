package com.kodilla.converter.own;

import com.kodilla.converter.MyCustomClass;
import org.springframework.http.*;
import org.springframework.http.converter.*;

import java.awt.print.Book;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
public class StudentConverter implements HttpMessageConverter<Object>
{
  @Override
  public boolean canRead(Class<?> clazz, MediaType mediaType)
  {
    return clazz.getName().equals("com.kodilla.converter.own.Student") &&
      mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");  }

  @Override
  public boolean canWrite(Class<?> clazz, MediaType mediaType)
  {
    return clazz.getName().equals("com.kodilla.converter.own.Student") &&
      mediaType.getSubtype().equals("plain") && mediaType.getType().equals("text");
  }

  @Override
  public List<MediaType> getSupportedMediaTypes()
  {
    return List.of(MediaType.ALL);
  }

  @Override
  public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException
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

    Student student = new Student();

    String[] fields = builder.toString().split("/");

    for (String text : fields)
    {
      String[] split = text.split(":");
      try {
        Field setDetailsMethod
          = Student.class.getDeclaredField(split[0]);

        setDetailsMethod.setAccessible(true);
        setDetailsMethod.set(student, split[1]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return student;
  }

  @Override
  public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
  {

  }
}
