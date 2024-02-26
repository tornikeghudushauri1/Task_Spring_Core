package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TrainingDAO;
import com.epam.task_spring_core.model.Training;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrainingServiceTest {

    @Mock
    private TrainingDAO trainingDAO;

    @InjectMocks
    private TrainingService trainingService;

    @Test
    void testCreateTraining() {
        Training training = new Training();
        training.setId("1");

        trainingService.createTraining(training);

        verify(trainingDAO, times(1)).save(training);
    }

    @Test
    void testGetTrainingById() {
        String id = "1";
        Training training = new Training();
        training.setId(id);

        when(trainingDAO.findById(id)).thenReturn(training);

        Training result = trainingService.getTrainingById(id);

        assertEquals(training, result);
    }
}
