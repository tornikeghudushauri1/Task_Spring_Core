package com.epam.task_spring_core.storage;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryStorage implements Storage {
    private final Map<String, Object> storageMap;

    public InMemoryStorage() {
        this.storageMap = new HashMap<>();
    }
    @Override
    public void put(String key, Object value) {
        storageMap.put(key, value);
    }

    @Override
    public Object get(String key) {
        return storageMap.get(key);
    }

    @Override
    public void remove(String key) {
        storageMap.remove(key);
    }
}