package com.marufh.geoipservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RootApi {

    @GetMapping
    public Map<String, String> getRootResponse() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "welcome to geo-location-service");
        map.put("time", LocalDate.now().toString());
        return map;
    }
}
