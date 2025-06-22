package com.ORM_JPA.class1.controller;

import com.ORM_JPA.class1.entity.Address;
import com.ORM_JPA.class1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping()
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        // if(address.getId()==null)return ResponseEntity.ok(null);
        System.out.println(address);
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

}
