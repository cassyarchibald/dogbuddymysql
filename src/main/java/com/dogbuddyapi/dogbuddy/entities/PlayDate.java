package com.dogbuddyapi.dogbuddy.entities;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
public class PlayDate {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    private Person requestor;
    @ManyToOne
    private Person responder;
    private Response status;
    @CreatedDate
    private long createdDate;
}
