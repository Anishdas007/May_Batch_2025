package com.ORM_JPA.class1.service;

import com.ORM_JPA.class1.entity.Address;
import com.ORM_JPA.class1.repositary.AddresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddresRepository addresRepository;

    @Override
    public Address saveAddress(Address address) {
        return addresRepository.save(address);
    }

}
