package com.epam.task_spring_core.dao;

import com.epam.task_spring_core.model.Trainee;
import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component
public class TraineeDAO {

    private final InMemoryStorage storage;

    public TraineeDAO(InMemoryStorage storage) {
        this.storage = storage;
    }

    public void save(Trainee trainee) {
        storage.put("Trainee_" + trainee.getId(), trainee);
    }

    public Trainee findById(String id) {
        return (Trainee) storage.get("Trainee_" + id);
    }

    public void delete(String id) {
        storage.remove("Trainee_" + id);
    }

}