package com.epam.task_spring_core.model;

import java.util.Date;
import java.util.Objects;

public class Training {
    private String id;
    private Trainee trainee;
    private Trainer trainer;
    private String name;
    private TrainingType trainingType;
    private Date trainingDate;
    private int duration;

    public Training(String id, Trainee trainee, Trainer trainer, String name, TrainingType trainingType, Date trainingDate, int duration) {
        this.id = id;
        this.trainee = trainee;
        this.trainer = trainer;
        this.name = name;
        this.trainingType = trainingType;
        this.trainingDate = trainingDate;
        this.duration = duration;
    }

    public Training() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return duration == training.duration && Objects.equals(id, training.id) && Objects.equals(trainee, training.trainee) && Objects.equals(trainer, training.trainer) && Objects.equals(name, training.name) && Objects.equals(trainingType, training.trainingType) && Objects.equals(trainingDate, training.trainingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainee, trainer, name, trainingType, trainingDate, duration);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id='" + id + '\'' +
                ", trainee=" + trainee +
                ", trainer=" + trainer +
                ", name='" + name + '\'' +
                ", trainingType=" + trainingType +
                ", trainingDate=" + trainingDate +
                ", duration=" + duration +
                '}';
    }
}