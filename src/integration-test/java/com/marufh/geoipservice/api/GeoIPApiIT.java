package com.marufh.geoipservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GeoIPApiIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_proper_response() throws Exception {

        // Given
        String ip = "89.27.159.35";

        // Then
         this.mockMvc.perform(MockMvcRequestBuilders.get(GeoIPApi.URL)
                .contentType(MediaType.APPLICATION_JSON)
                .param("ip", ip)
         )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.continent").value ("EU"))
                .andExpect(jsonPath("$.ipAddress").value ("89.27.159.35"))
                .andExpect(jsonPath("$.countryCode").value ("DE"))
          ;

    }


    @Test
    public void should_get_exception() throws Exception {

        // Given
        String ip = "a.b.c.d";

        // Then
        this.mockMvc.perform(MockMvcRequestBuilders.get(GeoIPApi.URL)
                .contentType(MediaType.APPLICATION_JSON)
                .param("ip", ip)
        )
                .andExpect(status().is5xxServerError())
        ;

    }

}
