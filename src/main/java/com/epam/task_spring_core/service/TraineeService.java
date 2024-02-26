package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TraineeDAO;
import com.epam.task_spring_core.model.Trainee;
import com.epam.task_spring_core.util.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TraineeService {

    private static final Logger logger = LoggerFactory.getLogger(TraineeService.class);

    private TraineeDAO traineeDAO;


    public TraineeService(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    @Autowired
    public void setTraineeDAO(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public void createOrUpdateTrainee(Trainee trainee) {
        traineeDAO.save(trainee);
    }

    public Trainee getTraineeById(String id) {
        return traineeDAO.findById(id);
    }

    public void deleteTrainee(String id) {
        traineeDAO.delete(id);
    }

    public void createOrUpdateTraineeProfile(Trainee trainee) {
        logger.info("Start creating/updating Trainee profile");
        String username = calculateUsername(trainee.getUser().getFirstName(), trainee.getUser().getLastName());

        username = ensureUniqueUsername(username);

        String password = PasswordGenerator.generatePassword();

        trainee.getUser().setUsername(username);
        trainee.getUser().setPassword(password);

        traineeDAO.save(trainee);
        logger.info("End creating/updating Trainer profile");
    }

    private String calculateUsername(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase();
    }

    private String ensureUniqueUsername(String username) {
        String newUsername = username;
        int suffix = 1;
        while (!Objects.isNull(traineeDAO.findById(newUsername))) {
            newUsername = username + suffix;
            suffix++;
        }
        return newUsername;
    }

}