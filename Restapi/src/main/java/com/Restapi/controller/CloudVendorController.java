package com.Restapi.controller;


import com.Restapi.model.CloudVendor;
import com.Restapi.response.ResponseHandler;
import com.Restapi.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {


   // CloudVendor cloudVendor;

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getDetailsCloudVender(@PathVariable("vendorId") String vendorId)
    {

        return ResponseHandler.responseBuilder("requested vendor details are given here..",HttpStatus.OK,
                                                cloudVendorService.getCloudVendor(vendorId));

                //new CloudVendor("ca","faizan","akola","9798749") ;
    }


    @GetMapping()
    public List<CloudVendor> getAllCloudVendor()
    {
        return cloudVendorService.getAllCloudVendor();
    }


    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);

        return "vendor create successfullyy....";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor)
    {
       cloudVendorService.updateCloudVendor(cloudVendor);
        return "updated successfully...";
    }


    @DeleteMapping("{vendorId}")
    public String deleteVendor(@PathVariable("vendorId") String vendorId)
    {
        cloudVendorService.deleteCloudVendor(vendorId);

        return "deleted vendor successfully...";
    }

}
