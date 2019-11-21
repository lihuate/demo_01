package com.iio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/say")
    String say(){
        return "fast spring boot start";
    }
}
