package com.dogbuddyapi.dogbuddy.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class PlayDate {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private java.sql.Date date;
    private java.sql.Time startTime;
    private java.sql.Time endTime;
    private String city;
    private String state;
    private String zipCode;
    private String location;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requestor_id")
    private Person requestor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reciever_id")
    private Person reciever;
    private Response status;
    @CreatedDate
    private long createdDate;

    // Setters and getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person getRequestor() {
        return requestor;
    }

    public void setRequestor(Person requestor) {
        this.requestor = requestor;
    }

    public Person getReciever() {
        return reciever;
    }

    public void setReciever(Person reciever) {
        this.reciever = reciever;
    }

    public Response getStatus() {
        return status;
    }

    public void setStatus(Response status) {
        this.status = status;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }
}
