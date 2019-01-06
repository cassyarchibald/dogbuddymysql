package com.dogbuddyapi.dogbuddy.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "playdates")
public class PlayDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playdate_id")
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    @Column(name = "start_time")
    private java.util.Date startTime;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    @Column(name = "end_time")
    private java.util.Date endTime;
    private String city;
    private String state;
    @Column(name="zip_code")
    private String zipCode;
    private String location;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "requestor_id")
    private Person requestor;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reciever_id")
    private Person reciever;
    @Enumerated(EnumType.STRING)
    private Response status;

    // Might need this to format dates, we'll see
//    private String getDateTime() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        return dateFormat.format(date);
//    }

    // Setters and getters

    public Long getId() {
        return id;
    }

    public Long getResourceId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getStartTime() {
        return startTime;
    }

    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return endTime;
    }

    public void setEndTime(java.util.Date endTime) {
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

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((PlayDate) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
