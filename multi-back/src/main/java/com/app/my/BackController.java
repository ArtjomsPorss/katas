package com.app.my;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="back")
public class BackController {
    @GetMapping(path = "get")
    public String get(){
        return "from back";
    }
}
