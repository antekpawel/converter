package com.kodilla.converter.own;

import com.kodilla.converter.MyCustomClass;
import org.springframework.web.bind.annotation.*;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
@RestController
@RequestMapping("/student/")
public class StudentController {

  @PostMapping(path = "add")
  public void acceptCustomTextType(@RequestBody Student student) {
    System.out.println(student.getName());
    System.out.println(student.getSurname());
    System.out.println(student.getIndexNumber());
  }

}