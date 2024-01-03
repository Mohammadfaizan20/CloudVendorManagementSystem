package com.Restapi.repository;


import com.Restapi.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {

    //given---when---then...


    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {

        cloudVendor=new CloudVendor("1","amazone","india","89484");
        cloudVendorRepository.save(cloudVendor);

    }

    @AfterEach
    void tearDown() {

        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }


    // Test case for SUCCESS
    @Test
    void testFindByVendorName_Found()
    {
      List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("amazone");
      assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
      assertThat(cloudVendorList.get(0).getVendorAdress()).isEqualTo(cloudVendor.getVendorAdress());
      
    }







    // Test case for FAILURE

    @Test
    void testFindByVendorName_NotFound()
    {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("google");
        assertThat(cloudVendorList.isEmpty()).isTrue();
    }


}
