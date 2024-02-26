package com.epam.task_spring_core.storage;

public interface Storage {
    void put(String key, Object value);
    Object get(String key);
    void remove(String key);
}