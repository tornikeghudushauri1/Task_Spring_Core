package com.epam.task_spring_core.dao;

import com.epam.task_spring_core.model.User;
import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    private final InMemoryStorage storage;

    public UserDAO(InMemoryStorage storage) {
        this.storage = storage;
    }

    public void save(User user) {
        storage.put("User_" + user.getId(), user);
    }

    public User findById(String id) {
        return (User) storage.get("User_" + id);
    }

    public void delete(String id) {
        storage.remove("User_" + id);
    }

}