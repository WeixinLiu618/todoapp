package com.example.todoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Weixin Liu
 */
@Controller
public class SayHelloController {

    @RequestMapping(value = "/say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping(value = "/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

}
