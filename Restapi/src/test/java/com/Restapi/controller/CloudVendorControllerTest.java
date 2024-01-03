package com.Restapi.controller;

import com.Restapi.model.CloudVendor;
import com.Restapi.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("2","amazone","india","97676");

        cloudVendorTwo = new CloudVendor("3","google","usa","90978");

        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetDetailsCloudVendor () throws Exception  {

        Mockito.when(cloudVendorService.getCloudVendor("2")).thenReturn(cloudVendorOne);

       this.mockMvc.perform(get("/cloudvendor/2"))
               .andDo(print()).andExpect(status().isOk());


    }

    @Test
    void getAllCloudVendor() {
    }

    @Test
    void createCloudVendor() {
    }

    @Test
    void updateCloudVendor() {
    }

    @Test
    void deleteVendor() {
    }
}