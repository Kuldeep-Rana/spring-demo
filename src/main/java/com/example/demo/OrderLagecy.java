package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderLagecy {

    @RequestMapping(value = "/get-order-old",method = RequestMethod.GET)
    public @ResponseBody Order getOrder1(){
        return new Order();
    }

}
