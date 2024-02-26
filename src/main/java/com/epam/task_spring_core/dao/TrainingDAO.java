package com.epam.task_spring_core.dao;

import com.epam.task_spring_core.model.Training;
import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component

public class TrainingDAO {

    private final InMemoryStorage storage;

    public TrainingDAO(InMemoryStorage storage) {
        this.storage = storage;
    }

    public void save(Training training) {
        storage.put("Training_" + training.getId(), training);
    }

    public Training findById(String id) {
        return (Training) storage.get("Training_" + id);
    }

    public void delete(String id) {
        storage.remove("Training_" + id);
    }

}