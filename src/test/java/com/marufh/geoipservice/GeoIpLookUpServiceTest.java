package com.marufh.geoipservice;

import com.marufh.geoipservice.dto.GeoIp;
import com.marufh.geoipservice.exception.GeoIpLookUpException;
import com.maxmind.geoip2.model.CountryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This is unit test but I loaded all the context of the spring to test the file
 * It is possible to test by creating mock and I avoided lots of mock
 */

@SpringBootTest
class GeoIpLookUpServiceTest {

    @Autowired
    GeoIpLookUpService geoIpLookUpService;

    @Test
    void should_find_geoLocation_byIp() {

        // when
        CountryResponse countryResponse =  geoIpLookUpService.findGeoLocationByIp("89.27.159.35");
        GeoIp geoIp = GeoIp.convert(countryResponse);

        // Then
        Assertions.assertEquals("EU", geoIp.getContinent());
        Assertions.assertEquals("89.27.159.35", geoIp.getIpAddress());

    }

    @Test
    void should_throw_geoIp_lookUp_exception_for_ip() {
        Exception exception = Assertions.assertThrows(
                GeoIpLookUpException.class, () -> geoIpLookUpService.findGeoLocationByIp("a.b.c.e")
        );
        Assertions.assertEquals( "Error reading the ip: a.b.c.e", exception.getMessage());
    }

}
