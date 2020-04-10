package com.marufh.geoipservice.dto;

import com.maxmind.geoip2.model.CountryResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeoIp {

    private String continent;

    private String ipAddress;

    private String countryCode;

    public static GeoIp convert(CountryResponse countryResponse) {
        return GeoIp.builder()
                .continent(countryResponse.getContinent().getCode())
                .countryCode(countryResponse.getCountry().getIsoCode())
                .ipAddress(countryResponse.getTraits().getIpAddress())
                .build();
    }
}
