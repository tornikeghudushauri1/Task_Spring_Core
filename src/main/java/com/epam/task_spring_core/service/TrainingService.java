package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TrainingDAO;
import com.epam.task_spring_core.model.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {
    private static final Logger logger = LoggerFactory.getLogger(TrainingService.class);

    private final TrainingDAO trainingDAO;

    public TrainingService(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    public void createTraining(Training training) {
        logger.info("Start creating Training");
        trainingDAO.save(training);
        logger.info("Created Training and saved");
    }

    public Training getTrainingById(String id) {
        return trainingDAO.findById(id);
    }

}