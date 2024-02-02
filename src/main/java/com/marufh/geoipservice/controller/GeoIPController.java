package com.marufh.geoipservice.controller;

import com.marufh.geoipservice.dto.GeoIp;
import com.marufh.geoipservice.service.GeoIpLookUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(GeoIPController.URL)
public class GeoIPController {

    public static final String URL = "/location";
    private final GeoIpLookUpService geoIpLookUpService;

    @GetMapping
    public GeoIp getJsonResponse(@RequestParam String ip) {
        return GeoIp.convert(geoIpLookUpService.findGeoLocationByIp(ip));
    }
}
