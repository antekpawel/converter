package com.kodilla.converter.controller;

import com.kodilla.converter.MyCustomClass;
import org.springframework.web.bind.annotation.*;

/**
 * User: Z6PWA
 * Date: 15.10.2023
 */
@RestController
@RequestMapping("/custom/")
public class CustomController {

  @PostMapping(path = "add")
  public void acceptCustomTextType(@RequestBody MyCustomClass customObject) {
    System.out.println(customObject.getFieldOne());
    System.out.println(customObject.getFieldTwo());
    System.out.println(customObject.getFieldThree());
  }

}