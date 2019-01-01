package com.dogbuddyapi.dogbuddy.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // must provide name, city, state, zip, about
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private Integer zipCode;
    private Integer milesWillingToDrive;
    @Column(nullable = false)
    private String about;
    private String photo;
    private Gender gender;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    // Person can have many dogs
    // do I need a join column here?
    private Set<Dog> dogs;
    // person can have many events
    @ManyToOne
    private Set<Event> events;
    // person can have many messages
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private Set<Message> messages;


    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }



    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
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
