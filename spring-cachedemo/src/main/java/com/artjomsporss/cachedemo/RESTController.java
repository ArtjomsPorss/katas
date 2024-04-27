package com.artjomsporss.cachedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

    @Autowired
    private ItemService service;

    // call like: curl --location 'localhost:8080/item?itemName=asdf'
    // first call will be slower because service generates items, e.g. 150ms
    // subsequent calls will be quicker because @Cacheable caches responses, e.g. 45ms
    @GetMapping("/item")
    @Cacheable("items")
    public String get(@RequestParam String itemName) throws JsonProcessingException {
       return new ObjectMapper().writeValueAsString(this.service.get(itemName));
    }

    // call like: curl --location --request POST 'localhost:8080/item?itemName=ababab'
    // clears cache
    // forces subsequent calls to GET to generate all the data again
    @PostMapping("/item")
    @CacheEvict(cacheNames = {"items"}, allEntries = true)
    public void post(@RequestParam String itemName) {
        this.service.post(itemName);
    }
}
