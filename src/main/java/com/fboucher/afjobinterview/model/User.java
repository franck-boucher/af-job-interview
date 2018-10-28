package com.fboucher.afjobinterview.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @NotNull(message = "First name can not be null")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    private String lastName;

    @NotNull(message = "Age can not be null")
    @Min(value = 18, message = "Age should not be less than 18")
    private int age;

    @NotNull(message = "Country name can not be null")
    @Enumerated(EnumType.STRING)
    private Country country;

    private String city;

    private String address;

    private String zipCode;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    private boolean newsletterSubscribed = false;

    public User() {
    }

    public User(String firstName, String lastName, int age, Country country, String city, String address,
            String zipCode, boolean newsletterSubscribed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.newsletterSubscribed = newsletterSubscribed;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Country getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }
}
