package com.marufh.geoipservice;

import com.marufh.geoipservice.controller.GeoIPController;
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
class GeoIPControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_proper_response() throws Exception {

        // Given
        String ip = "89.27.159.35";

        // Then
         this.mockMvc.perform(MockMvcRequestBuilders.get(GeoIPController.URL)
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
    void should_get_exception() throws Exception {

        // Given
        String ip = "a.b.c.d";

        // Then
        this.mockMvc.perform(MockMvcRequestBuilders.get(GeoIPController.URL)
                .contentType(MediaType.APPLICATION_JSON)
                .param("ip", ip)
        )
                .andExpect(status().is5xxServerError())
        ;

    }

}
