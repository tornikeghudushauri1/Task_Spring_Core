package com.epam.task_spring_core.dao;

import com.epam.task_spring_core.model.Trainer;
import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component
public class TrainerDAO {

    private final InMemoryStorage storage;

    public TrainerDAO(InMemoryStorage storage) {
        this.storage = storage;
    }

    public void save(Trainer trainer) {
        storage.put("Trainer_" + trainer.getId(), trainer);
    }

    public Trainer findById(String id) {
        return (Trainer) storage.get("Trainer_" + id);
    }

    public void delete(String id) {
        storage.remove("Trainer_" + id);
    }

}