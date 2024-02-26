package com.epam.task_spring_core.dao;

import com.epam.task_spring_core.model.TrainingType;
import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component

public class TrainingTypeDAO {

    private final InMemoryStorage storage;

    public TrainingTypeDAO(InMemoryStorage storage) {
        this.storage = storage;
    }

    public void save(TrainingType trainingType) {
        storage.put("TrainingType_" + trainingType.getId(), trainingType);
    }

    public TrainingType findById(String id) {
        return (TrainingType) storage.get("TrainingType_" + id);
    }

    public void delete(String id) {
        storage.remove("TrainingType_" + id);
    }

}