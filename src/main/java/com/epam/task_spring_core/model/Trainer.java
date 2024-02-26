package com.epam.task_spring_core.model;

import java.util.Objects;

public class Trainer extends User {

    private String id;
    private String specialization;
    private User user;
    private Training training;

    public Trainer(String id, String specialization, User user, Training training) {
        this.id = id;
        this.specialization = specialization;
        this.user = user;
        this.training = training;
    }

    public Trainer() {}

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && Objects.equals(specialization, trainer.specialization) && Objects.equals(user, trainer.user) && Objects.equals(training, trainer.training);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialization, user, training);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", specialization='" + specialization + '\'' +
                ", user=" + user +
                ", training=" + training +
                '}';
    }
}