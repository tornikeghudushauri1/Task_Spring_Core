package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TrainerDAO;
import com.epam.task_spring_core.model.Trainer;
import com.epam.task_spring_core.util.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TrainerService {
    private static final Logger logger = LoggerFactory.getLogger(TrainerService.class);

    private final TrainerDAO trainerDAO;

    public TrainerService(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public void createOrUpdateTrainer(Trainer trainer) {
        trainerDAO.save(trainer);
    }

    public Trainer getTrainerById(String id) {
        return trainerDAO.findById(id);
    }

    public void deleteTrainer(String id) {
        trainerDAO.delete(id);
    }

    public void createOrUpdateTrainerProfile(Trainer trainer) {
        logger.info("Start creating/updating Trainer profile");
        String username = calculateUsername(trainer.getFirstName(), trainer.getLastName());

        username = ensureUniqueUsername(username);

        String password = PasswordGenerator.generatePassword();

        trainer.getUser().setUsername(username);
        trainer.getUser().setPassword(password);

        trainerDAO.save(trainer);
        logger.info("End creating/updating Trainer profile");
    }

    private String calculateUsername(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase();
    }

    private String ensureUniqueUsername(String username) {
        String newUsername = username;
        int suffix = 1;
        while (Objects.nonNull(trainerDAO.findById(newUsername))) {
            newUsername = username + suffix;
            suffix++;
        }
        return newUsername;
    }

}