package com.dogbuddyapi.dogbuddy.entities;


import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // must provide all fields
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String hostName;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private Integer zipCode;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private ZonedDateTime startTime;
    @Column(nullable = false)
    private ZonedDateTime endTime;

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }


    // organizer can create many events, delete events if host is deleted
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Person host;
    // event can have many participants,
    // if association is gone, remove the event
    // map from event to person
    @OneToMany(mappedBy = "event")
    private Set<Person> attendees;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Person getHost() {
        return host;
    }

    public void setHost(Person host) {
        this.host = host;
    }

    public Set<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<Person> attendees) {
        this.attendees = attendees;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Event) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
