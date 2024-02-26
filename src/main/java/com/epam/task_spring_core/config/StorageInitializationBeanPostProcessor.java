package com.epam.task_spring_core.config;

import com.epam.task_spring_core.storage.InMemoryStorage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@PropertySource("classpath:application.properties")
public class StorageInitializationBeanPostProcessor implements BeanPostProcessor {

    private final ResourceLoader resourceLoader;

    @Value("${data.file.path}")
    private String dataFilePath;

    public StorageInitializationBeanPostProcessor(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (bean instanceof InMemoryStorage) {
            initializeStorage((InMemoryStorage) bean);
        }
        return bean;
    }

    private void initializeStorage(InMemoryStorage storage) {
        try {
            Resource resource = resourceLoader.getResource("classpath:data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                storage.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize storage from file", e);
        }
    }
}