package com.epam.task_spring_core.service;

import com.epam.task_spring_core.dao.TrainerDAO;
import com.epam.task_spring_core.model.Trainer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {

    @Mock
    private TrainerDAO trainerDAO;

    @InjectMocks
    private TrainerService trainerService;


    @Test
    void testCreateOrUpdateTrainer() {
        Trainer trainer = new Trainer();
        trainer.setId("1");

        trainerService.createOrUpdateTrainer(trainer);

        verify(trainerDAO, times(1)).save(trainer);
    }

    @Test
    void testGetTrainerById() {
        String id = "1";
        Trainer trainer = new Trainer();
        trainer.setId(id);

        when(trainerDAO.findById(id)).thenReturn(trainer);

        Trainer result = trainerService.getTrainerById(id);

        assertEquals(trainer, result);
    }

    @Test
    void testDeleteTrainer() {
        String id = "1";

        trainerService.deleteTrainer(id);

        verify(trainerDAO, times(1)).delete(id);
    }

}
