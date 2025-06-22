package com.ORM_JPA.class1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private Student student;
    // // Constructors
    // public Address() {
    // }
    // public Address( long addressId,String city, String state, String zipCode) {
    // this.addressId=addressId;
    // this.city = city;
    // this.state = state;
    // this.zipCode = zipCode;
    // }
    // // Getters and Setters
    // public Long getId() {
    // return addressId;
    // }
    // public void setId(Long id) {
    // this.addressId = id;
    // }
    // public String getCity() {
    // return city;
    // }
    // public void setCity(String city) {
    // this.city = city;
    // }
    // public String getState() {
    // return state;
    // }
    // public void setState(String state) {
    // this.state = state;
    // }
    // public String getZipCode() {
    // return zipCode;
    // }
    // public void setZipCode(String zipCode) {
    // this.zipCode = zipCode;
    // }
}
