package com.ORM_JPA.class1.repositary;

import com.ORM_JPA.class1.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddresRepository extends JpaRepository<Address, Long> {

}
