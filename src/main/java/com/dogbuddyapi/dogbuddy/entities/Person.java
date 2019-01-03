package com.dogbuddyapi.dogbuddy.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // must provide name, city, state, zip, about
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private Integer zipCode;
    private Integer milesWillingToDrive;
    private String about;
    private String photo;
    private Gender gender;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dog> dogs;

    // person can have many events
    // event can have many persons
    // person can have many messages
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Message> messages;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayDate> playdates;

    public Person(){}

    // Getters and setters
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<PlayDate> getPlaydates() {
        return playdates;
    }

    public void setPlaydates(Set<PlayDate> playdates) {
        this.playdates = playdates;
    }




    //@OneToMany(cascade=CascadeType.ALL, mappedBy="person")

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    //@OneToMany(cascade=CascadeType.ALL, mappedBy="person")
    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getMilesWillingToDrive() {
        return milesWillingToDrive;
    }

    public void setMilesWillingToDrive(Integer milesWillingToDrive) {
        this.milesWillingToDrive = milesWillingToDrive;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Person) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
