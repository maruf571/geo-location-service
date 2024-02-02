package com.marufh.geoipservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RootController {

    @GetMapping
    public Map<String, String> getRootResponse() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Welcome to geo-location-service");
        map.put("time", LocalDate.now().toString());
        return map;
    }
}
