package com.marufh.geoipservice.service;

import com.marufh.geoipservice.exception.GeoIpLookUpException;
import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

@Log4j2
@Service
@RequiredArgsConstructor
public class GeoIpLookUpService {

    private static final String geoIpFileName = "GeoLite2-Country.mmdb";
    private static DatabaseReader reader = null;
    private final ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        log.info("start reading geo ip database");
        Resource resource = resourceLoader.getResource("classpath:GeoLite2-Country.mmdb");
        InputStream dbAsStream = null;
        try {
            dbAsStream = resource.getInputStream();
            reader = new DatabaseReader
                    .Builder(dbAsStream)
                    .fileMode(Reader.FileMode.MEMORY)
                    .build();
        } catch (IOException e) {
            log.error("error while reading geo ip database");
            e.printStackTrace();
        }
        log.info("finish reading geo ip database");
    }

    @PreDestroy
    public void preDestroy() {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                log.error("Failed to close the reader.");
            }
        }
    }

    public CountryResponse findGeoLocationByIp(String ip) {
        try {
            return reader.country(InetAddress.getByName(ip));
        } catch (IOException | GeoIp2Exception e) {
            throw new GeoIpLookUpException("Error reading the ip: " + ip, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
