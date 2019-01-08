package com.dogbuddyapi.dogbuddy.entities;

import org.aspectj.apache.bcel.util.Play;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    //private String uid;
    // must provide name, city, state, zip, about
    private String firstName;
    private String lastName;
    private String about;
    private String photo;
//    private Gender gender;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dog> dogs;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private Integer zipCode;
    @OrderBy("date")
    @OneToMany(mappedBy = "reciever", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayDate> receivedPlaydates;
    @OrderBy("date")
    @OneToMany(mappedBy = "requestor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PlayDate> requestedPlaydates;
//    private Integer milesWillingToDrive;

    // person can have many events
    // event can have many persons
    // person can have many messages
//    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Message> messages;

    public Person(){}

//    public Set<PlayDate> getAllPlaydates() {
//        // Received playdates + requested playdates
//        return this.receivedPlaydates + this.requestedPlaydates;
//    }

//
//    public String getUid() {
//        return uid;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }

    public Set<PlayDate> getReceivedPlaydates() {
        return receivedPlaydates;
    }

    public void setReceivedPlaydates(Set<PlayDate> receivedPlaydates) {
        this.receivedPlaydates = receivedPlaydates;
    }

    public Set<PlayDate> getRequestedPlaydates() {
        return requestedPlaydates;
    }

    public void setRequestedPlaydates(Set<PlayDate> requestedPlaydates) {
        this.requestedPlaydates = requestedPlaydates;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
  }

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

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }


    public Long getId() {
        return id;
    }


    public Long getResourceId() {
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

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Person) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
