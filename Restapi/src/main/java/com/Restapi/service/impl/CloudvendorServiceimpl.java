package com.Restapi.service.impl;

import com.Restapi.exception.CloudVendorNotFoundException;
import com.Restapi.model.CloudVendor;
import com.Restapi.repository.CloudVendorRepository;
import com.Restapi.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudvendorServiceimpl implements CloudVendorService {


    CloudVendorRepository cloudVendorRepository;

    public CloudvendorServiceimpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {

        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("the vendor is not in our database...");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }


}
