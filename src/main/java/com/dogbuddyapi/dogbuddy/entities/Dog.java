package com.dogbuddyapi.dogbuddy.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @Column(name = "dog_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // must at least provide a name
    @Column(nullable = false)
    private String name;
    private Integer age;
    private Size size;
    private Boolean vaccinated;
    private String about;
    private String photo;
    private String breed;
    @Column(name = "preferred_play_buddy")
    private String preferredPlayBuddy;
    //private int person_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    // empty constructor for hibernate
    public Dog(){}
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long dog_id) {
        this.id = dog_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getPreferredPlayBuddy() {
        return preferredPlayBuddy;
    }

    public void setPreferredPlayBuddy(String preferredPlayBuddy) {
        this.preferredPlayBuddy = preferredPlayBuddy;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Dog) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
