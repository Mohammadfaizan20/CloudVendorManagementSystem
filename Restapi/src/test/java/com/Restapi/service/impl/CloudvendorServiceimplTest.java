package com.Restapi.service.impl;

import com.Restapi.model.CloudVendor;
import com.Restapi.repository.CloudVendorRepository;
import com.Restapi.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;


class CloudvendorServiceimplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        cloudVendorService = new CloudvendorServiceimpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("3","flipkart","india","4848484");

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void testcreateCloudVendor() {
        Mockito.mock(CloudVendor.class);
        Mockito.mock(CloudVendorRepository.class);

        Mockito.when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");


    }

    @Test
    void testupdateCloudVendor() {

        Mockito.mock(CloudVendor.class);
        Mockito.mock(CloudVendorRepository.class);

        Mockito.when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");



    }


    @Test
    void testgetCloudVendor() {

        Mockito.mock(CloudVendor.class);
        Mockito.mock(CloudVendorRepository.class);

        Mockito.when(cloudVendorRepository.findById("3")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("3").getVendorName())
                .isEqualTo(cloudVendor.getVendorName());


    }


//    @Test
//    void testGetByVendorName(){
//
//        Mockito.mock(CloudVendor.class);
//        Mockito.mock(CloudVendorRepository.class);
//
//        Mockito.when(cloudVendorRepository.findByVendorName("flipkart")).thenReturn(
//                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
//        );
//
//        assertThat(cloudVendorService.ge)
//
//    }




    @Test
    void getAllCloudVendor() {

        Mockito.mock(CloudVendor.class);
        Mockito.mock(CloudVendorRepository.class);

        Mockito.when(cloudVendorRepository.findAll()).thenReturn(
                new ArrayList<CloudVendor>(Collections.singleton(cloudVendor))
        );

        assertThat(cloudVendorService.getAllCloudVendor().get(0).getVendorPhoneNumber())
                .isEqualTo(cloudVendor.getVendorPhoneNumber());

    }

    @Test
    void deleteCloudVendor() {

        Mockito.mock(CloudVendor.class);
        Mockito.mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        Mockito.doAnswer(Answers.CALLS_REAL_METHODS).when(
                cloudVendorRepository).deleteById(any());

        assertThat(cloudVendorService.deleteCloudVendor("3")).isEqualTo("Success");



    }


}