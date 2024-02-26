package com.epam.task_spring_core.model;

import java.util.Date;
import java.util.Objects;

public class Trainee extends User {

    private String id;
    private Date dateOfBirth;
    private String address;
    private User user;
    private Training training;

    public Trainee(String id, Date dateOfBirth, String address, User user, Training training) {
        super();
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.user = user;
        this.training = training;
    }

    public Trainee() {}

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(id, trainee.id) && Objects.equals(dateOfBirth, trainee.dateOfBirth) && Objects.equals(address, trainee.address) && Objects.equals(user, trainee.user) && Objects.equals(training, trainee.training);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfBirth, address, user, training);
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id='" + id + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", training=" + training +
                '}';
    }
}