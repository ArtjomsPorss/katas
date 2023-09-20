package com.app.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("front")
public class FrontController {

    static final String BACKEND_URL = "http://127.0.0.1:8083/back/get";

    private final RestTemplate template;
    public FrontController(RestTemplate template) {
        this.template = template;
    }

    @GetMapping(path="get")
    public String getSome(){
        return "from front";
    }

    @GetMapping(path="back")
    public String getBack() {
        String response = template.getForObject(BACKEND_URL, String.class);
        return response;
    }
}