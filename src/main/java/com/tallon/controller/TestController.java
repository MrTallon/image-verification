package com.tallon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 *
 * @author tallon
 * @version v1.0.0
 * @date 2020-11-10 11:15
 */
@RestController
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "hello world";
    }
}
